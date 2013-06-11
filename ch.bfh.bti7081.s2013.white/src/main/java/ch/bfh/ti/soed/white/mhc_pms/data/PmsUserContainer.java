package ch.bfh.ti.soed.white.mhc_pms.data;

import com.vaadin.addon.jpacontainer.filter.Filters;

/**
 * @author		Gruppe White, I2p, BFH Bern, <a href="https://github.com/fabaff/ch.bfh.bti7081.s2013.white">Contact</a>
 * @version		0.0.2 
 * @since		0.0.1
 * 
 * Entity implementation class for Entity: PmsUserContainer
 */
public class PmsUserContainer extends PmsContainer<PmsUser> {

	private static final long serialVersionUID = -6061413589999422421L;

	private static Object USER_FILTER_PROPERTY_ID = "userName";
	
	public PmsUserContainer(Class<PmsUser> clazz) {
		super(clazz);
	}

	public PmsUser getCurrentUser(String userName) {
		Filter filter = Filters.eq(USER_FILTER_PROPERTY_ID, userName);
		this.addContainerFilter(filter);
		
		if (this.size() != 0) {
			PmsUser user = this.getItem(this.firstItemId()).getEntity();
			this.removeContainerFilters(filter);
			return user;
		} else {
			// TODO remove default init
			return new PmsUser();
//			try {
//				// TODO Exception Handling -> show error message
//				throw new RuntimeException("User not found in database!");
//			} catch (Exception e) {
//				throw e;
//			} finally {
//				this.removeContainerFilters(filter);
//			}
		}
	}

	public boolean checkLogin(String userName, String password) {
		Filter userFilter = Filters.eq("userName", userName);
		Filter passWordFilter = Filters.eq("password", password);
		
		this.addContainerFilter(userFilter);
		this.addContainerFilter(passWordFilter);
		Object id = this.firstItemId();
		this.removeContainerFilters(userFilter);
		this.removeContainerFilters(passWordFilter);
		
		return id != null;
	}

}
