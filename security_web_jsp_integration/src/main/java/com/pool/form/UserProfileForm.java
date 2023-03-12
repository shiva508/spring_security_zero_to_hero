package com.pool.form;

import java.util.List;

public class UserProfileForm {
private Integer userId;
private String userName;
private String lastName;
private String email;
private String phoneNumber;
private List<AddressForm> addressList;
private String profilePicture;
public Integer getUserId() {
	return userId;
}
public void setUserId(Integer userId) {
	this.userId = userId;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPhoneNumber() {
	return phoneNumber;
}
public void setPhoneNumber(String phoneNumber) {
	this.phoneNumber = phoneNumber;
}
public List<AddressForm> getAddressList() {
	return addressList;
}
public void setAddressList(List<AddressForm> addressList) {
	this.addressList = addressList;
}
public String getProfilePicture() {
	return profilePicture;
}
public void setProfilePicture(String profilePicture) {
	this.profilePicture = profilePicture;
}
@Override
public String toString() {
	return "UserProfileForm [userId=" + userId + ", userName=" + userName + ", lastName=" + lastName + ", email="
			+ email + ", phoneNumber=" + phoneNumber + ", addressList=" + addressList + ", profilePicture="
			+ profilePicture + "]";
}

}
