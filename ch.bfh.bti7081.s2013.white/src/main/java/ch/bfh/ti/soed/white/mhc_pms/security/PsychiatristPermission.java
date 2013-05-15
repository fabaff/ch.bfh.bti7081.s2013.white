package ch.bfh.ti.soed.white.mhc_pms.security;

class PsychiatristPermission extends TherapistPermission {
	
	protected PsychiatristPermission() {
		super();
		this.isNewMedicationAllowed = true;
	}
}
