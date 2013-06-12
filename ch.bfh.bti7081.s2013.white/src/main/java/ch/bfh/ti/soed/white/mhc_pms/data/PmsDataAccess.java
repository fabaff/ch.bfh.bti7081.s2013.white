package ch.bfh.ti.soed.white.mhc_pms.data;

/**
 * This class gives access to the diffrent entity containers and the current user.
 * 
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
	private PmsEntityContainer<PatientProgress> patientProgressContainer;
	private PmsEntityContainer<Medication> medicationContainer;
	private PmsEntityContainer<MedicationDate> medicationDateContainer;
	private PmsEntityContainer<MedicationTime> medicationTimeContainer;
	
	private PmsUser currentUser;
	
	/**
	 * Creates a new PmsDataAccess object with the given user name.
	 * 
	 * @param userName a valid user Name
	 * @throws UnknownUserException if the user name is not valid
	 */
	public PmsDataAccess(String userName) throws UnknownUserException {
		this.pmsUserContainer = new PmsUserContainer(PmsUser.class);
		this.pCaseContainer = new PmsContainer<>(PCase.class);
		this.diagnosisContainer = new PmsEntityContainer<>(Diagnosis.class);
		this.patientProgressContainer = new PmsEntityContainer<>(PatientProgress.class);
		this.medicationContainer = new PmsEntityContainer<>(Medication.class);
		this.medicationDateContainer = new PmsEntityContainer<>(MedicationDate.class);
		this.medicationTimeContainer = new PmsEntityContainer<>(MedicationTime.class);
		
		// if the user name is invalid, throw an exception
		this.currentUser = this.pmsUserContainer.getUser(userName);
		if (this.currentUser == null) {
			throw new UnknownUserException("Invalid user name: " + userName + "!", userName);
		}
	}
	
	/**
	 * 
	 * @return current user object
	 */
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

	/**
	 * @return the patientProgressContainer
	 */
	public PmsEntityContainer<PatientProgress> getPatientProgressContainer() {
		return patientProgressContainer;
	}

	/**
	 * @return the medicationContainer
	 */
	public PmsEntityContainer<Medication> getMedicationContainer() {
		return medicationContainer;
	}

	/**
	 * @return the medicationDateContainer
	 */
	public PmsEntityContainer<MedicationDate> getMedicationDateContainer() {
		return medicationDateContainer;
	}

	/**
	 * @return the medicationTimeContainer
	 */
	public PmsEntityContainer<MedicationTime> getMedicationTimeContainer() {
		return medicationTimeContainer;
	}

	
}
