package com.pool.model;

import java.io.Serial;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.pool.entity.User;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserProfile implements UserDetails {

	@Serial
	private static final long serialVersionUID = 1L;

	private final User user;
	@Override
	public String getUsername() {
		return user.getUsername();
	}
	@Override
	public String getPassword() {
		return user.getPassword();
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		if(null !=user.getAuthoritiesEntities() && !user.getAuthoritiesEntities().isEmpty()) {
			return user.getAuthoritiesEntities().stream().map(data -> new SimpleGrantedAuthority(data.getAuthority()))
					.collect(Collectors.toList());
		}
		return List.of(() -> "read");
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
