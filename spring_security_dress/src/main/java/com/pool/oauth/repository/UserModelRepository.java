package com.pool.oauth.repository;

import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.security.oauth.model.UserModel;

@Repository
public interface UserModelRepository extends JpaRepository<UserModel, Long>,CustomUserModelRepository {
	UserModel findByUsername(String username);

	UserModel findByEmail(String email);

	UserModel findByUsernameOrEmail(String username, String email);
	
	
}
