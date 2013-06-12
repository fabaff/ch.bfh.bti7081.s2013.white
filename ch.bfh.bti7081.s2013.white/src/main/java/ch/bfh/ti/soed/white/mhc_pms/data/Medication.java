package ch.bfh.ti.soed.white.mhc_pms.data;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import ch.bfh.ti.soed.white.mhc_pms.data.enums.MedApplicationMode;

/**
 * Entity implementation class for Entity: Medication.
 * Each medication has exactly one associated patient case entity.
 * Each medication can have zero to n associated medication dates.
 * 
 * @author Group White, I2p, BFH Berne, <a
 *         href="https://github.com/fabaff/ch.bfh.bti7081.s2013.white"
 *         >Contact</a>
 * @version 1.0.0
 *        
 */
@Entity
@Table(name = "Medication")
public class Medication implements Serializable {

	private static final long serialVersionUID = 2229944891333269290L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int mid = 0;

	@NotNull
	private String medicationName = "";

	// dope = Wirkstoff
	@NotNull
	private String dope = "";
	
	// applicationMode = Verabreichungsform
	@NotNull
	@Enumerated(EnumType.STRING)
	private  MedApplicationMode applicationMode;

	@NotNull
	@Temporal(value = TemporalType.DATE)
	private Date dateOfPriscribing;
	
	@NotNull
	private String priscribingDoctor ="";
	
	@NotNull
	private String clinicName = "";
	
	@NotNull
	private boolean isDeleted = false;

	@NotNull
	@ManyToOne
	private PCase pCase;

	@OneToMany(mappedBy = "medication")
	private Set<MedicationDate> medDateRelation = new HashSet<>();
	
	public Medication() {
		this(null);
	}

	public void setNewMedication() {
		this.setMid(0);
		this.setDateOfPriscribing(new Date());
		if (this.pCase != null) {
			this.setClinicName(this.getpCase().getTherapist().getClinic());
			this.setPriscribingDoctor(this.getpCase().getTherapist().getFirstName()
					+ " " + this.getpCase().getTherapist().getLastName());
		}
	}
	
	/**
	 * 
	 * @param pCase
	 */
	public Medication(PCase pCase) {
		this.pCase = pCase;
	}

	
	/**
	 * 
	 * @return int
	 */
	public int getMid() {
		return mid;
	}

	/**
	 * 
	 * @param mid
	 */
	public void setMid(int mid) {
		this.mid = mid;
	}

	/**
	 * 
	 * @return String
	 */
	public String getMedicationName() {
		return medicationName;
	}

	/**
	 * 
	 * @param medicationName
	 */
	public void setMedicationName(String medicationName) {
		this.medicationName = medicationName;
	}

	/**
	 * @return the dope
	 */
	public String getDope() {
		return dope;
	}

	/**
	 * @param dope the dope to set
	 */
	public void setDope(String dope) {
		this.dope = dope;
	}

	/**
	 * @return the dateOfPriscribing
	 */
	public Date getDateOfPriscribing() {
		return dateOfPriscribing;
	}

	/**
	 * @param dateOfPriscribing the dateOfPriscribing to set
	 */
	public void setDateOfPriscribing(Date dateOfPriscribing) {
		this.dateOfPriscribing = dateOfPriscribing;
	}

	/**
	 * @return the priscribingDoctor
	 */
	public String getPriscribingDoctor() {
		return priscribingDoctor;
	}

	/**
	 * @param priscribingDoctor the priscribingDoctor to set
	 */
	public void setPriscribingDoctor(String priscribingDoctor) {
		this.priscribingDoctor = priscribingDoctor;
	}

	/**
	 * @return the clinicName
	 */
	public String getClinicName() {
		return clinicName;
	}

	/**
	 * @param clinicName the clinicName to set
	 */
	public void setClinicName(String clinicName) {
		this.clinicName = clinicName;
	}

	/**
	 * @return the isDeleted
	 */
	public boolean isDeleted() {
		return isDeleted;
	}

	/**
	 * @param isDeleted the isDeleted to set
	 */
	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	/**
	 * @return the pCase
	 */
	public PCase getpCase() {
		return pCase;
	}

	/**
	 * @param pCase the pCase to set
	 */
	public void setpCase(PCase pCase) {
		this.pCase = pCase;
	}

	/**
	 * @return the medDateRelation
	 */
	public Set<MedicationDate> getMedDateRelation() {
		return medDateRelation;
	}

	/**
	 * @param medDateRelation the medDateRelation to set
	 */
	public void setMedDateRelation(Set<MedicationDate> medDateRelation) {
		this.medDateRelation = medDateRelation;
	}

	/**
	 * @return the applicationMode
	 */
	public MedApplicationMode getApplicationMode() {
		return applicationMode;
	}

	/**
	 * @param applicationMode the applicationMode to set
	 */
	public void setApplicationMode(MedApplicationMode applicationMode) {
		this.applicationMode = applicationMode;
	}

}