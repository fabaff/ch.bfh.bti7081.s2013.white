package ch.bfh.ti.soed.white.mhc_pms.security;

class AdminStaffPermission extends Nurse {

	protected AdminStaffPermission() {
		this.isNewPatientAllowed = true;
		this.isNewCaseAllowed = true;
	}
}
