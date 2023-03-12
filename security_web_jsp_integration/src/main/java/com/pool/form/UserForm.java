package com.pool.form;

import java.util.List;

public class UserForm {
	private Integer userId;
	private String userName;
	private Integer userRegistrationId;
	private List<AddressForm> addressForm;

	public UserForm() {
		super();
	}

	public Integer getUserRegistrationId() {
		return userRegistrationId;
	}

	public void setUserRegistrationId(Integer userRegistrationId) {
		this.userRegistrationId = userRegistrationId;
	}

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

	public List<AddressForm> getAddressForm() {
		return addressForm;
	}

	public void setAddressForm(List<AddressForm> addressForm) {
		this.addressForm = addressForm;
	}

	@Override
	public String toString() {
		return "UserForm [userId=" + userId + ", userName=" + userName + ", userRegistrationId=" + userRegistrationId
				+ ", addressForm=" + addressForm + "]";
	}



}
