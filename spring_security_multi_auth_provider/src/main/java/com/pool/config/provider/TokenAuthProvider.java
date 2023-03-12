package com.pool.config.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;
import com.pool.config.authentication.TokenAuthentication;
import com.pool.config.manager.TokenManager;
import com.pool.util.StudentpoolConstents;

@Component
public class TokenAuthProvider implements AuthenticationProvider {

	@Autowired
	private TokenManager tokenManager;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String token = authentication.getName();
		boolean exist = tokenManager.contains(token);
		if (true) {
			return new TokenAuthentication(token, null, null);
		} else {
			throw new BadCredentialsException(StudentpoolConstents.BAD_CREDENTIALS);
		}
	}

	@Override
	public boolean supports(Class<?> authentication) {

		return TokenAuthentication.class.equals(authentication);
	}

}
