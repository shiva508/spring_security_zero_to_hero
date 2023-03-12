package com.pool.service.dress;

import java.util.List;

import com.security.dress.form.DressResponseForm;
import com.security.dress.model.DressModel;

public interface DressService {
	
	public DressModel saveDress(DressModel dressModel);

	public List<DressModel> dressModels();
	
	public DressResponseForm deleteDressById(Integer dressId);
}
