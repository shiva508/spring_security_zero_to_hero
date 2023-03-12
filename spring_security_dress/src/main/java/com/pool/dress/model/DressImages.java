package com.pool.dress.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "DRESS_IMAGES")
public class DressImages {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "DRESS_IMAGE_ID")
	private Long dressImageId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private DressModel dressModel;
	
	@Column(name = "DRESS_CODE")
	private String dressCode;
	
	@Column(name = "DRESS_IMAGE_BASE64")
	private String dressImageBase64;

	public DressImages() {
		
	}

	public Long getDressImageId() {
		return dressImageId;
	}

	public void setDressImageId(Long dressImageId) {
		this.dressImageId = dressImageId;
	}

	public DressModel getDressModel() {
		return dressModel;
	}

	public void setDressModel(DressModel dressModel) {
		this.dressModel = dressModel;
	}

	public String getDressCode() {
		return dressCode;
	}

	public void setDressCode(String dressCode) {
		this.dressCode = dressCode;
	}

	public String getDressImageBase64() {
		return dressImageBase64;
	}

	public void setDressImageBase64(String dressImageBase64) {
		this.dressImageBase64 = dressImageBase64;
	}
	
}
