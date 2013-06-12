package ch.bfh.ti.soed.white.mhc_pms.data.enums;

/**
 * Status of reanimation for a case
 * 
 * @author Group White, I2p, BFH Berne, <a
 *         href="https://github.com/fabaff/ch.bfh.bti7081.s2013.white"
 *         >Contact</a>
 * @version 1.0.0
 * 
 */
public enum ReanimationStatus {
	UNSET("unbekannt"), YES("ja"), LIMITED("eingeschränkt"), NO("nein");
	
	private String stringValue;

	private ReanimationStatus(String stringValue) {
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
