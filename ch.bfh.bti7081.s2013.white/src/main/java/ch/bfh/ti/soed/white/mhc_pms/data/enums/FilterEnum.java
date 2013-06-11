package ch.bfh.ti.soed.white.mhc_pms.data.enums;

public enum FilterEnum {
	
	CURRENT("aktueller Fall"), ALL("alle Fälle");
	
	private String stringValue;

	private FilterEnum(String stringValue) {
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
