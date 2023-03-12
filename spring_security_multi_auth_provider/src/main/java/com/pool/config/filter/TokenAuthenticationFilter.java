package com.pool.config.filter;

import java.io.IOException;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import com.pool.config.authentication.TokenAuthentication;
import com.pool.util.StudentpoolConstents;

//@Component
public class TokenAuthenticationFilter extends OncePerRequestFilter {
	private AuthenticationManager authenticationManager;

	public TokenAuthenticationFilter(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		String token = request.getHeader(StudentpoolConstents.AUTHORIZATION);

		//boolean tokenManagerThread = GenericComponent.threadLocal.get().contains(token);
		Authentication tokenAuthentication = new TokenAuthentication(token, null);
		Authentication authenticated = authenticationManager.authenticate(tokenAuthentication);
		SecurityContextHolder.getContext().setAuthentication(authenticated);
		filterChain.doFilter(request, response);

	}

	@Override
	protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
		return request.getServletPath().equals("/login");
	}

}
