package com.pool.config.provider;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;
import com.pool.config.authentication.OtpAuthentication;
import com.pool.config.authentication.UsernamePasswordAuthentication;
import com.pool.entity.OtpEntity;
import com.pool.service.otp.OtpService;
import com.pool.util.StudentpoolConstents;

@Component
public class OtpAuthenicationProvider implements AuthenticationProvider {

	private OtpService otpService;

	@Autowired
	public OtpAuthenicationProvider(OtpService otpService) {
		this.otpService = otpService;
	}

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = authentication.getName();
		String otp = (String) authentication.getCredentials();
		Optional<OtpEntity> optionalOtp = otpService.findByUsername(username);
		if (optionalOtp.isPresent()) {
			return new OtpAuthentication(username, otp, List.of(() -> "read"));
		} else {
			throw new BadCredentialsException(StudentpoolConstents.BAD_CREDENTIALS);
		}
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return OtpAuthentication.class.equals(authentication);
	}

}
