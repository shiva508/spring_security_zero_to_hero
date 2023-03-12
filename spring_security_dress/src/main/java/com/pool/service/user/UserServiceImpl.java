package com.pool.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.security.model.User;
import com.security.password.PasswordEncoderUtil;
import com.security.repository.user.UserReoitory;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserReoitory userReoitory;
	
	@Autowired
	private PasswordEncoderUtil passwordEncoderUtil;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	@Transactional
	public User saveUser(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		return userReoitory.save(user);
	}
	
	
}
