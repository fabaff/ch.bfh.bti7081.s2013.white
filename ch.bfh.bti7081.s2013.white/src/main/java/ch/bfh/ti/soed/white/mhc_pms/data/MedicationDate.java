package ch.bfh.ti.soed.white.mhc_pms.data;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Entity implementation class for Entity: MedicationDate
 *
 */
@Entity
@Table(name = "MedicationDate")
public class MedicationDate implements Serializable {

	private static final long serialVersionUID = -186608011820256716L;
	@Id
	private int mdid;

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
   
}
