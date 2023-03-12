package com.pool.oauth.repository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.Tuple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.security.oauth.model.UserNamePassword;

@Repository
public class CustomUserModelRepositoryImpl implements CustomUserModelRepository {
	
	@Autowired
	private EntityManager entityManager;

	@Override
	public Map<String, String> getUserNamePassword() {
		Query usernamePassword=entityManager
				 .createNamedQuery("SELECT UM.USERNAME AS USERNAME ,UM.PASSWORD AS  PASSWORD FROM user_model UM ",UserNamePassword.class);
		List<UserNamePassword> asfAFS= usernamePassword.getResultList();
		System.out.println(asfAFS);
		return null;
	}

}
