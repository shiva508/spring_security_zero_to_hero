package com.pool.service;

import com.pool.form.UserForm;

public interface UserService {
public UserForm saveUser(UserForm userForm); 
public UserForm getUser(Integer userId);

}
