package ch.bfh.ti.soed.white.mhc_pms.data;

/**
 * @author Group White, I2p, BFH Berne, <a
 *         href="https://github.com/fabaff/ch.bfh.bti7081.s2013.white"
 *         >Contact</a>
 * @version 1.0.0
 * 
 */
public class PmsDataAccess {

	private PmsUserContainer pmsUserContainer;
	
	private PmsContainer<PCase> pCaseContainer;
	
	private PmsEntityContainer<Diagnosis> diagnosisContainer;
	
	private PmsUser currentUser;
	
	public PmsDataAccess(String userName) {
		this.pmsUserContainer = new PmsUserContainer(PmsUser.class);
		this.pCaseContainer = new PmsContainer<>(PCase.class);
		this.diagnosisContainer = new PmsEntityContainer<>(Diagnosis.class);
		
		this.currentUser = this.pmsUserContainer.getUser(userName);
	}
	
	public PmsUser getCurrentUser() {
		return this.currentUser;
	}

	/**
	 * @return the pCaseContainer
	 */
	public PmsContainer<PCase> getPCaseContainer() {
		return this.pCaseContainer;
	}

	/**
	 * @return the diagnosisContainer
	 */
	public PmsEntityContainer<Diagnosis> getDiagnosisContainer() {
		return this.diagnosisContainer;
	}

	/**
	 * @return the pmsUserContainer
	 */
	public PmsUserContainer getPmsUserContainer() {
		return pmsUserContainer;
	}

	
}
