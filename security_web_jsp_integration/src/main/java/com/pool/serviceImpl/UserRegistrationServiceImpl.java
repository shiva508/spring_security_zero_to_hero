package com.pool.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pool.dao.UserRegistrationRepository;
import com.pool.model.UserRegistration;
import com.pool.service.UserRegistrationService;
@Service
public class UserRegistrationServiceImpl implements UserRegistrationService {
	@Autowired
	UserRegistrationRepository userRegistrationRepository; 
	@Override
	@Transactional
	public UserRegistration saveUserRegistration(UserRegistration registration) {
		UserRegistration savedUser=null;
		UserRegistration userRegistration=userRegistrationRepository.save(registration);
		savedUser=userRegistration;
		return savedUser;
	}

	@Override
	@Transactional
	public UserRegistration registeredUser(String email, String password) {
		// TODO Auto-generated method stub
		return null;
	}

}
