package ch.bfh.ti.soed.white.mhc_pms.data;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import ch.bfh.ti.soed.white.mhc_pms.data.enums.MedicationStatus;

/**
 * Entity implementation class for Entity: MedicationDate
 * 
  * @author Group White, I2p, BFH Berne, <a
 *         href="https://github.com/fabaff/ch.bfh.bti7081.s2013.white"
 *         >Contact</a>
 * @version 1.0.0
 * 
 */
@Entity
@Table(name = "MedicationDate")
public class MedicationDate implements Serializable {

	private static final long serialVersionUID = -186608011820256716L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int mdid;
	
	@NotNull
	@Temporal(value = TemporalType.DATE)
	private Date applicationDate;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private MedicationStatus medicationStatus;

	@OneToMany(mappedBy = "medDate")
	private Set<MedicationTime> medTimeRelation = new HashSet<>();
	
	@NotNull
	@ManyToOne
	private Medication medication;
	
	public MedicationDate() {
		this(null);
	}   
	
	public MedicationDate(Medication medication) {
		this.medication = medication;
	}

	public int getMdid() {
		return this.mdid;
	}

	public void setMdid(int mdid) {
		this.mdid = mdid;
	}

	/**
	 * @return the medTimeRelation
	 */
	public Set<MedicationTime> getMedTimeRelation() {
		return medTimeRelation;
	}

	/**
	 * @param medTimeRelation the medTimeRelation to set
	 */
	public void setMedTimeRelation(Set<MedicationTime> medTimeRelation) {
		this.medTimeRelation = medTimeRelation;
	}

	/**
	 * @return the medication
	 */
	public Medication getMedication() {
		return medication;
	}

	/**
	 * @param medication the medication to set
	 */
	public void setMedication(Medication medication) {
		this.medication = medication;
	}

	/**
	 * @return the medicationStatus
	 */
	public MedicationStatus getMedicationStatus() {
		return medicationStatus;
	}

	/**
	 * @param medicationStatus the medicationStatus to set
	 */
	public void setMedicationStatus(MedicationStatus medicationStatus) {
		this.medicationStatus = medicationStatus;
	}

	/**
	 * @return the applicationDate
	 */
	public Date getApplicationDate() {
		return applicationDate;
	}

	/**
	 * @param applicationDate the applicationDate to set
	 */
	public void setApplicationDate(Date applicationDate) {
		this.applicationDate = applicationDate;
	}
   
}
