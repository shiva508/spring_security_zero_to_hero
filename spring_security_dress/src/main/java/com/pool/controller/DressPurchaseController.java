package com.pool.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.security.dress.model.DressModel;
import com.security.service.dress.DressService;
import com.security.utils.DressUtil;

@RestController
@RequestMapping("/dress")
public class DressPurchaseController {
	
	@Autowired
	private DressService dressService;
	
	@Autowired
	private DressUtil  dressUtil;
	
	@GetMapping("/item")
	//@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_MANAGER')")
	public ResponseEntity<?> myPurchases() {
		List<DressModel> dressModels=dressService.dressModels();
		
		return new ResponseEntity<>(dressModels,HttpStatus.ACCEPTED);
	}

	@PutMapping("/item/{itemName}")
	//@PreAuthorize("hasAuthority('admin:write')")
	public String purchaseItem(@PathVariable("itemName") String itemName) {
		return itemName;
	}

	@PostMapping("/save")
	//@PreAuthorize("hasAuthority('admin:write')")
	public ResponseEntity<?> savePurchase(@Valid @RequestBody DressModel dressModel,BindingResult result) {
		
		ResponseEntity<?> errorResponse=dressUtil.validationResponseExtractorResult(result);
		if(errorResponse !=null) return errorResponse;
		DressModel savedDressModel=dressService.saveDress(dressModel);
		
		return new ResponseEntity<>(savedDressModel,HttpStatus.CREATED);
		
	}

	@DeleteMapping("/delete/{dressModelId}")
	//@PreAuthorize("hasAuthority('admin:write')")
	public void deleteDress(@PathVariable("dressModelId") Integer dressModelId) {
		System.out.println("Dresss model is deleted :" + dressModelId);
	}
}
