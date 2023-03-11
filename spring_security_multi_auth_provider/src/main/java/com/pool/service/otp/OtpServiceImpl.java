package com.pool.service.otp;

import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pool.entity.OtpEntity;
import com.pool.repository.OtpRepository;

@Service
public class OtpServiceImpl implements OtpService {
	@Autowired
	private OtpRepository otpRepository;

	@Override
	public Optional<OtpEntity> findByUsername(String username) {
		return otpRepository.findByUsername(username);
	}

	@Override
	public OtpEntity saveOtpEntity(String username) {
		Random random = new Random();
		String code = String.valueOf(random.nextInt(9999 + 1000));
		OtpEntity otpEntity = new OtpEntity();
		otpEntity.setUsername(username);
		otpEntity.setOpt(code);
		return otpRepository.save(otpEntity);
	}

}
