package ch.bfh.ti.soed.white.mhc_pms.data;

/**
 * This class provides global access to a DataAccess object. This class cannot
 * be instanced.
 * 
 * @author Group White, I2p, BFH Berne, <a
 *         href="https://github.com/fabaff/ch.bfh.bti7081.s2013.white"
 *         >Contact</a>
 * @version 1.0.0
 * 
 */
public final class PmsDataAccessCreator {

	// create data access for dummy user
	private static PmsDataAccess dataAccess;
	
	public static final String DUMMY_USER = "user";

	public static final String PERSISTENCE_UNIT = "ch.bfh.bti7081.s2013.white";

	/**
	 * Gets the current data access object.
	 * 
	 * @return the current set data access objet
	 * @throws UnknownUserException 
	 */
	public static PmsDataAccess getDataAccess() throws UnknownUserException {
		if (dataAccess == null) {
			dataAccess = new PmsDataAccess(DUMMY_USER);
		}
		return dataAccess;
	}

	/**
	 * Sets a new data access object.
	 * 
	 * @param dataAc
	 *            the new data access object
	 */
	public static void setDataAccess(PmsDataAccess dataAc) {
		if (dataAc != null) {
			dataAccess = dataAc;
		}
	}

	private PmsDataAccessCreator() {
	}
}
