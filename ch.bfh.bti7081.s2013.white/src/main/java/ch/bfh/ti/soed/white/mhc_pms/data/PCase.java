package ch.bfh.ti.soed.white.mhc_pms.data;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import ch.bfh.ti.soed.white.mhc_pms.data.enums.Gender;
import ch.bfh.ti.soed.white.mhc_pms.data.enums.KindOfTreatment;
import ch.bfh.ti.soed.white.mhc_pms.data.enums.OrderOfPatient;
import ch.bfh.ti.soed.white.mhc_pms.data.enums.ReanimationStatus;
import ch.bfh.ti.soed.white.mhc_pms.data.enums.CaseStatus;
import ch.bfh.ti.soed.white.mhc_pms.data.enums.CivilStatus;

/**
 * Entity implementation class for Entity: PCase.
 * As a simplification, the two entities Patient and Case are "denormalized" and merged together into a single entity PCase.
 * Each patient case has exactly one associated user entity.
 * Each patient case can have zero to n associated diagnosis or medications or patient progress entities.
 * 
 * @author Group White, I2p, BFH Berne, <a
 *         href="https://github.com/fabaff/ch.bfh.bti7081.s2013.white"
 *         >Contact</a>
 * @version 1.0.0
 * 
 * 
 */
@Entity
@Table(name = "PCase")
public class PCase implements Serializable {

	private static final long serialVersionUID = -4330530027475971377L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int pcid = 0;

	// Patient data fields: basic data
	
	@NotNull
	@Size(min = 2, max = 64)
	private String firstName = "";

	@NotNull
	@Size(min = 2, max = 64)
	private String lastName = "";

	@NotNull
	@Temporal(value = TemporalType.DATE)
	private Date dateOfBirth;

	@NotNull
	@Enumerated(EnumType.STRING)
	private Gender gender;

	@Enumerated(EnumType.STRING)
	private CivilStatus civilStatus;
	
	private String communicationLanguage = "";
	private String motherLanguage = "";
	private String nationality = "";
	private String religion = "";
	private String address = "";
	private String homeLocation = "";
	private String postalCode = "";
	private String country = "";
	private String phonePrivate = "";
	private String phoneBusiness = "";
	private String phoneMobile = "";
	private String eMail = "";
	
	// Patient data fields: next of kin data
	
	private String nextOfKin = "";
	private String nextOfKinFirstName = "";
	private String nextOfKinLastName = "";
	private String nextOfKinAddress = "";
	private String nextOfKinHomeLocation = "";
	private String nextOfKinPostalCode = "";
	private String nextOfKinPhone = "";

	// Patient data fields: family Doctor details
	
	private String familyDoctorFirstName = "";
	private String familyDoctorLastName = "";
	private String familyDoctorAddress = "";
	private String familyDoctorLocation = "";
	private String familyDoctorPostalCode = "";
	private String familyDoctorFax = "";

	// Case fields
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private CaseStatus caseStatus;

	@NotNull
	@Enumerated(EnumType.STRING)
	private KindOfTreatment kindOfTreatment;
	
	@NotNull
	@Temporal(value = TemporalType.DATE)
	private Date dateCaseOpened;
	
	@Temporal(value = TemporalType.DATE)
	private Date dateCaseClosed;

	@Enumerated(EnumType.STRING)
	private ReanimationStatus reanimationStatus;

	private String assignment = "";
	private String suicidalTendency = "";
	private String degreeOfDanger = "";
	private String goOutStatus = "";
	private String vacation = "";
	private String judicialStatus = "";
	private String sanction = "";

	@Enumerated(EnumType.STRING)
	private OrderOfPatient orderOfPatient;

	// Therapist field
	
	@NotNull
	@ManyToOne
	private PmsUser therapist;
	
	// one to many relationships
	
	@OneToMany(mappedBy = "pCase")
	private Set<Diagnosis> diagnosisRelation = new HashSet<>();
	
	@OneToMany(mappedBy = "pCase")
	private Set<PatientProgress> patientProgressRelation = new HashSet<>();
	
	@OneToMany(mappedBy = "pCase")
	private Set<Medication> medicationRelation = new HashSet<>();
	
	public PCase() {
		this(null);
	}
	
	/**
	 * 
	 * @param therapist
	 */
	public PCase(PmsUser therapist) {
		this.therapist = therapist;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	@Override
	public Object clone() {
		PCase pCaseclone = new PCase(this.getTherapist());
		
		this.setPcid(0);
		pCaseclone.firstName = this.firstName;
		pCaseclone.lastName = this.lastName;
		pCaseclone.dateOfBirth = this.dateOfBirth;
		pCaseclone.gender = this.gender;
		pCaseclone.civilStatus = this.civilStatus;
		pCaseclone.communicationLanguage = this.communicationLanguage;
		pCaseclone.motherLanguage = this.motherLanguage;
		pCaseclone.nationality = this.nationality;
		pCaseclone.religion = this.religion;
		pCaseclone.address = this.address;
		pCaseclone.homeLocation = this.homeLocation;
		pCaseclone.postalCode = this.postalCode;
		pCaseclone.country = this.country;
		pCaseclone.phonePrivate = this.phonePrivate;
		pCaseclone.phoneBusiness = this.phoneBusiness;
		pCaseclone.phoneMobile = this.phoneMobile;
		pCaseclone.eMail = this.eMail;
		
		pCaseclone.nextOfKin = this.nextOfKin;
		pCaseclone.nextOfKinFirstName = this.nextOfKinFirstName;
		pCaseclone.nextOfKinLastName = this.nextOfKinLastName;
		pCaseclone.nextOfKinAddress = this.nextOfKinAddress;
		pCaseclone.nextOfKinHomeLocation = this.nextOfKinHomeLocation;
		pCaseclone.nextOfKinPostalCode = this.nextOfKinPostalCode;
		pCaseclone.nextOfKinPhone = this.nextOfKinPhone;
		
		pCaseclone.familyDoctorFirstName = this.familyDoctorFirstName;
		pCaseclone.familyDoctorLastName = this.familyDoctorLastName;
		pCaseclone.familyDoctorAddress = this.familyDoctorAddress;
		pCaseclone.familyDoctorLocation = this.familyDoctorLocation;
		pCaseclone.familyDoctorPostalCode = this.familyDoctorPostalCode;
		pCaseclone.familyDoctorFax = this.familyDoctorFax;
		
		pCaseclone.caseStatus = this.caseStatus;
		pCaseclone.kindOfTreatment = this.kindOfTreatment;
		pCaseclone.dateCaseOpened = this.dateCaseOpened;
		pCaseclone.dateCaseClosed = this.dateCaseClosed;
		pCaseclone.reanimationStatus = this.reanimationStatus;
		pCaseclone.assignment = this.assignment;
		pCaseclone.suicidalTendency = this.suicidalTendency;
		pCaseclone.degreeOfDanger = this.degreeOfDanger;
		pCaseclone.goOutStatus = this.goOutStatus;
		pCaseclone.vacation = this.vacation;
		pCaseclone.judicialStatus = this.judicialStatus;
		pCaseclone.sanction = this.sanction;
		pCaseclone.orderOfPatient = this.orderOfPatient;
		
		pCaseclone.therapist = this.therapist;
		pCaseclone.diagnosisRelation = this.diagnosisRelation;
		pCaseclone.patientProgressRelation = this.patientProgressRelation;
		pCaseclone.medicationRelation = this.medicationRelation;
		
		return pCaseclone;
	}

	public void closeCase() {
		this.setCaseStatus(CaseStatus.CLOSED);
		this.setDateCaseClosed(new Date());
	}
	
	public void setNewCase() {
		this.setDateCaseOpened(new Date());
		this.setDateCaseClosed(null);
		this.setCaseStatus(CaseStatus.ACTIVE);
		this.setReanimationStatus(ReanimationStatus.YES);
		this.setKindOfTreatment(KindOfTreatment.INPATIENT);
		this.setOrderOfPatient(OrderOfPatient.NO);
		this.setPcid(0);
	}
	
	/**
	 * @return the communicationLanguage
	 */
	public String getCommunicationLanguage() {
		return communicationLanguage;
	}

	/**
	 * @param communicationLanguage the communicationLanguage to set
	 */
	public void setCommunicationLanguage(String communicationLanguage) {
		this.communicationLanguage = communicationLanguage;
	}

	/**
	 * @return the patientProgressRelation
	 */
	public Set<PatientProgress> getPatientProgressRelation() {
		return patientProgressRelation;
	}

	/**
	 * @param patientProgressRelation the patientProgressRelation to set
	 */
	public void setPatientProgressRelation(
			Set<PatientProgress> patientProgressRelation) {
		this.patientProgressRelation = patientProgressRelation;
	}

	/**
	 * @return the medicationRelation
	 */
	public Set<Medication> getMedicationRelation() {
		return medicationRelation;
	}

	/**
	 * @param medicationRelation the medicationRelation to set
	 */
	public void setMedicationRelation(Set<Medication> medicationRelation) {
		this.medicationRelation = medicationRelation;
	}

	/**
	 * @return the therapist
	 */
	public PmsUser getTherapist() {
		return therapist;
	}

	/**
	 * @param therapist the therapist to set
	 */
	public void setTherapist(PmsUser therapist) {
		this.therapist = therapist;
	}

	/**
	 * @return the diagnosisRelation
	 */
	public Set<Diagnosis> getDiagnosisRelation() {
		return diagnosisRelation;
	}

	/**
	 * @param diagnosisRelation the diagnosisRelation to set
	 */
	public void setDiagnosisRelation(Set<Diagnosis> diagnosisRelation) {
		this.diagnosisRelation = diagnosisRelation;
	}

	/**
	 * @return The Patient Case ID.
	 */
	public int getPcid() {
		return pcid;
	}

	/**
	 * @param pcid The Patient Case ID to set.
	 */
	public void setPcid(int pcid) {
		this.pcid = pcid;
	}

	/**
	 * @return The first name of the patient.
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName The first name to set.
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return The last name of the patient.
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName The last name to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return The patient's date of birth.
	 */
	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * @param dateOfBirth The date of birth to set.
	 */
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	/**
	 * @return The gender of the patient.
	 */
	public Gender getGender() {
		return gender;
	}

	/**
	 * @param gender The gender of the patient to set.
	 */
	public void setGender(Gender gender) {
		this.gender = gender;
	}

	/**
	 * @return The civil status of the patient.
	 */
	public CivilStatus getCivilStatus() {
		return civilStatus;
	}

	/**
	 * @param civilStatus The patient's civil status to set.
	 */
	public void setCivilStatus(CivilStatus civilStatus) {
		this.civilStatus = civilStatus;
	}
	
	/**
	 * @return The patient's mother tongue.
	 */
	public String getMotherLanguage() {
		return motherLanguage;
	}

	/**
	 * @param motherLanguage The patient's mother tongue to set.
	 */
	public void setMotherLanguage(String motherLanguage) {
		this.motherLanguage = motherLanguage;
	}

	/**
	 * @return The patient's nationality.
	 */
	public String getNationality() {
		return nationality;
	}

	/**
	 * @param nationality The patient's nationality to set.
	 */
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	/**
	 * @return The religion of the patient.
	 */
	public String getReligion() {
		return religion;
	}

	/**
	 * @param religion The patient's religion to set.
	 */
	public void setReligion(String religion) {
		this.religion = religion;
	}

	/**
	 * @return The home address of the patient.
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address The patient's home address to set.
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return The home location (city) of the patient.
	 */
	public String getHomeLocation() {
		return homeLocation;
	}

	/**
	 * @param homeLocation The patient's home location (city) to set.
	 */
	public void setHomeLocation(String homeLocation) {
		this.homeLocation = homeLocation;
	}

	/**
	 * @return The patient's postal code.
	 */
	public String getPostalCode() {
		return postalCode;
	}

	/**
	 * @param postalCode The patient's postal code to set.
	 */
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	/**
	 * @return The patient's home country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country The patient's home country to set.
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return The patient's private phoneMobile number.
	 */
	public String getPhonePrivate() {
		return phonePrivate;
	}

	/**
	 * @param phonePrivate The patient's private phoneMobile number to set.
	 */
	public void setPhonePrivate(String phonePrivate) {
		this.phonePrivate = phonePrivate;
	}

	/**
	 * @return The patient's business phoneMobile number.
	 */
	public String getPhoneBusiness() {
		return phoneBusiness;
	}

	/**
	 * @param phoneBusiness The patient's business phoneMobile number to set.
	 */
	public void setPhoneBusiness(String phoneBusiness) {
		this.phoneBusiness = phoneBusiness;
	}

	/**
	 * @return The patient's mobile phoneMobile number.
	 */
	public String getPhoneMobile() {
		return phoneMobile;
	}

	/**
	 * @param mobilePhone The patien's mobile phoneMobile number to set.
	 */
	public void setPhoneMobile(String phoneMobile) {
		this.phoneMobile = phoneMobile;
	}

	/**
	 * @return The patient's email address.
	 */
	public String geteMail() {
		return eMail;
	}

	/**
	 * @param eMail The patient's email address to set.
	 */
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	/**
	 * @return the nextOfKin
	 */
	public String getNextOfKin() {
		return nextOfKin;
	}

	/**
	 * @param nextOfKin the nextOfKin to set
	 */
	public void setNextOfKin(String nextOfKin) {
		this.nextOfKin = nextOfKin;
	}

	/**
	 * @return the nextOfKinFirstName
	 */
	public String getNextOfKinFirstName() {
		return nextOfKinFirstName;
	}

	/**
	 * @param nextOfKinFirstName the nextOfKinFirstName to set
	 */
	public void setNextOfKinFirstName(String nextOfKinFirstName) {
		this.nextOfKinFirstName = nextOfKinFirstName;
	}

	/**
	 * @return the nextOfKinLastName
	 */
	public String getNextOfKinLastName() {
		return nextOfKinLastName;
	}

	/**
	 * @param nextOfKinLastName the nextOfKinLastName to set
	 */
	public void setNextOfKinLastName(String nextOfKinLastName) {
		this.nextOfKinLastName = nextOfKinLastName;
	}

	/**
	 * @return the nextOfKinAddress
	 */
	public String getNextOfKinAddress() {
		return nextOfKinAddress;
	}

	/**
	 * @param nextOfKinAddress the nextOfKinAddress to set
	 */
	public void setNextOfKinAddress(String nextOfKinAddress) {
		this.nextOfKinAddress = nextOfKinAddress;
	}

	/**
	 * @return the nextOfKinPhone
	 */
	public String getNextOfKinPhone() {
		return nextOfKinPhone;
	}

	/**
	 * @param nextOfKinPhone the nextOfKinPhone to set
	 */
	public void setNextOfKinPhone(String nextOfKinPhone) {
		this.nextOfKinPhone = nextOfKinPhone;
	}

	/**
	 * @return the familyDoctorFirstName
	 */
	public String getFamilyDoctorFirstName() {
		return familyDoctorFirstName;
	}

	/**
	 * @param familyDoctorFirstName the familyDoctorFirstName to set
	 */
	public void setFamilyDoctorFirstName(String familyDoctorFirstName) {
		this.familyDoctorFirstName = familyDoctorFirstName;
	}

	/**
	 * @return the familyDoctorLastName
	 */
	public String getFamilyDoctorLastName() {
		return familyDoctorLastName;
	}

	/**
	 * @param familyDoctorLastName the familyDoctorLastName to set
	 */
	public void setFamilyDoctorLastName(String familyDoctorLastName) {
		this.familyDoctorLastName = familyDoctorLastName;
	}

	/**
	 * @return the familyDoctorAddress
	 */
	public String getFamilyDoctorAddress() {
		return familyDoctorAddress;
	}

	/**
	 * @param familyDoctorAddress the familyDoctorAddress to set
	 */
	public void setFamilyDoctorAddress(String familyDoctorAddress) {
		this.familyDoctorAddress = familyDoctorAddress;
	}

	/**
	 * @return the familyDoctorLocation
	 */
	public String getFamilyDoctorLocation() {
		return familyDoctorLocation;
	}

	/**
	 * @param familyDoctorLocation the familyDoctorLocation to set
	 */
	public void setFamilyDoctorLocation(String familyDoctorLocation) {
		this.familyDoctorLocation = familyDoctorLocation;
	}

	/**
	 * @return the familyDoctorPostalCode
	 */
	public String getFamilyDoctorPostalCode() {
		return familyDoctorPostalCode;
	}

	/**
	 * @param familyDoctorPostalCode the familyDoctorPostalCode to set
	 */
	public void setFamilyDoctorPostalCode(String familyDoctorPostalCode) {
		this.familyDoctorPostalCode = familyDoctorPostalCode;
	}

	/**
	 * @return The fax number of the family doctor.
	 */
	public String getFamilyDoctorFax() {
		return familyDoctorFax;
	}

	/**
	 * @param familyDoctorFax The fax number of the family doctor to set.
	 */
	public void setFamilyDoctorFax(String familyDoctorFax) {
		this.familyDoctorFax = familyDoctorFax;
	}

	/**
	 * @return The current case status.
	 */
	public CaseStatus getCaseStatus() {
		return caseStatus;
	}

	/**
	 * @param status The case status to set.
	 */
	public void setCaseStatus(CaseStatus caseStatus) {
		this.caseStatus = caseStatus;
	}

	/**
	 * @return The kind of treatment.
	 */
	public KindOfTreatment getKindOfTreatment() {
		return kindOfTreatment;
	}

	/**
	 * @param kindOfTreatment Set the patient's kind of treatment.
	 */
	public void setKindOfTreatment(KindOfTreatment kindOfTreatment) {
		this.kindOfTreatment = kindOfTreatment;
	}

	/**
	 * @return The date which the case was opened.
	 */
	public Date getDateCaseOpened() {
		return dateCaseOpened;
	}

	/**
	 * @param dateCaseOpened Set the date which the case was opened.
	 */
	public void setDateCaseOpened(Date dateCaseOpened) {
		this.dateCaseOpened = dateCaseOpened;
	}

	/**
	 * @return The date which the case was closed.
	 */
	public Date getDateCaseClosed() {
		return dateCaseClosed;
	}

	/**
	 * @param dateCaseClosed Set the date which the case was closed.
	 */
	public void setDateCaseClosed(Date dateCaseClosed) {
		this.dateCaseClosed = dateCaseClosed;
	}

	/**
	 * @return The patient's reanimation status.
	 */
	public ReanimationStatus getReanimationStatus() {
		return reanimationStatus;
	}

	/**
	 * @param reanimationStatus The patient's reanimation status to set.
	 */
	public void setReanimationStatus(ReanimationStatus reanimationStatus) {
		this.reanimationStatus = reanimationStatus;
	}

	/**
	 * @return The current assignment.
	 */
	public String getAssignment() {
		return assignment;
	}

	/**
	 * @param assignment The current assignment to set.
	 */
	public void setAssignment(String assignment) {
		this.assignment = assignment;
	}

	/**
	 * @return The patient's suicidal tendency.
	 */
	public String getSuicidalTendency() {
		return suicidalTendency;
	}

	/**
	 * @param suicidalTendency Set the patient's suicidal tendency.
	 */
	public void setSuicidalTendency(String suicidalTendency) {
		this.suicidalTendency = suicidalTendency;
	}

	/**
	 * @return The patient's degree of danger.
	 */
	public String getDegreeOfDanger() {
		return degreeOfDanger;
	}

	/**
	 * @param degreeOfDanger The patient's degree of danger to set.
	 */
	public void setDegreeOfDanger(String degreeOfDanger) {
		this.degreeOfDanger = degreeOfDanger;
	}

	/**
	 * @return The go-out-status of the patient.
	 */
	public String getGoOutStatus() {
		return goOutStatus;
	}

	/**
	 * @param goOutStatus Set the go-out-status of the patient.
	 */
	public void setGoOutStatus(String goOutStatus) {
		this.goOutStatus = goOutStatus;
	}

	/**
	 * @return the vacation
	 */
	public String getVacation() {
		return vacation;
	}

	/**
	 * @param vacation the vacation to set
	 */
	public void setVacation(String vacation) {
		this.vacation = vacation;
	}

	/**
	 * @return the judicialStatus
	 */
	public String getJudicialStatus() {
		return judicialStatus;
	}

	/**
	 * @param judicialStatus the judicialStatus to set
	 */
	public void setJudicialStatus(String judicialStatus) {
		this.judicialStatus = judicialStatus;
	}

	/**
	 * @return the sanction
	 */
	public String getSanction() {
		return sanction;
	}

	/**
	 * @param sanction the sanction to set
	 */
	public void setSanction(String sanction) {
		this.sanction = sanction;
	}

	/**
	 * @return the orderOfPatient
	 */
	public OrderOfPatient getOrderOfPatient() {
		return orderOfPatient;
	}

	/**
	 * @param orderOfPatient the orderOfPatient to set
	 */
	public void setOrderOfPatient(OrderOfPatient orderOfPatient) {
		this.orderOfPatient = orderOfPatient;
	}

	/**
	 * @return the nextOfKinPostalCode
	 */
	public String getNextOfKinPostalCode() {
		return nextOfKinPostalCode;
	}

	/**
	 * @param nextOfKinPostalCode the nextOfKinPostalCode to set
	 */
	public void setNextOfKinPostalCode(String nextOfKinPostalCode) {
		this.nextOfKinPostalCode = nextOfKinPostalCode;
	}

	/**
	 * @return the nextOfKinHomeLocation
	 */
	public String getNextOfKinHomeLocation() {
		return nextOfKinHomeLocation;
	}

	/**
	 * @param nextOfKinHomeLocation the nextOfKinHomeLocation to set
	 */
	public void setNextOfKinHomeLocation(String nextOfKinHomeLocation) {
		this.nextOfKinHomeLocation = nextOfKinHomeLocation;
	}

}
