package com.pool.controller.dress;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.support.HttpAccessor;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.security.dress.model.DressModel;
import com.security.forms.ValidationResponse;
import com.security.service.dress.DressService;
import com.security.utils.DressUtil;

@RestController
@RequestMapping("/dress")
public class DressController {

	@Autowired
	private DressService dressService;

	@Autowired
	private DressUtil dressUtil;

	@PostMapping("/create")
	public ResponseEntity<?> saveDress(@Valid @RequestBody DressModel dressModel, BindingResult result) {
		ResponseEntity<?> errorResponse = dressUtil.validationResponseExtractorResult(result);
		if (errorResponse != null)
			return errorResponse;
		DressModel savedDress = dressService.saveDress(dressModel);
		return new ResponseEntity<DressModel>(savedDress, HttpStatus.CREATED);
	}

	@GetMapping("/models")
	public ResponseEntity<List<DressModel>> dressCollection() {
		List<DressModel> dressCollection = dressService.dressModels();
		return new ResponseEntity<List<DressModel>>(dressCollection, HttpStatus.OK);
	}
}
