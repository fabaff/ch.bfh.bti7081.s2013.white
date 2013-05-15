package ch.bfh.ti.soed.white.mhc_pms.security;

class ExtendedMedicalStaffPermission extends MedicalStaffPermission {

	protected ExtendedMedicalStaffPermission() {
		this.isNewPatientAllowed = true;
		this.isNewCaseAllowed = true;
		this.isCloseCaseAllowed = true;
	}
}
