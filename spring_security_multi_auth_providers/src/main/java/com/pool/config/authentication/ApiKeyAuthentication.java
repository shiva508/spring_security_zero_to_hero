package com.pool.config.authentication;

import java.util.Collection;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ApiKeyAuthentication implements Authentication {

	@Getter
	private final String key;
	private boolean authenticated;

	@Override
	public String getName() {
		return null;
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}
	@Override
	public Object getCredentials() {
		return null;
	}
	@Override
	public Object getDetails() {
		return null;
	}
	@Override
	public Object getPrincipal() {
		return null;
	}
	@Override
	public boolean isAuthenticated() {
		return authenticated;
	}
	@Override
	public void setAuthenticated(boolean authenticated) throws IllegalArgumentException {
		this.authenticated = authenticated;
	}
}
