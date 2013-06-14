package ch.bfh.ti.soed.white.mhc_pms.data;

import ch.bfh.ti.soed.white.mhc_pms.security.PmsPermission;

/**
 * This class gives access to the different entity containers and the current user.
 * 
 * @author Group White, I2p, BFH Berne, <a href="https://github.com/fabaff/ch.bfh.bti7081.s2013.white">Contact</a>
 * @version 1.0.0
 */
public class PmsDataAccess {

	private PmsUserContainer pmsUserContainer;
	private PmsContainer<PCase> pCaseContainer;
	private PmsEntityContainer<Diagnosis> diagnosisContainer;
	private PmsEntityContainer<PatientProgress> patientProgressContainer;
	private PmsEntityContainer<Medication> medicationContainer;
	private PmsEntityContainer<MedicationDate> medicationDateContainer;
	private PmsEntityContainer<MedicationTime> medicationTimeContainer;
	
	private PmsUser loginUser;
	private PmsPermission permission;
	
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
		this.loginUser = this.pmsUserContainer.getUser(userName);
		if (this.loginUser == null) {
			throw new UnknownUserException("Invalid user name: " + userName + "!", userName);
		}
		
		this.permission = new PmsPermission(this.loginUser.getUserGroup());
	}
	
	/**
	 * @return current user object
	 */
	public PmsUser getLoginUser() {
		return this.loginUser;
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

	/**
	 * @return the permission
	 */
	public PmsPermission getPermission() {
		return permission;
	}

	/**
	 * 
	 * @param b
	 */
	public void enableDeleteFilters(boolean b) {
		this.diagnosisContainer.enableDeleteFilter(true);
		this.medicationContainer.enableDeleteFilter(true);
		this.medicationDateContainer.enableDeleteFilter(true);
		this.medicationTimeContainer.enableDeleteFilter(true);
		this.patientProgressContainer.enableDeleteFilter(true);
		
	}
}
