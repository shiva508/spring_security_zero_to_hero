package com.pool.controller.user;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.security.config.JWTTokenProvider;
import com.security.constants.DressConstants;
import com.security.forms.payload.LogInResponse;
import com.security.forms.payload.LoginRequest;
import com.security.model.User;
import com.security.service.user.CustomUserDetailsService;
import com.security.service.user.UserService;
import com.security.utils.DressUtil;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	
	@Autowired
	private JWTTokenProvider jWTTokenProvider;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private DressUtil  dressUtil;
	
	@PostMapping("/login")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest,BindingResult result){
		ResponseEntity<?> errorResponse=dressUtil.validationResponseExtractorResult(result);
		if(errorResponse !=null) return errorResponse;
		
		Authentication authentication=authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(
						loginRequest.getUsername(), 
						loginRequest.getPassword()
						));
		SecurityContextHolder.getContext().setAuthentication(authentication); 
		
		String JWT_TOKEN=DressConstants.TOKEN_PREFIX+jWTTokenProvider.tokenGenerator(authentication);
		
		return ResponseEntity.ok(new LogInResponse(true, JWT_TOKEN));
		
	}
	
	@PostMapping("/register")
	public ResponseEntity<?> registerUser(@Valid @RequestBody User user,BindingResult result) {
		ResponseEntity<?> errorResponse=dressUtil.validationResponseExtractorResult(result);
		if(errorResponse !=null) return errorResponse;
		User newUser=userService.saveUser(user);
		return new ResponseEntity<User>(newUser,HttpStatus.CREATED);
	}
	
	@GetMapping("/{username}")
	public ResponseEntity<User> findByUsername(@PathVariable("username")String username){
		User user=(User) customUserDetailsService.loadUserByUsername(username);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	@GetMapping("/userId/{userId}")
	public ResponseEntity<?> findByUserId(@PathVariable("userId")Long userId){
		User user=customUserDetailsService.findByUserId(userId);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
}
