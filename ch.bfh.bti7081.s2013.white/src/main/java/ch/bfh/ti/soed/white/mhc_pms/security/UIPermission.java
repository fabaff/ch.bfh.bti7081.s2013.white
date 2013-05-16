package ch.bfh.ti.soed.white.mhc_pms.security;

public class UIPermission {

	protected boolean isNewPatientAllowed = false;
	protected boolean isNewCaseAllowed = false;
	protected boolean isEditCaseDataAllowed = false;
	protected boolean isNewPatientProgressEntryAllowed = false;
	protected boolean isEditPatientProgressEntryAllowed = false;
	protected boolean isDeletePatientProgressEntryAllowed = false;
	protected boolean isNewDiagnosisAllowed = false;
	protected boolean isEditDiagnosisAllowed = false;
	protected boolean isDeleteDiagnosisAllowed = false;
	protected boolean isNewMedicationAllowed = false;
	protected boolean isEditMedicationAllowed = false;
	protected boolean isDeleteMedicationAllowed = false;
	
	public boolean isNewPatientAllowed() {
		return this.isNewPatientAllowed;
	}

	public boolean isNewCaseAllowed() {
		return this.isNewCaseAllowed;
	}

	public boolean isNewDiagnosisAllowed() {
		return this.isNewDiagnosisAllowed;
	}

	public boolean isNewMedicationAllowed() {
		return this.isNewMedicationAllowed;
	}

	/**
	 * @return the isEditCaseDataAllowed
	 */
	public boolean isEditCaseDataAllowed() {
		return isEditCaseDataAllowed;
	}

	/**
	 * @return the isNewPatientProgressEntryAllowed
	 */
	public boolean isNewPatientProgressEntryAllowed() {
		return isNewPatientProgressEntryAllowed;
	}

	/**
	 * @return the isEditPatientProgressEntryAllowed
	 */
	public boolean isEditPatientProgressEntryAllowed() {
		return isEditPatientProgressEntryAllowed;
	}

	/**
	 * @return the isDeletePatientProgressEntryAllowed
	 */
	public boolean isDeletePatientProgressEntryAllowed() {
		return isDeletePatientProgressEntryAllowed;
	}

	/**
	 * @return the isEditDiagnosisAllowed
	 */
	public boolean isEditDiagnosisAllowed() {
		return isEditDiagnosisAllowed;
	}

	/**
	 * @return the isDeleteDiagnosisAllowed
	 */
	public boolean isDeleteDiagnosisAllowed() {
		return isDeleteDiagnosisAllowed;
	}

	/**
	 * @return the isEditMedicationAllowed
	 */
	public boolean isEditMedicationAllowed() {
		return isEditMedicationAllowed;
	}

	/**
	 * @return the isDeleteMedicationAllowed
	 */
	public boolean isDeleteMedicationAllowed() {
		return isDeleteMedicationAllowed;
	}

}
