package ch.bfh.ti.soed.white.mhc_pms.data;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import ch.bfh.ti.soed.white.mhc_pms.data.enums.UserGroup;

/**
 * Entity implementation class for Entity: PmsUser
 *
 */
@Entity
@Table(name = "PmsUser")
public class PmsUser implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int uid = 0;
	
	@NotNull
	private String userName = "";
	
	@NotNull
	private String password = "";
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private UserGroup userGroup = UserGroup.MEDICAL_STAFF;
	
	@NotNull
	@Size(min = 2, max = 64)
	private String firstName = "";

	@NotNull
	@Size(min = 2, max = 64)
	private String lastName = "";
	
	@NotNull
	private String clinic = "";
	
	private String department = "";
	
	@OneToMany(mappedBy = "therapist")
	private Set<PCase> pCases = new HashSet<>();
	
	public PmsUser() {
		// TODO Permission
//		this.uiPermission = UIPermissionSingleton.createUIState(clazz);
//		this.dataAccess = PmsDataAccess.getInstance();
	}

	/**
	 * @return the uid
	 */
	public int getUid() {
		return uid;
	}

	/**
	 * @param uid the uid to set
	 */
	public void setUid(int uid) {
		this.uid = uid;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the userGroup
	 */
	public UserGroup getUserGroup() {
		return userGroup;
	}

	/**
	 * @param userGroup the userGroup to set
	 */
	public void setUserGroup(UserGroup userGroup) {
		this.userGroup = userGroup;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the clinic
	 */
	public String getClinic() {
		return clinic;
	}

	/**
	 * @param clinic the clinic to set
	 */
	public void setClinic(String clinic) {
		this.clinic = clinic;
	}

	/**
	 * @return the department
	 */
	public String getDepartment() {
		return department;
	}

	/**
	 * @param department the department to set
	 */
	public void setDepartment(String department) {
		this.department = department;
	}

}
