package ch.bfh.ti.soed.white.mhc_pms.security;

public interface UIPermission {
	boolean isNewPatientAllowed();
	boolean isNewCaseAllowed();
	boolean isNewDiagnosisAllowed() ;
	boolean isNewMedicationAllowed();
	boolean isEditCaseDataAllowed();
	boolean isNewPatientProgressEntryAllowed();
	boolean isEditPatientProgressEntryAllowed();
	boolean isDeletePatientProgressEntryAllowed();
	boolean isEditDiagnosisAllowed();
	boolean isDeleteDiagnosisAllowed();
	boolean isEditMedicationAllowed();
	boolean isDeleteMedicationAllowed();
	
	String getUserName();
}
