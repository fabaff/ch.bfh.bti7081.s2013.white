package ch.bfh.ti.soed.white.mhc_pms.security;

import java.util.HashMap;
import java.util.Map;

class UIPermissionFactory {

	private static Map<String, UIPermission> permissionsMap;

	static {
		permissionsMap = new HashMap<String, UIPermission>();
		permissionsMap.put(Psychiatrist.class.getName(), new PsychiatristPermission());
		permissionsMap.put(Therapist.class.getName(), new TherapistPermission());
		permissionsMap.put(ExtendedMedicalStaff.class.getName(), new ExtendedMedicalStaffPermission());
		permissionsMap.put(MedicalStaff.class.getName(), new UIPermission());
	}

	static <E extends MhcPmsUser> UIPermission createUIState(Class<E> clazz) {
		return permissionsMap.get(clazz.getName());
	}

}
