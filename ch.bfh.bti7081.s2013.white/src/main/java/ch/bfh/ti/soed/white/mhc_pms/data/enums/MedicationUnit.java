package ch.bfh.ti.soed.white.mhc_pms.data.enums;

public enum MedicationUnit {
	DRIP("Tropfen"), ML("ml"), MG("mg"), APPLICATION("Applikation");
	
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
