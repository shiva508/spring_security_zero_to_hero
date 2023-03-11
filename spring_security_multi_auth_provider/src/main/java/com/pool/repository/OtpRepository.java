package com.pool.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pool.entity.OtpEntity;

public interface OtpRepository extends JpaRepository<OtpEntity, Long> {
	Optional<OtpEntity> findByUsername(String username);
}
