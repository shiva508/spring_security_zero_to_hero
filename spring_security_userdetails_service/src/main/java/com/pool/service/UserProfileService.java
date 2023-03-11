package com.pool.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.pool.entity.UserProfile;
import com.pool.model.AutherisedUser;
import com.pool.repository.UserProfileRepository;

public class UserProfileService implements UserDetailsService {

	@Autowired
	private UserProfileRepository profileRepository;

	@Override
	public UserDetails loadUserByUsername(String username) {
		Optional<UserProfile> optionalUserProfile = profileRepository.findByUsername(username);
		UserProfile userProfile = optionalUserProfile.orElseThrow(() -> new UsernameNotFoundException(""));
		return new AutherisedUser(userProfile);
	}

}
