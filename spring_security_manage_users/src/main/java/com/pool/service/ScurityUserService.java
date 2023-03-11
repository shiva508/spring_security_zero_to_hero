package com.pool.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.pool.model.UserProfile;
import com.pool.repository.UserRepository;

@Service
public class ScurityUserService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) {
		var optionalUser = userRepository.findByUsername(username);

		return optionalUser.map(UserProfile::new).orElseThrow(() -> new UsernameNotFoundException("User Not found"));
	}
}
