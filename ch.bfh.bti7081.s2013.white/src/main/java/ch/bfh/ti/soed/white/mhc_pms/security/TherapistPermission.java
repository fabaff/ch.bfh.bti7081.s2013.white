package ch.bfh.ti.soed.white.mhc_pms.security;

class TherapistPermission extends ExtendedMedicalStaffPermission {

	protected TherapistPermission() {
		super();
		this.isNewDiagnosisAllowed = true;
	}
}
