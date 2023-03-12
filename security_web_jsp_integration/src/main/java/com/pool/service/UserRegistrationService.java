package com.pool.service;

import com.pool.model.UserRegistration;

public interface UserRegistrationService {
public UserRegistration saveUserRegistration(UserRegistration registration);

public UserRegistration registeredUser(String email,String password);
}
