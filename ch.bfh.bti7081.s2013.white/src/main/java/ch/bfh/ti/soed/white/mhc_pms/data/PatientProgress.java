package ch.bfh.ti.soed.white.mhc_pms.data;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Entity implementation class for Entity: PatientProgress
 * Each patient progress entity has exactly one associated patient case entity.
 * 
 * @author Group White, I2p, BFH Berne, <a href="https://github.com/fabaff/ch.bfh.bti7081.s2013.white">Contact</a>
 * @version 1.0.0
 */
@Entity
@Table(name="PatientProgress")
public class PatientProgress implements Serializable {
	   
	private static final long serialVersionUID = 5965913117146085751L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int ppid = 0;

	@NotNull
	@Column(length=5000)   
	private String patientProgressComment = "";
	
	@NotNull
	@Temporal(value = TemporalType.DATE)
	private Date dateOfCreation;
	
	@NotNull
	private String patientProgressCreator = "";
	
	@NotNull
	private String clinicName;
	
	@NotNull
	private boolean isDeleted = false;
	
	@NotNull
	@ManyToOne
	private PCase pCase;
	
	public PatientProgress() {
		this(null);
	}   
	
	public PatientProgress(PCase pCase) {
		this.pCase = pCase;
	}  
	
	public void setNewPatientProgressEntity() {
		this.setPpid(0);
		this.setDateOfCreation(new Date());
		if (this.pCase != null) {
			this.setClinicName(this.getpCase().getTherapist().getClinic());
			this.setPatientProgressCreator(this.getpCase().getTherapist().getFirstName()
					+ " " + this.getpCase().getTherapist().getLastName());
		}
	}
	
	/**
	 * @return ppid
	 */
	public int getPpid() {
		return this.ppid;
	}

	/**
	 * @param ppid
	 */
	public void setPpid(int ppid) {
		this.ppid = ppid;
	}

	/**
	 * @return the patientProgressComment
	 */
	public String getPatientProgressComment() {
		return patientProgressComment;
	}

	/**
	 * @param patientProgressComment the patientProgressComment to set
	 */
	public void setPatientProgressComment(String patientProgressComment) {
		this.patientProgressComment = patientProgressComment;
	}

	/**
	 * @return the dateOfCreation
	 */
	public Date getDateOfCreation() {
		return dateOfCreation;
	}

	/**
	 * @param dateOfCreation the dateOfCreation to set
	 */
	public void setDateOfCreation(Date dateOfCreation) {
		this.dateOfCreation = dateOfCreation;
	}

	/**
	 * @return the patientProgressCreator
	 */
	public String getPatientProgressCreator() {
		return patientProgressCreator;
	}

	/**
	 * @param patientProgressCreator the patientProgressCreator to set
	 */
	public void setPatientProgressCreator(String patientProgressCreator) {
		this.patientProgressCreator = patientProgressCreator;
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
}
