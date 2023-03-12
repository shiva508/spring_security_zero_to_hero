package com.pool.forms.payload;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class LoginRequest {
	@NotBlank(message = "User Name can not be blank")
	@Email(message = "User name should be email")
	private String username;
	@NotBlank(message = "password can not be blank")
	private String password;
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
	
	
}
