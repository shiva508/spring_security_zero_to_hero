package com.pool.password;

import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PasswordEncoderUtil {
	public String bCryptPasswordEncoder(String rawPassword) {
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		String encodedPassword = encoder.encode(rawPassword);
		return encodedPassword;
	}
	
	public String argon2PasswordEncoder(String rawPassword) {
		PasswordEncoder encoder=new Argon2PasswordEncoder();
		String encodedPassword=encoder.encode(rawPassword);
		return encodedPassword;
	}
	
	public String Pbkdf2PasswordEncoder(String rawPassword) {
		PasswordEncoder encoder=new org.springframework.security.crypto.password.Pbkdf2PasswordEncoder();
		String encodedPassword=encoder.encode(rawPassword);
		return encodedPassword;
	}
	
	public String sCryptPasswordEncoder(String rawPassword) {
		PasswordEncoder encoder=new SCryptPasswordEncoder();
		String encodedPassword=encoder.encode(rawPassword);
		return encodedPassword;
	}
	
	public PasswordEncoder byPasswordEncoder() {
		return new BCryptPasswordEncoder(10);
	}
}
