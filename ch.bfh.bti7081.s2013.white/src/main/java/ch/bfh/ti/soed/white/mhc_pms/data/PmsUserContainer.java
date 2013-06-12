package ch.bfh.ti.soed.white.mhc_pms.data;

import com.vaadin.addon.jpacontainer.filter.Filters;

/**
 * A container class for PmsUser entity objects. This class extends the
 * PmsContainer class.
 * 
 * @author Group White, I2p, BFH Berne, <a
 *         href="https://github.com/fabaff/ch.bfh.bti7081.s2013.white"
 *         >Contact</a>
 * @version 1.0.0
 * 
 */
public class PmsUserContainer extends PmsContainer<PmsUser> {

	private static final long serialVersionUID = -6061413589999422421L;

	private static Object USER_FILTER_PROPERTY_ID = "userName";
	private static Object PASSWORD_FILTER_PROPERTY_ID = "password";

	/**
	 * 
	 * @param clazz
	 *            PmsUser entity class object
	 */
	public PmsUserContainer(Class<PmsUser> clazz) {
		super(clazz);
	}

	/**
	 * Filters the container based on the given user name and returns the
	 * corresponding PmsUser Object. If no object is founded, the return value
	 * is null.
	 * 
	 * @param userName
	 * @return the corresponding PmsUser entity object or null
	 */
	public PmsUser getUser(String userName) {
		Filter filter = Filters.eq(USER_FILTER_PROPERTY_ID, userName);
		this.addContainerFilter(filter);

		if (this.size() != 0) {
			PmsUser user = this.getItem(this.firstItemId()).getEntity();
			this.removeContainerFilters(filter);
			return user;
		} else {
			this.removeContainerFilters(filter);
			return null;
		}
	}

	/**
	 * Checks if the given user name and password belongs to a valid user.
	 * 
	 * @param userName
	 * @param password
	 * @return true, if the user name and password belongs to a valid User, false otherwise.
	 */
	public boolean checkLogin(String userName, String password) {
		Filter userFilter = Filters.eq(USER_FILTER_PROPERTY_ID, userName);
		Filter passWordFilter = Filters.eq(PASSWORD_FILTER_PROPERTY_ID,
				password);

		this.addContainerFilter(userFilter);
		this.addContainerFilter(passWordFilter);
		Object id = this.firstItemId();
		this.removeContainerFilters(userFilter);
		this.removeContainerFilters(passWordFilter);

		return id != null;
	}

}
