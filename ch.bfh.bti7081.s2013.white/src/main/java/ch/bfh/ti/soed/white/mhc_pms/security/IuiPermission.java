package ch.bfh.ti.soed.white.mhc_pms.security;

public interface IuiPermission {
	public boolean isNewPatientAllowed();
	public boolean isNewCaseAllowed();
	public boolean isNewDiagnosisAllowed() ;
	public boolean isNewMedicationAllowed();
	public boolean isEditCaseDataAllowed();
	public boolean isNewPatientProgressEntryAllowed();
	public boolean isEditPatientProgressEntryAllowed();
	public boolean isDeletePatientProgressEntryAllowed();
	public boolean isEditDiagnosisAllowed();
	public boolean isDeleteDiagnosisAllowed();
	public boolean isEditMedicationAllowed();
	public boolean isDeleteMedicationAllowed();
}
