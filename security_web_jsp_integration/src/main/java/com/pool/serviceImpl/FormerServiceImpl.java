package com.pool.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.SystemPropertyUtils;

import com.pool.dao.FormerRepository;
import com.pool.form.CropForm;
import com.pool.form.FarmerForm;
import com.pool.model.Crop;
import com.pool.model.Former;
import com.pool.service.FormerService;

import ma.glasnost.orika.MapperFacade;

@Service
@Transactional
public class FormerServiceImpl implements FormerService {
	@Autowired
	FormerRepository  formerRepository;
	@Autowired
	private MapperFacade formDomainMapperFacade;
	@Override
	public Former saveFarmerProfile(FarmerForm farmerForm) {
		System.out.println(farmerForm);
		Former former=formDomainMapperFacade.map(farmerForm, Former.class);
		populateFormToModelConverter(farmerForm, former);
		System.out.println(former);
		return formerRepository.save(former);
	}
	private void populateFormToModelConverter(FarmerForm farmerForm, Former former) {
		if(farmerForm.getCropList() !=null) {
			for (CropForm cropForm : farmerForm.getCropList()) {
				Crop crop=formDomainMapperFacade.map(cropForm, Crop.class);
				former.addCrops(crop);
			}
		}
		
	}

	
}
