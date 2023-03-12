package com.pool.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pool.form.FarmerForm;
import com.pool.model.Former;
import com.pool.service.FormerService;

@RestController
public class FarmerController {
	@Autowired
	FormerService formerService;
	@PostMapping("saveProfile")
	public Former saveFarmerProfile(@RequestBody FarmerForm farmerForm) {
		return formerService.saveFarmerProfile(farmerForm);
	}
}
