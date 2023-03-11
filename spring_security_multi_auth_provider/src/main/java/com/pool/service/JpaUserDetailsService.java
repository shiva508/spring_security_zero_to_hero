package com.pool.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pool.entity.UserEntity;
import com.pool.model.AutherisedUser;
import com.pool.repository.UserProfileRepository;
import com.pool.util.StudentpoolConstents;

@Service
public class JpaUserDetailsService implements UserDetailsService {

	private UserProfileRepository userProfileRepository;

	@Autowired
	public JpaUserDetailsService(UserProfileRepository userProfileRepository) {
		this.userProfileRepository = userProfileRepository;
	}

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) {
		Optional<UserEntity> optionalUser = userProfileRepository.findByUsername(username);
		UserEntity userEntity = null;
		if (optionalUser.isPresent()) {
			userEntity = optionalUser.get();
			return new AutherisedUser(userEntity);
		} else {
			throw new UsernameNotFoundException(StudentpoolConstents.USER_NOT_FOUND);
		}

	}

}
