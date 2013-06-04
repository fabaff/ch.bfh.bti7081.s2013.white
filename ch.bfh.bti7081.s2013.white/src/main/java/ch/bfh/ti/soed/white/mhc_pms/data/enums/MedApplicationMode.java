package ch.bfh.ti.soed.white.mhc_pms.data.enums;

/**
 * @author		Gruppe White, I2p, BFH Bern, <a href="https://github.com/fabaff/ch.bfh.bti7081.s2013.white">Contact</a>
 * @version		0.0.2 
 * @since		0.0.2
 * 
 * Application mode of the medication
 */
public enum MedApplicationMode {
	UNSET(" "), OS("per OS"), IV("I.V."), SC("S.C."), IM("I.M."), TOPICAL("topisch");

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
