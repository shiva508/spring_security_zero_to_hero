package com.pool.config.filter;

import java.io.IOException;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import com.pool.config.authentication.CustomAuthentication;

//@Component
public class CustomAuthenticationFilter implements Filter {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		String authorization = httpServletRequest.getHeader("Authorization");
		CustomAuthentication authentication = new CustomAuthentication(authorization, null);
		Authentication result = authenticationManager.authenticate(authentication);
		if (result.isAuthenticated()) {
			SecurityContextHolder.getContext().setAuthentication(result);
			chain.doFilter(request, response);
		}

	}

}
