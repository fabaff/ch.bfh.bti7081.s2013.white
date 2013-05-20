package ch.bfh.ti.soed.white.mhc_pms.security;

import java.util.HashMap;
import java.util.Map;

public class UIPermissionInstance {

	// TODO userName und permission initialisieren
	private static String userName = "user";
	
	private static Map<String, UIPermission> permissionsMap;
	
	private static UIPermission permission;

	static {
		permissionsMap = new HashMap<String, UIPermission>();
		permissionsMap.put(PsychiatristPermission.class.getName(), new PsychiatristPermission(userName));
		permissionsMap.put(TherapistPermission.class.getName(), new TherapistPermission(userName));
		permissionsMap.put(AdminStaffPermission.class.getName(), new AdminStaffPermission(userName));
		permissionsMap.put(NursePermission.class.getName(), new NursePermission(userName));
	}

	public static UIPermission getPermission() {
		if (permission == null) {
			// TODO userName und permission initialisieren
			permission = new TherapistPermission(userName);
		}
		return permission;
	}

	private UIPermissionInstance() {}
}
