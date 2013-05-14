package ch.bfh.ti.soed.white.mhc_pms.security;

import ch.bfh.ti.soed.white.mhc_pms.model.MhcPmsItem;

/**
 * 
 * @author Patrick Kofmel
 *
 */
public abstract class MhcPmsUser {

	private UIPermission uiPermission;
	
	protected <E extends MhcPmsUser> MhcPmsUser(Class<E> clazz) {
		this.uiPermission = UIPermissionFactory.getUIState(clazz);
	}
	
	public <E extends MhcPmsItem> void  incrementCurrentItem(Class<E> clazz) {
		// TODO Auto-generated method stub
		
	}

	public <E extends MhcPmsItem> void decrementCurrentItem(Class<E> clazz) {
		// TODO Auto-generated method stub
	}

	public <E extends MhcPmsItem> void setCurrentItem(Class<E> clazz, Object value) {
		// TODO Auto-generated method stub
	}

	public UIPermission getUIPermission() {
		return this.uiPermission;
	}

}
