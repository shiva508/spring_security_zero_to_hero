package com.pool.model;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.pool.entity.UserProfile;

public class AutherisedUser implements UserDetails {
	private final UserProfile userProfile;

	public AutherisedUser(UserProfile userProfile) {
		this.userProfile = userProfile;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of(() -> "read");
	}

	@Override
	public String getPassword() {

		return this.userProfile.getPassword();
	}

	@Override
	public String getUsername() {
		return this.userProfile.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
