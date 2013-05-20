package ch.bfh.ti.soed.white.mhc_pms.security;

class AdminStaffPermission extends NursePermission {

	protected AdminStaffPermission(String userName) {
		super(userName);
		this.isNewPatientAllowed = true;
		this.isNewCaseAllowed = true;
	}
	
}
