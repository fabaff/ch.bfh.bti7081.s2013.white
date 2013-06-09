package ch.bfh.ti.soed.white.mhc_pms.data;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * @author		Gruppe White, I2p, BFH Bern, <a href="https://github.com/fabaff/ch.bfh.bti7081.s2013.white">Contact</a>
 * @version		0.0.2 
 * @since		0.0.1
 * 
 * Entity implementation class for Entity: Diagnosis
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
	
	// TODO allow longer text in DB
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
		this.setClinicName(this.getpCase().getTherapist().getClinic());
		this.setClinicName(this.getpCase().getTherapist().getFirstName() + " " + this.getpCase().getTherapist().getLastName());
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

	public String getDiagnosisName() {
		return this.diagnosisName;
	}

	public void setDiagnosisName(String diagnosisName) {
		this.diagnosisName = diagnosisName;
	}   
	public int getDid() {
		return this.did;
	}

	public void setDid(int did) {
		this.did = did;
	}   
	public String getIcdCode() {
		return this.icdCode;
	}

	public void setIcdCode(String icdCode) {
		this.icdCode = icdCode;
	}   
	public String getDiagnosisComment() {
		return this.diagnosisComment;
	}

	public void setDiagnosisComment(String diagnosisComment) {
		this.diagnosisComment = diagnosisComment;
	}   
	public Date getDateOfCreation() {
		return this.dateOfCreation;
	}

	public void setDateOfCreation(Date dateOfCreation) {
		this.dateOfCreation = dateOfCreation;
	}   
	public String getDiagnosisCreator() {
		return this.diagnosisCreator;
	}

	public void setDiagnosisCreator(String diagnosisCreator) {
		this.diagnosisCreator = diagnosisCreator;
	}   
	public String getClinicName() {
		return this.clinicName;
	}

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
