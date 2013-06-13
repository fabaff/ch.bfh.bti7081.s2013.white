package ch.bfh.ti.soed.white.mhc_pms.data.enums;

/**
 * Application mode of the medication
 * 
 * @author Group White, I2p, BFH Berne, <a href="https://github.com/fabaff/ch.bfh.bti7081.s2013.white">Contact</a>
 * @version 1.0.0
 */
public enum MedApplicationMode {
	UNSET(" "),
	OS("per OS"),
	IV("I.V."),
	SC("S.C."),
	IM("I.M."),
	TOPICAL("topisch");

	private String stringValue;

	private MedApplicationMode(String stringValue) {
		this.stringValue = stringValue;
	}

	/* (non-Javadoc)
	 * @see java.lang.Enum#toString()
	 */
	@Override
	public String toString() {
		return this.stringValue;
	}
	
}
