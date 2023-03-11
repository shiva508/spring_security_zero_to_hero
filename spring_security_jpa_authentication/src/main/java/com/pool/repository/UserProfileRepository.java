package com.pool.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pool.entity.UserProfile;

public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {
	public Optional<UserProfile> findByUsername(String username);
}
