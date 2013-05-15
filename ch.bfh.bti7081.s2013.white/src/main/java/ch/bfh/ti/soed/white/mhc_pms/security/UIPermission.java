package ch.bfh.ti.soed.white.mhc_pms.security;

public abstract class UIPermission {

	protected boolean isNewPatientAllowed = false;
	protected boolean isNewCaseAllowed = false;
	protected boolean isNewDiagnosisAllowed = false;
	protected boolean isNewMedicationAllowed = false;
	
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

}
