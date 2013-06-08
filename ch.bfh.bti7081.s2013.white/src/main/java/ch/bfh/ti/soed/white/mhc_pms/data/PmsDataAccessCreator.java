package ch.bfh.ti.soed.white.mhc_pms.data;

/**
 * @author		Gruppe White, I2p, BFH Bern, <a href="https://github.com/fabaff/ch.bfh.bti7081.s2013.white">Contact</a>
 * @version		0.0.2 
 * @since		0.0.1
 * 
 * Entity implementation class for Entity: PmsDataAccessCreator

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
