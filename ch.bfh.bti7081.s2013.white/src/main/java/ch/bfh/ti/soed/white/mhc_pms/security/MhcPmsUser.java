package ch.bfh.ti.soed.white.mhc_pms.security;

import ch.bfh.ti.soed.white.mhc_pms.data.MhcPmsItem;

/**
 * 
 * @author Patrick Kofmel
 *
 */
public abstract class MhcPmsUser {

	private UIPermission uiPermission;
	
	protected MhcPmsDataAccess dataAccess;
	
	protected <E extends MhcPmsUser> MhcPmsUser(Class<E> clazz) {
		UIPermissionFactory<E> uiPermissionFactory = new UIPermissionFactory<>();
		this.uiPermission = uiPermissionFactory.createUIState(clazz);
		this.dataAccess = MhcPmsDataAccess.getInstance();
	}
	
	public <E extends MhcPmsItem> void  incrementCurrentItem(Class<E> clazz) {}

	public <E extends MhcPmsItem> void decrementCurrentItem(Class<E> clazz) {}

	public <E extends MhcPmsItem> void setCurrentItem(Class<E> clazz, Object value) {}

	public final UIPermission getUIPermission() {
		return this.uiPermission;
	}

}
