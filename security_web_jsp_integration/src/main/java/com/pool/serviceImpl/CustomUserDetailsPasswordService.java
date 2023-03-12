package com.pool.serviceImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import com.pool.dao.UserRepository;
import com.pool.model.Role;
import com.pool.model.User;

public class CustomUserDetailsPasswordService implements AuthenticationProvider {
	@Autowired
	private UserRepository userRepository;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		UsernamePasswordAuthenticationToken authenticationToken = null;
		String userName = authentication.getName();
		String password = authentication.getCredentials().toString();
		Optional<User> user = userRepository.findByUserNameAndPassword(userName, password);
		user.orElseThrow(() -> new UsernameNotFoundException("Usernot found"));
		User userObject = user.get();
		Collection<GrantedAuthority> grantedAuthorities = getGrantedAuthorities(userObject);
		authenticationToken = new UsernamePasswordAuthenticationToken(
				new org.springframework.security.core.userdetails.User(userName, password, grantedAuthorities),
				password, grantedAuthorities);
		return authenticationToken;
	}

	public Collection<GrantedAuthority> getGrantedAuthorities(User user) {
		Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();
		authoritiesChange(user, grantedAuthorities);
		return grantedAuthorities;
	}

	private void authoritiesChange(User user, Collection<GrantedAuthority> grantedAuthorities) {
		for (Role roles : user.getRoles()) {
			grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_" + roles.getRole().trim()));
		}
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
