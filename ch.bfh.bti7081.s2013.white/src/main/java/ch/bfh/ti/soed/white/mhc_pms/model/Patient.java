package ch.bfh.ti.soed.white.mhc_pms.model;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Entity implementation class for Entity: Patient
 *
 */
@Entity
public class Patient extends PmsItem implements Serializable {

	private static int counter = 1;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	
	@NotNull
	@Size(min = 2, max = 24)
	private String firstName;
	
	@NotNull
	@Size(min = 2, max = 24)
	private String lastName;
	
	@NotNull
	@Temporal(value = TemporalType.DATE)
	private Date dateOfBirth;
	
	private static final long serialVersionUID = 1L;

	public Patient() {
		super();
		this.firstName = "";
		this.lastName = "";
		this.dateOfBirth = new Date();
		this.id = counter++;
	}   
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

}
