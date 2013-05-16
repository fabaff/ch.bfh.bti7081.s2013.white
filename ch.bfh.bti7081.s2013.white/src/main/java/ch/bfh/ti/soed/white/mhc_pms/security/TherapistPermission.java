package ch.bfh.ti.soed.white.mhc_pms.security;

class TherapistPermission extends ExtendedMedicalStaffPermission {

	protected TherapistPermission() {
		this.isEditCaseDataAllowed = true;
		this.isNewPatientProgressEntryAllowed = true;
		this.isEditPatientProgressEntryAllowed = true;
		this.isDeletePatientProgressEntryAllowed = true;
		this.isNewDiagnosisAllowed = true;
		this.isEditDiagnosisAllowed = true;
		this.isDeleteDiagnosisAllowed = true;
	}
}
