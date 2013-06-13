package ch.bfh.ti.soed.white.mhc_pms.data.enums;

/**
 * @author Group White, I2p, BFH Berne, <a
 *         href="https://github.com/fabaff/ch.bfh.bti7081.s2013.white"
 *         >Contact</a>
 * @version 1.0.0
 * 
 */
public enum FilterEnum {
	
	CURRENT("aktuelle Fälle"), ALL("alle Fälle");
	
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
