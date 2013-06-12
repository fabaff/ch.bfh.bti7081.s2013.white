package ch.bfh.ti.soed.white.mhc_pms.data;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import ch.bfh.ti.soed.white.mhc_pms.data.enums.MedicationUnit;

/**
 * Entity implementation class for Entity: MedicationTime.
 * Each medication time has exactly one associated medication date entity.
 * 
 * @author Group White, I2p, BFH Berne, <a
 *         href="https://github.com/fabaff/ch.bfh.bti7081.s2013.white"
 *         >Contact</a>
 * @version 1.0.0
 *
 */
@Entity
@Table(name = "MedicationTime")
public class MedicationTime implements Serializable {

	private static final long serialVersionUID = -6172089759431144441L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int mtid;
	
	@NotNull
	@Temporal(value = TemporalType.TIME)
	private Date applicationTime;
	
	@NotNull
	private double medicationDosis;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private MedicationUnit medicationUnit;
	
	@NotNull
	@ManyToOne
	private MedicationDate medDate;
	
	public MedicationTime() {
		this(null);
	}   
	
	public MedicationTime(MedicationDate medDate) {
		this.medDate = medDate;
	}   
	
	public int getMtid() {
		return this.mtid;
	}

	public void setMtid(int mtid) {
		this.mtid = mtid;
	}

	/**
	 * @return the medDate
	 */
	public MedicationDate getMedDate() {
		return medDate;
	}

	/**
	 * @param medDate the medDate to set
	 */
	public void setMedDate(MedicationDate medDate) {
		this.medDate = medDate;
	}

	/**
	 * @return the medicationDosis
	 */
	public double getMedicationDosis() {
		return medicationDosis;
	}

	/**
	 * @param medicationDosis the medicationDosis to set
	 */
	public void setMedicationDosis(double medicationDosis) {
		this.medicationDosis = medicationDosis;
	}

	/**
	 * @return the medicationUnit
	 */
	public MedicationUnit getMedicationUnit() {
		return medicationUnit;
	}

	/**
	 * @param medicationUnit the medicationUnit to set
	 */
	public void setMedicationUnit(MedicationUnit medicationUnit) {
		this.medicationUnit = medicationUnit;
	}

	/**
	 * @return the applicationTime
	 */
	public Date getApplicationTime() {
		return applicationTime;
	}

	/**
	 * @param applicationTime the applicationTime to set
	 */
	public void setApplicationTime(Date applicationTime) {
		this.applicationTime = applicationTime;
	}
   
	
}
