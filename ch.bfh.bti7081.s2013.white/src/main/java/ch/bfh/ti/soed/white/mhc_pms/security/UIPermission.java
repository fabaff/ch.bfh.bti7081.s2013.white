package ch.bfh.ti.soed.white.mhc_pms.security;

public abstract class UIPermission {

	protected boolean isNewPatientAllowed = false;
	protected boolean isNewCaseAllowed = false;
	protected boolean isCloseCaseAllowed = false;
	
	public boolean isNewPatientAllowed() {
		return this.isNewPatientAllowed;
	}

	public boolean isNewCaseAllowed() {
		return this.isNewCaseAllowed;
	}

	public boolean isCloseCaseAllowed() {
		return this.isCloseCaseAllowed;
	}

}
