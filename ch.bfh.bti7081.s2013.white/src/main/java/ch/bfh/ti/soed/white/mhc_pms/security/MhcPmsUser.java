package ch.bfh.ti.soed.white.mhc_pms.security;

import ch.bfh.ti.soed.white.mhc_pms.data.MhcPmsDataAccess;
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
	
	public <E extends MhcPmsItem> boolean incrementCurrentItem(Class<E> clazz) {
		return false;
	}

	public <E extends MhcPmsItem> boolean decrementCurrentItem(Class<E> clazz) {
		return false;
	}

	public <E extends MhcPmsItem> boolean setCurrentItem(Class<E> clazz, Object value) {
		return false;
	}

	public final UIPermission getUIPermission() {
		return this.uiPermission;
	}

}
