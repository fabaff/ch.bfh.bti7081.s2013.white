package ch.bfh.ti.soed.white.mhc_pms.security;

class PsychiatristPermission extends TherapistPermission {
	
	protected PsychiatristPermission(String userName) {
		super(userName);
		this.isNewMedicationAllowed = true;
		this.isEditMedicationAllowed = true;
		this.isDeleteMedicationAllowed = true;
	}
}
