package com.pool.service.dress;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.security.dress.form.DressResponseForm;
import com.security.dress.model.DressModel;
import com.security.exception.DuplicateDressException;
import com.security.repository.dress.DressRepository;
import com.security.utils.DressUtil;


@Service
public class DressServiceImpl implements DressService {
	
	@Autowired
	private DressRepository dressRepository;

	@Autowired
	private DressUtil  dressUtil;
	
	@Override
	@Transactional
	public DressModel saveDress(DressModel dressModel) {
		try {
			dressUtil.dressImageProcessor(dressModel);
			return dressRepository.save(dressModel);
		} catch (Exception e) {
			throw new DuplicateDressException("Dress is already exist with "+dressModel.getDressCode());
		}
		
	}

	
	@Override
	@Transactional(readOnly = true,propagation = Propagation.REQUIRED)
	public List<DressModel> dressModels() {
		return dressRepository.findAll();
	}


	@Override
	@Transactional
	public DressResponseForm deleteDressById(Integer dressId) {
		dressRepository.deleteById(dressId);
		DressResponseForm dressResponseForm=new DressResponseForm();
		dressResponseForm.setMessage("Dress is deleted with id:"+dressId);
		return dressResponseForm;
	}

}
