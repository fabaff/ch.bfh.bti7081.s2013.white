package ch.bfh.ti.soed.white.mhc_pms.data;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import ch.bfh.ti.soed.white.mhc_pms.data.enums.UserGroup;

/**
 * Entity implementation class for Entity: PmsUser.
 * Each user can have zero to n associated patient cases.
 * 
 * @author Group White, I2p, BFH Berne, <a
 *         href="https://github.com/fabaff/ch.bfh.bti7081.s2013.white"
 *         >Contact</a>
 * @version 1.0.0
 * 
 */
@Entity
@Table(name = "PmsUser")
public class PmsUser implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@NotNull
	private String clinic = "";
	
	private String department = "";
	
	@NotNull
	@Size(min = 2, max = 64)
	private String firstName = "";
	
	@NotNull
	@Size(min = 2, max = 64)
	private String lastName = "";
	
	@NotNull
	private String password = "";

	@OneToMany(mappedBy = "therapist")
	private Set<PCase> pCases = new HashSet<>();
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int uid = 0;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private UserGroup userGroup = UserGroup.PSYCHOLOGIST;
	
	@NotNull
	private String userName = "";
	
	public PmsUser() {}

	/**
	 * @return the clinic
	 */
	public String getClinic() {
		return clinic;
	}

	/**
	 * @return the department
	 */
	public String getDepartment() {
		return department;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @return the pCases
	 */
	public Set<PCase> getpCases() {
		return pCases;
	}

	/**
	 * @return the UID
	 */
	public int getUid() {
		return uid;
	}

	/**
	 * @return the userGroup
	 */
	public UserGroup getUserGroup() {
		return userGroup;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param clinic the clinic to set
	 */
	public void setClinic(String clinic) {
		this.clinic = clinic;
	}

	/**
	 * @param department the department to set
	 */
	public void setDepartment(String department) {
		this.department = department;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @param pCases the pCases to set
	 */
	public void setpCases(Set<PCase> pCases) {
		this.pCases = pCases;
	}

	/**
	 * @param uid the UID to set
	 */
	public void setUid(int uid) {
		this.uid = uid;
	}

	/**
	 * @param userGroup the userGroup to set
	 */
	public void setUserGroup(UserGroup userGroup) {
		this.userGroup = userGroup;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PmsUser [uid=" + uid + ", userName=" + userName + ", password="
				+ password + ", userGroup=" + userGroup + ", firstName="
				+ firstName + ", lastName=" + lastName + ", clinic=" + clinic
				+ ", department=" + department + ", pCases.size()=" + pCases.size() + "]";
	}

}
