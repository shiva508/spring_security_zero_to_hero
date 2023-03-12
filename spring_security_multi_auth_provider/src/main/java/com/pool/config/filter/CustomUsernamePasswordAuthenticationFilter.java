package com.pool.config.filter;

import java.io.IOException;
import java.util.UUID;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import com.pool.config.authentication.OtpAuthentication;
import com.pool.config.authentication.UsernamePasswordAuthentication;
import com.pool.config.manager.TokenManager;
import com.pool.service.otp.OtpService;
import com.pool.util.StudentpoolConstents;

//@Component
public class CustomUsernamePasswordAuthenticationFilter extends OncePerRequestFilter {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private OtpService otpService;

	@Autowired
	private TokenManager tokenManager;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String username = request.getHeader("username");
		String password = request.getHeader("password");
		String otp = request.getHeader("otp");
		if (null == otp) {
			// step1
			Authentication upAuthentication = new UsernamePasswordAuthentication(username, password);
			Authentication authenticate = authenticationManager.authenticate(upAuthentication);
			// SecurityContextHolder.getContext().setAuthentication(authenticate);
			// Generate OTP
			otpService.saveOtpEntity(username);
		} else {
			// step2
			Authentication otpAuthentication = new OtpAuthentication(username, otp);
			Authentication authenticate = authenticationManager.authenticate(otpAuthentication);
			// SecurityContextHolder.getContext().setAuthentication(authenticate);
			// GENERATE TOKEN
			String token = UUID.randomUUID().toString();
			tokenManager.addToken(token);
			response.addHeader(StudentpoolConstents.AUTHORIZATION, token);
		}
	}

	@Override
	protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
		return !request.getServletPath().equals("/login");
	}

}
