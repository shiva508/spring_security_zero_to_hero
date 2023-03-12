package com.pool.oauth.service;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.security.oauth.forms.UserPrinicipal;
import com.security.oauth.model.UserModel;
import com.security.oauth.repository.UserModelRepository;

@Service
public class CustomUserModelService implements UserDetailsService{
	
	private Logger LOGGER=LoggerFactory.getLogger(CustomUserModelService.class);
	
	@Autowired
	private UserModelRepository userModelRepository;
	
	@Autowired
	private LoginAttemptService loginAttemptService;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserModel userModel=userModelRepository.findByUsername(username);
		if(userModel==null){
			LOGGER.error("USER NOT FOUND WITH NEME :"+username);
			throw new UsernameNotFoundException("USER NOT FOUND WITH NEME :"+username);
		}else {
			loginAttemptsalidation(userModel);
			userModel.setLastLoginDateDisplay(userModel.getLastLoginDate());
			userModel.setLastLoginDate(new Date());
			userModelRepository.save(userModel);
			UserPrinicipal userPrinicipal=new UserPrinicipal(userModel);
			LOGGER.info("User Infermation :"+userPrinicipal);
			return userPrinicipal;
		}
	}

	public void loginAttemptsalidation(UserModel userModel) {
			if(userModel.isNotLocked()) {
				if(loginAttemptService.hasExceededMaxAttempts(userModel.getUsername())) {
					userModel.setNotLocked(false);
				}else {
					userModel.setNotLocked(true);
				}
			}else {
				loginAttemptService.evictUserFromLoginAttemptCache(userModel.getUsername());
			}
	}


}
