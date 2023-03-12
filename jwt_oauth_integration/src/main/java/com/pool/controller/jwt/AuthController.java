package com.security.controller.jwt;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.security.config.BCryptPasswordEncoderPro;
import com.security.forms.RegistrationForm;
import com.security.forms.RoleForm;
import com.security.jwt.JwtTokenProvider;
import com.security.jwt.model.ApiResponse;
import com.security.jwt.model.JwtAuthenticationResponse;
import com.security.jwt.model.LoginRequest;
import com.security.jwt.model.SignUpRequest;
import com.security.repository.registration.RegistrationJpa;
import com.security.service.registration.RegistrationService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	RegistrationJpa registrationJpa;

	@Autowired
	BCryptPasswordEncoderPro bCryptPasswordEncoderPro;

	@Autowired
	JwtTokenProvider tokenProvider;
	@Autowired
	private RegistrationService registrationService;
	
	@Autowired
    PasswordEncoder passwordEncoder;

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsernameOrEmail(), passwordEncoder.encode(loginRequest.getPassword())));

		SecurityContextHolder.getContext().setAuthentication(authentication);

		String jwt = tokenProvider.generateToken(authentication);
		return ResponseEntity.ok(new JwtAuthenticationResponse(jwt));
	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {
		if (registrationJpa.existsByUserName(signUpRequest.getUsername())) {
			return new ResponseEntity(new ApiResponse(false, "Username is already taken!"), HttpStatus.BAD_REQUEST);
		}
		RegistrationForm registration=new RegistrationForm();
		registration.setUserName(signUpRequest.getEmail());
		registration.setFirstName(signUpRequest.getName());
		registration.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
		RoleForm role=new RoleForm();
		role.setAuthority("ROLE_USER");
		registration.getRoles().add(0, role);
		RegistrationForm result=registrationService.saveUser(registration);

		URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/{username}")
				.buildAndExpand(result.getUserId()).toUri();

		return ResponseEntity.created(location).body(new ApiResponse(true, "User registered successfully"));
	}
	@GetMapping("/users")
	public ResponseEntity<?> usersList(Model model) {
		return new ResponseEntity(registrationService.usersList(),HttpStatus.OK);
	}
}
