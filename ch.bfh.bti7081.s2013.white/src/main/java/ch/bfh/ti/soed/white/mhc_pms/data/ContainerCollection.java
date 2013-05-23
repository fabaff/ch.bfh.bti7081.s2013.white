package ch.bfh.ti.soed.white.mhc_pms.data;


public class ContainerCollection {

	private PmsUserContainer pmsUserContainer;
	
	private PmsContainer<PCase> pCaseContainer;
	
	private PmsContainer<Diagnosis> diagnosisContainer;
	
	private PmsUser currentUser;
	
	public ContainerCollection(String userName) {
		this.pmsUserContainer = new PmsUserContainer(PmsUser.class);
		this.pCaseContainer = new PmsContainer<>(PCase.class);
		this.diagnosisContainer = new PmsContainer<>(Diagnosis.class);
		
		this.currentUser = this.pmsUserContainer.getCurrentUser(userName);
	}
	
	public PmsUser getCurrentUser() {
		return this.currentUser;
	}

	/**
	 * @return the pmsUserContainer
	 */
	public PmsUserContainer getPmsUserContainer() {
		return  this.pmsUserContainer;
	}

	/**
	 * @return the pCaseContainer
	 */
	public PmsContainer<PCase> getPCaseContainer() {
		return  this.pCaseContainer;
	}

	/**
	 * @return the diagnosisContainer
	 */
	public PmsContainer<Diagnosis> getDiagnosisContainer() {
		return  this.diagnosisContainer;
	}

}
