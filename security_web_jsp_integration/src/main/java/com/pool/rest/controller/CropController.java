package com.pool.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pool.model.Crop;
import com.pool.service.CropService;

@RestController
public class CropController {
	@Autowired
	CropService cropService;
	@PostMapping("savecrop")
	public Crop saveCrop(@RequestBody Crop crop) {
		return cropService.saveCrop(crop);
	}
}
