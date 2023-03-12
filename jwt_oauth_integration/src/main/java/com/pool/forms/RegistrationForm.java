package com.security.forms;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.NotNull;
public class RegistrationForm {

	private Integer userId;
	@NotNull(message="should not be empty")
	private String firstName;
	private String lastName;
	private String fatherName;
	private String motherName;
	private String adharNumber;
	private String phoneNumber;
	private String userName;
	private String password;
	private boolean enabled;
	private String gender;
	public List<String> dummyRoles=new ArrayList<String>();
	private List<RoleForm> roles=new ArrayList<RoleForm>();
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public String getAdharNumber() {
		return adharNumber;
	}

	public void setAdharNumber(String adharNumber) {
		this.adharNumber = adharNumber;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	
	

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public List<RoleForm> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleForm> roles) {
		this.roles = roles;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public List<String> getDummyRoles() {
		return dummyRoles;
	}

	public void setDummyRoles(List<String> dummyRoles) {
		this.dummyRoles = dummyRoles;
	}

	@Override
	public String toString() {
		return "RegistrationForm [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", fatherName=" + fatherName + ", motherName=" + motherName + ", adharNumber=" + adharNumber
				+ ", phoneNumber=" + phoneNumber + ", userName=" + userName + ", password=" + password + ", enabled="
				+ enabled + ", gender=" + gender + ", dummyRoles=" + dummyRoles + ", roles=" + roles + "]";
	}

	

	

}
