package com.pool.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.security.model.User;

@Repository
public interface UserReoitory extends JpaRepository<User, Long> {

	public User findByUsername(String username);
	public User findByUserId(Long userId);
}
