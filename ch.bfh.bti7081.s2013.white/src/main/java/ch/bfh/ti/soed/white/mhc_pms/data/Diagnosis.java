package ch.bfh.ti.soed.white.mhc_pms.data;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Entity implementation class for Entity: Diagnosis
 * Each diagnosis has exactly one associated patient case entity.
 * 
 * @author Group White, I2p, BFH Berne, <a
 *         href="https://github.com/fabaff/ch.bfh.bti7081.s2013.white"
 *         >Contact</a>
 * @version 1.0.0
 * 
 * 
 */
@Entity
@Table(name="Diagnosis")
public class Diagnosis implements Serializable {
	
	private static final long serialVersionUID = 2229944891333269290L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int did = 0;
	
	@NotNull
	private String diagnosisName = "";  
	
	@NotNull
	private String icdCode = "";
	
	@Column(length=5000)   
	private String diagnosisComment = "";
	
	@NotNull
	@Temporal(value = TemporalType.DATE)
	private Date dateOfCreation;
	
	@NotNull
	private String diagnosisCreator ="";
	
	@NotNull
	private String clinicName = "";
	
	@NotNull
	private boolean isDeleted = false;
	
	@NotNull
	@ManyToOne
	private PCase pCase;
	
	public Diagnosis() {
		this(null);
	}   
	
	public Diagnosis(PCase pCase) {
		this.pCase = pCase;
	}   
	
	public void setNewDiagnosis() {
		this.setDid(0);
		this.setDateOfCreation(new Date());
		if (this.pCase != null) {
			this.setClinicName(this.getpCase().getTherapist().getClinic());
			this.setDiagnosisCreator(this.getpCase().getTherapist().getFirstName()
					+ " " + this.getpCase().getTherapist().getLastName());
		}
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
	 * 
	 * @return diagnosisName
	 */
	public String getDiagnosisName() {
		return this.diagnosisName;
	}

	/**
	 * 
	 * @param diagnosisName
	 */
	public void setDiagnosisName(String diagnosisName) {
		this.diagnosisName = diagnosisName;
	}   
	
	/**
	 * 
	 * @return did
	 */
	public int getDid() {
		return this.did;
	}

	/**
	 * 
	 * @param did
	 */
	public void setDid(int did) {
		this.did = did;
	}   
	
	/**
	 * 
	 * @return icdCode
	 */
	public String getIcdCode() {
		return this.icdCode;
	}

	/**
	 * 
	 * @param icdCode
	 */
	public void setIcdCode(String icdCode) {
		this.icdCode = icdCode;
	}   

	/**
	 * 
	 * @return diagnosisComment
	 */
	public String getDiagnosisComment() {
		return this.diagnosisComment;
	}

	/**
	 * 
	 * @param diagnosisComment
	 */
	public void setDiagnosisComment(String diagnosisComment) {
		this.diagnosisComment = diagnosisComment;
	}  
	
	/**
	 * 
	 * @return dateOfCreation
	 */
	public Date getDateOfCreation() {
		return this.dateOfCreation;
	}

	/**
	 * 
	 * @param dateOfCreation
	 */
	public void setDateOfCreation(Date dateOfCreation) {
		this.dateOfCreation = dateOfCreation;
	}  
	
	/**
	 * 
	 * @return diagnosisCreator
	 */
	public String getDiagnosisCreator() {
		return this.diagnosisCreator;
	}

	/**
	 * 
	 * @param diagnosisCreator
	 */
	public void setDiagnosisCreator(String diagnosisCreator) {
		this.diagnosisCreator = diagnosisCreator;
	}   
	
	/**
	 * 
	 * @return clinicName
	 */
	public String getClinicName() {
		return this.clinicName;
	}

	/**
	 * 
	 * @param clinicName
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
   
}
