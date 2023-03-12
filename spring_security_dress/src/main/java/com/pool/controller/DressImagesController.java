package com.pool.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.security.dress.model.DressImages;
import com.security.service.dress.DressImagesService;

@RestController
@RequestMapping("/dressimage")
public class DressImagesController {
	
	@Autowired
	private DressImagesService dressImagesService;

	@GetMapping("/all")
	public ResponseEntity<?> getAllImages(){
		List<DressImages> dressImages=dressImagesService.getAllImages();
		return new ResponseEntity<>(dressImages,HttpStatus.OK);
		
	}
	
	@GetMapping("/bydresscode/{dressCode}")
	public ResponseEntity<?> getDressImagesByDressCode(@PathVariable("dressCode")String dressCode){
		List<DressImages> dressImages=dressImagesService.getDressImagesByDressCode(dressCode);
		return new ResponseEntity<>(dressImages,HttpStatus.OK);
	}
}
