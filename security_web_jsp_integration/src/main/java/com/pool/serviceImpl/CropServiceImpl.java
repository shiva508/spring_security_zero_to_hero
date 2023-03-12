package com.pool.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pool.dao.CropRepository;
import com.pool.model.Crop;
import com.pool.service.CropService;
@Service
@Transactional
public class CropServiceImpl implements CropService {
	@Autowired
	CropRepository cropRepository;

	@Override
	public Crop saveCrop(Crop crop) {
	
		return cropRepository.save(crop);
	}
}
