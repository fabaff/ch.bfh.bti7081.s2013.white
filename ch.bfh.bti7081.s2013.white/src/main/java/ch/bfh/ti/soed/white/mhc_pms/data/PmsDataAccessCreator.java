package ch.bfh.ti.soed.white.mhc_pms.data;

/**
 * @author Group White, I2p, BFH Berne, <a
 *         href="https://github.com/fabaff/ch.bfh.bti7081.s2013.white"
 *         >Contact</a>
 * @version 1.0.0
 * 
 */
public final class PmsDataAccessCreator {

	public static final String PERSISTENCE_UNIT = "ch.bfh.bti7081.s2013.white";

	// create data access for dummy user
	private static PmsDataAccess pmsContainers = new PmsDataAccess("user");
	
	public static PmsDataAccess getDataAccess() {
		return pmsContainers;
	}
	
	public static void setDataAccess(PmsDataAccess pmsCont) {
		if (pmsCont != null) {
			pmsContainers = pmsCont;
		}
	}
	
	private PmsDataAccessCreator() {}
}
