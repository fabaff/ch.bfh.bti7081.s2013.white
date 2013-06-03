package ch.bfh.ti.soed.white.mhc_pms.data.enums;

public enum MedApplicationMode {
	OS("per OS"), IV("I.V."), SC("S.C."), IM("I.M."), TOPICAL("topisch");

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
