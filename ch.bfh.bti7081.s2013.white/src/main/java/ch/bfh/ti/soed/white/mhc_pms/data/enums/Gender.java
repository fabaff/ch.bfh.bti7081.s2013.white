package ch.bfh.ti.soed.white.mhc_pms.data.enums;

/**
 * Gender of the patient 
 * 
 * @author Group White, I2p, BFH Berne, <a
 *         href="https://github.com/fabaff/ch.bfh.bti7081.s2013.white"
 *         >Contact</a>
 * @version 1.0.0
 * 
 */
public enum Gender {
	UNSET("unbekannt"), FEMALE("weiblich"), MALE("männlich");
	
	private String stringValue;

	private Gender(String stringValue) {
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
