package com.pool.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pool.entity.UserEntity;
import com.pool.model.AutherisedUser;
import com.pool.repository.UserProfileRepository;
import com.pool.util.StudentpoolConstents;

@Service
public class UserProfileServiceImpl implements UserProfileService {

	private UserProfileRepository userProfileRepository;

	@Autowired
	public UserProfileServiceImpl(UserProfileRepository userProfileRepository) {
		this.userProfileRepository = userProfileRepository;
	}

}
