package ch.bfh.ti.soed.white.mhc_pms.data;

import com.vaadin.addon.jpacontainer.filter.Filters;

public class PmsUserContainer extends PmsContainer<PmsUser> {

	private static final long serialVersionUID = -6061413589999422421L;

	public PmsUserContainer(Class<PmsUser> clazz) {
		super(clazz);
	}

	public PmsUser getCurrentUser(String userName) {
		//this.addContainerFilter(Filters.eq("userName", userName));
		// TODO current user from db
		
		return new PmsUser();
	}

}
