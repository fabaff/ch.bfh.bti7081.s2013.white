package ch.bfh.ti.soed.white.mhc_pms.data.enums;

public enum MedicationStatus {
	
	PRESCRIBED("verordnet"), PAUSED("pausiert"), OPEN("offen"), STOPPED("gestoppt"), REFUSED("verweigert");
	
	private String stringValue;

	private MedicationStatus(String stringValue) {
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
