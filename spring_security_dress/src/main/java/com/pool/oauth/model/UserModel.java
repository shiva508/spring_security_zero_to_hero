package com.pool.oauth.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table
public class UserModel{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String userId;
	
	@NotBlank(message = "FIRST NAME CAN'T BE BLANK")
	@NotNull(message = "FIRST NAME CAN'T BE NULL")
	private String firstName;

	private String lastName;
	
	@NotBlank(message = "USER NAME CAN'T BE BLANK")
	@NotNull(message = "USER NAME CAN'T BE NULL")
	private String username;

	@NotBlank(message = "PASSWORD CAN'T BE BLANK")
	@NotNull(message = "PASSWORD CAN'T BE NULL")
	private String password;
	
	@NotBlank(message = "EMAIL CAN'T BE BLANK")
	@NotNull(message = "EMAIL CAN'T BE NULL")
	@Email(message = "PLEASE ENTER VALID EMAIL")
	private String email;

	private String profileImageUrl;

	private Date lastLoginDate;

	private Date lastLoginDateDisplay;

	private Date joinDate;

	private String roles;

	private String[] authorities;

	private boolean isActive;

	private boolean isNotLocked;
	
	@Transient
	private String oauthJwtToken;
	@Transient
	private boolean accountVerified;
	

	public UserModel() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getProfileImageUrl() {
		return profileImageUrl;
	}

	public void setProfileImageUrl(String profileImageUrl) {
		this.profileImageUrl = profileImageUrl;
	}

	public Date getLastLoginDate() {
		return lastLoginDate;
	}

	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	public Date getLastLoginDateDisplay() {
		return lastLoginDateDisplay;
	}

	public void setLastLoginDateDisplay(Date lastLoginDateDisplay) {
		this.lastLoginDateDisplay = lastLoginDateDisplay;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public String[] getAuthorities() {
		return authorities;
	}

	public void setAuthorities(String[] authorities) {
		this.authorities = authorities;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public boolean isNotLocked() {
		return isNotLocked;
	}

	public void setNotLocked(boolean isNotLocked) {
		this.isNotLocked = isNotLocked;
	}

	public String getOauthJwtToken() {
		return oauthJwtToken;
	}

	public void setOauthJwtToken(String oauthJwtToken) {
		this.oauthJwtToken = oauthJwtToken;
	}

	public boolean isAccountVerified() {
		return accountVerified;
	}

	public void setAccountVerified(boolean accountVerified) {
		this.accountVerified = accountVerified;
	}

	
	
}
