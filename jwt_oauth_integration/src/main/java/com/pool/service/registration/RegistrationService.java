package com.pool.service.registration;

import java.util.List;

import com.pool.forms.RegistrationForm;
import com.pool.model.CachePerson;
public interface RegistrationService {
	public RegistrationForm saveUser(RegistrationForm registrationForm);
	public List<RegistrationForm> usersList();
	public RegistrationForm updateUser(RegistrationForm registrationForm);
	public Integer deleteUser(Integer userid);
	public RegistrationForm getUserByEmailAndPassword(String userName,String password);
	public RegistrationForm getUserByUserId(Integer userId);
	public List<CachePerson> getAllCachePersons();
	public Long isUserExist(String userName);
}
