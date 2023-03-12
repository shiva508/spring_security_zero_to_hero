package com.security.repository.registration;

import java.util.List;

import com.security.model.CachePerson;
import com.security.model.Registration;

public interface RegistrationDao {
	public Registration saveUser(Registration registration);

	public List<Registration> usersList();

	public void updateUser(Registration registration);

	public Integer deleteUser(Integer userid);

	public Registration getUserByEmailAndPassword(String userName, String password);

	public Registration getUserByUserId(Integer userId);

	public List<CachePerson> getAllCachePersons();

	public Long isUserExist(String userName);

	public Registration getUserByEmail(String userName);
}
