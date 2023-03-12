package com.pool.oauth.service;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.security.oauth.model.UserModel;
import com.security.oauth.repository.UserModelRepository;

@Service
public class CustomUserDetailServiceImpl implements UserDetailsService{
	
	private Logger LOGGER=LoggerFactory.getLogger(CustomUserDetailServiceImpl.class);
	
	@Autowired
	private UserModelRepository userModelRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserModel userModel=userModelRepository.findByUsername(username);
		if(userModel==null){
			LOGGER.error("USER NOT FOUND WITH NEME :"+username);
			throw new UsernameNotFoundException("USER NOT FOUND WITH NEME :"+username);
		}else {
			boolean  enabled=userModel.isAccountVerified();
			UserDetails user = User.withUsername(userModel.getEmail())
	                .password(userModel.getPassword())
	                .disabled(enabled)
	                .authorities(
	                		Arrays.asList(userModel.getAuthorities())
	                			  .stream().map(SimpleGrantedAuthority::new)
	                			  .collect(Collectors.toList()))
	                			  .build();

	        return user;
		}
		
	}

}
