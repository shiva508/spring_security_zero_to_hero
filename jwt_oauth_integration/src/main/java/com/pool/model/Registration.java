package com.pool.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users")
public class Registration{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	private String firstName;
	private String lastName;
	private String fatherName;
	private String motherName;
	private String adharNumber;
	private String phoneNumber;
	private String userName;
	private String password;
	private String gender;
	private boolean enabled;
	@Temporal(TemporalType.DATE)
	@Column(updatable=false)
	private Date createdDate;
	@Temporal(TemporalType.DATE)
	private Date dateOfbirth;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "registration")
	private List<Role> roles = new ArrayList<Role>();

	public Registration() {
		
	}
	public Registration(Registration registration) {
		this.userId = registration.getUserId();
		this.firstName = registration.getFirstName();
		this.lastName = registration.getLastName();
		this.fatherName = registration.getFatherName();
		this.motherName = registration.getMotherName();
		this.adharNumber = registration.getAdharNumber();
		this.phoneNumber = registration.getPhoneNumber();
		this.userName = registration.getUserName();
		this.password = registration.getPassword();
		this.gender = registration.getGender();
		this.enabled = registration.isEnabled();
		this.roles = registration.getRoles();
		this.createdDate=registration.getCreatedDate();
		this.dateOfbirth=registration.getDateOfbirth();
	}



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
	public void setRoles(List<Role> roles) {
		this.roles = roles;
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

	public List<Role> getRoles() {
		return roles;
	}


	public void addRoleToUser(Role newrole) {
		newrole.setRegistration(this);
		roles.add(newrole);
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = new Date();
	}
	public Date getDateOfbirth() {
		return dateOfbirth;
	}
	public void setDateOfbirth(Date dateOfbirth) {
		this.dateOfbirth = dateOfbirth;
	}
	
	
}
