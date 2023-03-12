package com.pool.oauth.forms;


import java.util.Collection;
import java.util.stream.Collectors;
import java.util.Arrays;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.security.oauth.model.UserModel;

public class UserPrinicipal implements UserDetails{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserModel userModel;
	
	public UserPrinicipal(UserModel userModel) {
		super();
		this.userModel = userModel;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Arrays.asList(this.userModel.getAuthorities()).stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
	}

	@Override
	public String getPassword() {
		
		return this.userModel.getPassword();
	}

	@Override
	public String getUsername() {
		
		return this.userModel.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		
		return this.userModel.isNotLocked();
	}

	@Override
	public boolean isCredentialsNonExpired() {
		
		return true;
	}

	@Override
	public boolean isEnabled() {
		
		return this.userModel.isActive();
	}

}
