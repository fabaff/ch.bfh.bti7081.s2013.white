package ch.bfh.ti.soed.white.mhc_pms.data.enums;

/**
 * @author		Gruppe White, I2p, BFH Bern, <a href="https://github.com/fabaff/ch.bfh.bti7081.s2013.white">Contact</a>
 * @version		0.0.2 
 * @since		0.0.1
 * 
 * Gender of the patient
 */
public enum Gender {
	FEMALE("weiblich"), MALE("männlich");
	
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
