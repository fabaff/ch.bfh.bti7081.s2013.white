package ch.bfh.ti.soed.white.mhc_pms.data.enums;

/**
 * @author		Gruppe White, I2p, BFH Bern, <a href="https://github.com/fabaff/ch.bfh.bti7081.s2013.white">Contact</a>
 * @version		0.0.2 
 * @since		0.0.2
 * 
 * Medication units
 */
public enum MedicationUnit {
	UNSET(" "), DRIP("Tropfen"), ML("ml"), MG("mg"), APPLICATION("Applikation");
	
	private String stringValue;

	private MedicationUnit(String stringValue) {
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
