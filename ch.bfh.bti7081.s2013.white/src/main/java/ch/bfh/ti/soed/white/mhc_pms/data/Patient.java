package ch.bfh.ti.soed.white.mhc_pms.data;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Entity implementation class for Entity: Patient
 * 
 */
@Entity
@Table(name = "Patient")
public class Patient extends MhcPmsItem implements Serializable {

	private static final long serialVersionUID = -5457255038025906437L;

	@NotNull
	@Size(min = 2, max = 24)
	private String firstName = "";

	@NotNull
	@Size(min = 2, max = 24)
	private String lastName = "";

	@NotNull
	@Temporal(value = TemporalType.DATE)
	private Date dateOfBirth = new Date();

	@NotNull
	private String gender = "";

	@OneToMany(mappedBy = "patient")
	private Set<PCase> caseSet;
	
	@NotNull
	private String status = "";

	@NotNull
	private String kindOfTreatment = "";
	
	@Transient
	private MhcPmsContainer<PCase> caseContainer;

	public Patient() {
//		this.firstName = "";
//		this.lastName = "";
//		this.dateOfBirth = new Date();
//		this.gender = "";
//		this.status = "";
//		this.kindOfTreatment = "";
		// TODO restliche Felder
	}

	public Patient(MhcPmsContainer<PCase> caseContainer) {
		this.caseSet = this.caseContainer = caseContainer;
	}
	
	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDateOfBirth() {
		return this.dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	protected void setCurrentContainer() {
		 if (this.caseContainer != null) {
			MhcPmsDataAccess.getInstance().setCurrentContainer(PCase.class,
					this.caseContainer);
			this.caseContainer.setFirstItemAsCurrent();
		}
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getKindOfTreatment() {
		return kindOfTreatment;
	}

	public void setKindOfTreatment(String kindOfTreatment) {
		this.kindOfTreatment = kindOfTreatment;
	}
}
