package com.pool.oauth.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.security.constants.DressConstants;
import com.security.forms.UserModelResponse;
import com.security.forms.payload.LogInResponse;
import com.security.forms.payload.LoginRequest;
import com.security.oauth.OauthLoginRequest;
import com.security.oauth.config.OauthJwtTokenProvider;
import com.security.oauth.constants.OAuthConstants;
import com.security.oauth.exception.UserNotFoundException;
import com.security.oauth.forms.UserPrinicipal;
import com.security.oauth.model.UserModel;
import com.security.oauth.service.UserModelService;
import com.security.utils.DressUtil;

@RestController
@RequestMapping("/oauthuser")
public class UserModelController {
	
	@Autowired
	private UserModelService userModelService;
	
	@Autowired
	private DressUtil  dressUtil;
	
	@Autowired
	private OauthJwtTokenProvider oauthJwtTokenProvider;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@PostMapping("/registeruser")
	public ResponseEntity<?> registerUserModel(@Valid @RequestBody UserModel userModel,BindingResult result,HttpServletRequest request,HttpServletResponse response) {
		ResponseEntity<?> errorResponse=dressUtil.validationResponseExtractorResult(result);
		if(errorResponse !=null) return errorResponse;
		boolean validUserNameEmail=userModelService.validateUser(userModel);
		UserModel createdModel=null;
		if(validUserNameEmail) {
			createdModel=userModelService.userRegistartion(userModel);	
		}
		
		return new ResponseEntity<UserModel>(createdModel,HttpStatus.CREATED);
	}
	@GetMapping("/allUserModels")
	public ResponseEntity<?> allUserModels(HttpServletRequest request,HttpServletResponse response) {
		List<UserModel> userModels=userModelService.allUserModels();
		if(null ==userModels || userModels.size()==0) {
			throw new UserNotFoundException("Sorry no users are found");
		}
		return new ResponseEntity<>(userModels, HttpStatus.OK);
	}
	
	@GetMapping("/userName/{username}")
	public ResponseEntity<?> getUserModelByUserName(@PathVariable("username")String username) {
		UserModel userModel=userModelService.getUserModelByUserName(username);
		return new ResponseEntity<UserModel>(userModel, HttpStatus.FOUND);
	}

	@GetMapping("/email/{email}")
	public ResponseEntity<?> findByEmail(@PathVariable("email")String email) {
		UserModel userModel=userModelService.findByEmail(email);
		return new ResponseEntity<UserModel>(userModel, HttpStatus.FOUND);
	}
	
	@PostMapping("/oauthLogin")
	public ResponseEntity<?> oauthUserLogin(@Valid @RequestBody OauthLoginRequest oauthLoginRequest,BindingResult result,HttpServletRequest request,HttpServletResponse response){
		ResponseEntity<?> errorResponse=dressUtil.validationResponseExtractorResult(result);
		if(errorResponse !=null) return errorResponse;
		Authentication authentication=oauthJwtTokenProvider.authenticate(oauthLoginRequest.getUsername(), oauthLoginRequest.getPassword());
		UserModel userModel=userModelService.getUserModelByUserName(oauthLoginRequest.getUsername());
		UserPrinicipal userPrinicipal=dressUtil.generateUserPriincipal(userModel);
		HttpHeaders httpJwtHeaders=oauthJwtTokenProvider.generateJwtOauthHeader(userPrinicipal);
		String oauthJwtToken=httpJwtHeaders.get(OAuthConstants.OAUTH_TOKEN_HEADER).get(0);
		userModel.setOauthJwtToken(oauthJwtToken);
		Cookie usernameCookie=dressUtil.cookieSetter("username", oauthLoginRequest.getUsername());
		response.addCookie(usernameCookie);
		Cookie useridCookie=dressUtil.cookieSetter("userId", userModel.getUserId());
		response.addCookie(useridCookie);
		Cookie emailCookie=dressUtil.cookieSetter("email", userModel.getEmail());
		response.addCookie(emailCookie);
		Cookie oauthJwtTokenCookie=dressUtil.cookieSetter("oauthJwtToken", oauthJwtToken);
		response.addCookie(oauthJwtTokenCookie);
		return new ResponseEntity<>(userModel,httpJwtHeaders,HttpStatus.OK);
	}

	@GetMapping("/usernamepassword")
	public ResponseEntity<?>  userNamePasswordGenerator(){
		Map<String, String> userNamePassword=userModelService.getUserNamePassword();
		return new ResponseEntity<>(userNamePassword, HttpStatus.OK);
	}
	
	@PostMapping("/updateusermodel")
	public ResponseEntity<?> updateUserModel(@RequestBody UserModel userModel){
		UserModel updatedModel=userModelService.updateUser(userModel);
		return new ResponseEntity<UserModel>(updatedModel,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/delete/{userId}")
	public ResponseEntity<?> deleteUserModel(@PathVariable("userId") Long userId){
		UserModelResponse userModelResponse=userModelService.deleteUserModel(userId);
		return new ResponseEntity<>(userModelResponse, HttpStatus.OK);
	}
	
}	
	
	