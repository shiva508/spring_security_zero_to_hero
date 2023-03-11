package com.pool.service.otp;

import java.util.Optional;

import com.pool.entity.OtpEntity;

public interface OtpService {
	public Optional<OtpEntity> findByUsername(String username);

	public OtpEntity saveOtpEntity(String username);
}
