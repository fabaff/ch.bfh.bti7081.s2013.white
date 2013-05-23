package ch.bfh.ti.soed.white.mhc_pms.data;

import com.vaadin.addon.jpacontainer.filter.Filters;

public class PmsUserContainer extends PmsContainer<PmsUser> {

	private static final long serialVersionUID = -6061413589999422421L;

	public PmsUserContainer(Class<PmsUser> clazz) {
		super(clazz);
	}

	public PmsUser getCurrentUser(String userName) {
		Filter filter = Filters.eq("userName", userName);
		this.addContainerFilter(filter);
		
		if (this.size() != 0) {
			PmsUser user = this.getItem(this.firstItemId()).getEntity();
			this.removeContainerFilters(filter);
			return user;
		} else {
			try {
				// TODO Exception Handling -> show error message
				throw new RuntimeException("User not found in database!");
			} catch (Exception e) {
				throw e;
			} finally {
				this.removeContainerFilters(filter);
			}
		}
	}

}
