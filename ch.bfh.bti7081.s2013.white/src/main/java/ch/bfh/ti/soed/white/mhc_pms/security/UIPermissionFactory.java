package ch.bfh.ti.soed.white.mhc_pms.security;

import java.util.HashMap;
import java.util.Map;

class UIPermissionFactory<E extends MhcPmsUser> {

	private Map<String, UIPermission> permissionsMap;
	
	protected UIPermissionFactory() {
		this.permissionsMap = new HashMap<String, UIPermission>();
		this.permissionsMap.put(MedicalStaff.class.getName(), new MedicalStaffPermission());
		this.permissionsMap.put(ExtendedMedicalStaff.class.getName(), new ExtendedMedicalStaffPermission());
		this.permissionsMap.put(Therapist.class.getName(), new TherapistPermission());
		this.permissionsMap.put(Psychiatrist.class.getName(), new PsychiatristPermission());
	}
	
	protected UIPermission createUIState(Class<E> clazz) {
		return this.permissionsMap.get(clazz.getName());
	}
}
