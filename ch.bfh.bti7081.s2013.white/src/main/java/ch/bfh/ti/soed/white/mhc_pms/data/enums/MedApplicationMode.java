package ch.bfh.ti.soed.white.mhc_pms.data.enums;

public enum MedApplicationMode {
	OS, IV, SC, IM, topisch;

	/* (non-Javadoc)
	 * @see java.lang.Enum#toString()
	 */
	@Override
	public String toString() {
		switch (this) {
		case OS:
			return "per OS";
		case IV:
			return "I.V.";
		case SC:
			return "S.C.";
		case IM:
			return "I.M.";
		default:
			return super.toString();
		}
	}
	
}
