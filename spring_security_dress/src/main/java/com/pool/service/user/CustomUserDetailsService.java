package com.pool.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.security.exception.UserNotFoundException;
import com.security.model.User;
import com.security.repository.user.UserReoitory;

@Service
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private UserReoitory userReoitory;
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user=userReoitory.findByUsername(username);
		if(user==null) {
			throw new UsernameNotFoundException("User Not Found By User Name "+username);
		} 
		return user;
	}
	
	@Transactional
	public User findByUserId(Long  userId) {
		User user=userReoitory.findByUserId(userId);
		if(user==null) {
			throw new UserNotFoundException("User is Not find with id :"+userId);
		}
		return user;
	}
}
