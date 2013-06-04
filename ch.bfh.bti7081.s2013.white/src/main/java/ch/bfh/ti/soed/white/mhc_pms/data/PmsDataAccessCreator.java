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

	// create dummy user
	private static ContainerCollection pmsContainers = new ContainerCollection("user");
	
	public static ContainerCollection getContainers() {
		return pmsContainers;
	}
	
	public static void setContainers(ContainerCollection pmsCont) {
		if (pmsCont != null) {
			pmsContainers = pmsCont;
		}
	}
	
	private PmsDataAccessCreator() {}
}
