package ch.bfh.ti.soed.white.mhc_pms.security;

class ExtendedMedicalStaffPermission extends UIPermission {

	protected ExtendedMedicalStaffPermission() {
		this.isNewPatientAllowed = true;
		this.isNewCaseAllowed = true;
	}
}
