package ch.bfh.ti.soed.white.mhc_pms.security;

class UIPermissionFactory {

	static <E extends MhcPmsUser> UIPermission getUIState(Class<E> clazz) {
		return new PsychiatristPermission();
	}
	
	private UIPermissionFactory() {
		// TODO
	}
}
