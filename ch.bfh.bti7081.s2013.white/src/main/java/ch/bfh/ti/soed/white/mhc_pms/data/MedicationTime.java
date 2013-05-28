package ch.bfh.ti.soed.white.mhc_pms.data;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Entity implementation class for Entity: MedicationTime
 *
 */
@Entity
@Table(name = "MedicationTime")
public class MedicationTime implements Serializable {

	private static final long serialVersionUID = -6172089759431144441L;
	
	@Id
	private int mtid;
	
	private String medicationDosis;
	
	private String medicationUnit;
	
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
	 * @return the medicationDosis
	 */
	public String getMedicationDosis() {
		return medicationDosis;
	}

	/**
	 * @param medicationDosis the medicationDosis to set
	 */
	public void setMedicationDosis(String medicationDosis) {
		this.medicationDosis = medicationDosis;
	}

	/**
	 * @return the medicationUnit
	 */
	public String getMedicationUnit() {
		return medicationUnit;
	}

	/**
	 * @param medicationUnit the medicationUnit to set
	 */
	public void setMedicationUnit(String medicationUnit) {
		this.medicationUnit = medicationUnit;
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
   
	
}
