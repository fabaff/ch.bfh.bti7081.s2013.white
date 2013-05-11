package ch.bfh.ti.soed.white.mhc_pms.model;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Patient
 *
 */
@Entity
public class Patient implements Serializable {

	@Id
	//@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	
	private String firstName;
		
	private String lastName;
	
	@Temporal(value = TemporalType.DATE)
	private Date dateOfBirth;
	
	private static final long serialVersionUID = 1L;

	public Patient() {
		super();
		this.firstName = "Patrick";
		this.lastName = "Kofmel";
		this.dateOfBirth = new Date(1000);
		this.id = 1;
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
