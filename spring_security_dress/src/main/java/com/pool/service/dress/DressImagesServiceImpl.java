package com.pool.service.dress;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.security.dress.exception.DressNotFoundException;
import com.security.dress.model.DressImages;
import com.security.repository.dress.DressImagesRepository;

@Service
public class DressImagesServiceImpl implements DressImagesService {
	
	@Autowired
	private DressImagesRepository dressImagesRepository;

	@Override
	@Transactional
	public List<DressImages> getAllImages() {
		List<DressImages> dressImages=dressImagesRepository.findAll();
		if(null !=dressImages || dressImages.size()==0) {
			throw new DressNotFoundException("No Dress is Found");
		}
		return dressImages;
	}

	@Override
	@Transactional
	public List<DressImages> getDressImagesByDressCode(String dressCode) {
		List<DressImages> dressImages=dressImagesRepository.findByDressCode(dressCode);
		if(null !=dressImages || dressImages.size()==0) {
			throw new DressNotFoundException("No Dress is Found With code:"+dressCode);
		}
		return dressImages;
	}

}
