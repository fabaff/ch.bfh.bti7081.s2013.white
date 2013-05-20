package ch.bfh.ti.soed.white.mhc_pms.data;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import ch.bfh.ti.soed.white.mhc_pms.data.enums.Gender;
import ch.bfh.ti.soed.white.mhc_pms.data.enums.KindOfTreatment;
import ch.bfh.ti.soed.white.mhc_pms.data.enums.OrderOfPatient;
import ch.bfh.ti.soed.white.mhc_pms.data.enums.ReanimationStatus;
import ch.bfh.ti.soed.white.mhc_pms.data.enums.Status;

/**
 * Entity implementation class for Entity: PCase
 * 
 */
@Entity
@Table(name = "PCase")
public class PCase implements Serializable {

	private static final long serialVersionUID = -4330530027475971377L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int pcid = 0;

	// patient fields
	
	@NotNull
	@Size(min = 2, max = 64)
	private String firstName = "";

	@NotNull
	@Size(min = 2, max = 64)
	private String lastName = "";

	@NotNull
	@Temporal(value = TemporalType.DATE)
	private Date dateOfBirth = new Date();

	@NotNull
	@Enumerated(EnumType.STRING)
	private Gender gender = Gender.Weiblich;

	private String motherLanguage = "";

	private String communcationLanguage = "";

	private String civilStatus = "";

	private String nationality = "";

	private String religion = "";

	private String address = "";

	private String homeLocation = "";

	private String postalCode = "";

	private String country = "";

	private String phonePrivate = "";

	private String phoneBusiness = "";

	private String mobilePhone = "";

	private String eMail = "";

	private String nextOfKin = "";

	private String nextOfKinFirstName = "";

	private String nextOfKinLastName = "";

	private String nextOfKinAddress = "";
	
	private String nextOfKinPostalCode = "";
	
	private String nextOfKinHomeLocation = "";

	private String nextOfKinPhone = "";

	private String familyDoctorFirstName = "";

	private String familyDoctorLastName = "";

	private String familyDoctorAddress = "";

	private String familyDoctorLocation = "";

	private String familyDoctorPostalCode = "";

	private String familyDoctorFax = "";

	// case fields
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private Status status = Status.Aktiv;

	@NotNull
	@Enumerated(EnumType.STRING)
	private KindOfTreatment kindOfTreatment = KindOfTreatment.Stationär;
	
	@NotNull
	@Temporal(value = TemporalType.DATE)
	private Date dateCaseOpened = new Date();
	
	@Temporal(value = TemporalType.DATE)
	private Date dateCaseClosed;

	@Enumerated(EnumType.STRING)
	private ReanimationStatus reanimationStatus = ReanimationStatus.Ja;

	private String assignment = "";

	private String 	suicidalTendency = "";

	private String degreeOfDanger = "";

	private String goOutStatus = "";

	private String vacation = "";

	private String judicialStatus = "";

	private String sanction = "";

	@Enumerated(EnumType.STRING)
	private OrderOfPatient orderOfPatient = OrderOfPatient.Nein;

	// therapist fields
	
	@ManyToOne
	private PmsUser therapist;
	
	public PCase() {
		// TODO one to many beziehungen
	}
	
	public PCase(PmsUser therapist) {
		this();
		this.therapist = therapist;
	}

	/**
	 * @return the pcid
	 */
	public int getPcid() {
		return pcid;
	}

	/**
	 * @param pcid the pcid to set
	 */
	public void setPcid(int pcid) {
		this.pcid = pcid;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the dateOfBirth
	 */
	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * @param dateOfBirth the dateOfBirth to set
	 */
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	/**
	 * @return the gender
	 */
	public Gender getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(Gender gender) {
		this.gender = gender;
	}

	/**
	 * @return the motherLanguage
	 */
	public String getMotherLanguage() {
		return motherLanguage;
	}

	/**
	 * @param motherLanguage the motherLanguage to set
	 */
	public void setMotherLanguage(String motherLanguage) {
		this.motherLanguage = motherLanguage;
	}

	/**
	 * @return the communcationLanguage
	 */
	public String getCommuncationLanguage() {
		return communcationLanguage;
	}

	/**
	 * @param communcationLanguage the communcationLanguage to set
	 */
	public void setCommuncationLanguage(String communcationLanguage) {
		this.communcationLanguage = communcationLanguage;
	}

	/**
	 * @return the civilStatus
	 */
	public String getCivilStatus() {
		return civilStatus;
	}

	/**
	 * @param civilStatus the civilStatus to set
	 */
	public void setCivilStatus(String civilStatus) {
		this.civilStatus = civilStatus;
	}

	/**
	 * @return the nationality
	 */
	public String getNationality() {
		return nationality;
	}

	/**
	 * @param nationality the nationality to set
	 */
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	/**
	 * @return the religion
	 */
	public String getReligion() {
		return religion;
	}

	/**
	 * @param religion the religion to set
	 */
	public void setReligion(String religion) {
		this.religion = religion;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the homeLocation
	 */
	public String getHomeLocation() {
		return homeLocation;
	}

	/**
	 * @param homeLocation the homeLocation to set
	 */
	public void setHomeLocation(String homeLocation) {
		this.homeLocation = homeLocation;
	}

	/**
	 * @return the postalCode
	 */
	public String getPostalCode() {
		return postalCode;
	}

	/**
	 * @param postalCode the postalCode to set
	 */
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return the phonePrivate
	 */
	public String getPhonePrivate() {
		return phonePrivate;
	}

	/**
	 * @param phonePrivate the phonePrivate to set
	 */
	public void setPhonePrivate(String phonePrivate) {
		this.phonePrivate = phonePrivate;
	}

	/**
	 * @return the phoneBusiness
	 */
	public String getPhoneBusiness() {
		return phoneBusiness;
	}

	/**
	 * @param phoneBusiness the phoneBusiness to set
	 */
	public void setPhoneBusiness(String phoneBusiness) {
		this.phoneBusiness = phoneBusiness;
	}

	/**
	 * @return the mobilePhone
	 */
	public String getMobilePhone() {
		return mobilePhone;
	}

	/**
	 * @param mobilePhone the mobilePhone to set
	 */
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	/**
	 * @return the eMail
	 */
	public String geteMail() {
		return eMail;
	}

	/**
	 * @param eMail the eMail to set
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
	 * @return the familyDoctorFax
	 */
	public String getFamilyDoctorFax() {
		return familyDoctorFax;
	}

	/**
	 * @param familyDoctorFax the familyDoctorFax to set
	 */
	public void setFamilyDoctorFax(String familyDoctorFax) {
		this.familyDoctorFax = familyDoctorFax;
	}

	/**
	 * @return the status
	 */
	public Status getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(Status status) {
		this.status = status;
	}

	/**
	 * @return the kindOfTreatment
	 */
	public KindOfTreatment getKindOfTreatment() {
		return kindOfTreatment;
	}

	/**
	 * @param kindOfTreatment the kindOfTreatment to set
	 */
	public void setKindOfTreatment(KindOfTreatment kindOfTreatment) {
		this.kindOfTreatment = kindOfTreatment;
	}

	/**
	 * @return the dateCaseOpened
	 */
	public Date getDateCaseOpened() {
		return dateCaseOpened;
	}

	/**
	 * @param dateCaseOpened the dateCaseOpened to set
	 */
	public void setDateCaseOpened(Date dateCaseOpened) {
		this.dateCaseOpened = dateCaseOpened;
	}

	/**
	 * @return the dateCaseClosed
	 */
	public Date getDateCaseClosed() {
		return dateCaseClosed;
	}

	/**
	 * @param dateCaseClosed the dateCaseClosed to set
	 */
	public void setDateCaseClosed(Date dateCaseClosed) {
		this.dateCaseClosed = dateCaseClosed;
	}

	/**
	 * @return the reanimationStatus
	 */
	public ReanimationStatus getReanimationStatus() {
		return reanimationStatus;
	}

	/**
	 * @param reanimationStatus the reanimationStatus to set
	 */
	public void setReanimationStatus(ReanimationStatus reanimationStatus) {
		this.reanimationStatus = reanimationStatus;
	}

	/**
	 * @return the assignment
	 */
	public String getAssignment() {
		return assignment;
	}

	/**
	 * @param assignment the assignment to set
	 */
	public void setAssignment(String assignment) {
		this.assignment = assignment;
	}

	/**
	 * @return the suicidalTendency
	 */
	public String getSuicidalTendency() {
		return suicidalTendency;
	}

	/**
	 * @param suicidalTendency the suicidalTendency to set
	 */
	public void setSuicidalTendency(String suicidalTendency) {
		this.suicidalTendency = suicidalTendency;
	}

	/**
	 * @return the degreeOfDanger
	 */
	public String getDegreeOfDanger() {
		return degreeOfDanger;
	}

	/**
	 * @param degreeOfDanger the degreeOfDanger to set
	 */
	public void setDegreeOfDanger(String degreeOfDanger) {
		this.degreeOfDanger = degreeOfDanger;
	}

	/**
	 * @return the goOutStatus
	 */
	public String getGoOutStatus() {
		return goOutStatus;
	}

	/**
	 * @param goOutStatus the goOutStatus to set
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
