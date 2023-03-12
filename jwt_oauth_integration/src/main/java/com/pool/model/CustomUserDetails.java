package com.security.model;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomUserDetails extends Registration implements UserDetails{
	
	public CustomUserDetails(final Registration registration) {
        super(registration);
    }
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return getRoles()
                .stream()
                .map(role -> new SimpleGrantedAuthority(role.getAuthority()))
                .collect(Collectors.toList());
	}
	 
	@Override
	public String getPassword() {
		return super.getPassword();
	}

	@Override
	public String getUsername() {
		return super.getUserName();
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
	@Override
	public String toString() {
		return "CustomUserDetails [getAuthorities()=" + getAuthorities() + ", getPassword()=" + getPassword()
				+ ", getUsername()=" + getUsername() + "]";
	}

}
