package com.pool.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pool.entity.UserEntity;

public interface UserProfileRepository extends JpaRepository<UserEntity, Long> {
	public Optional<UserEntity> findByUsername(String username);
}
