package com.pool.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CROPS")
public class Crop {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CROP_ID")
	private Integer cropId;
	@Column(name = "CROP_NAME")
	private String cropName;
	@Column(name = "CROP_TYPE")
	private String cropType; 
	@ManyToOne
	private Former former;
	public Crop() {

	}

	public Integer getCropId() {
		return cropId;
	}

	public void setCropId(Integer cropId) {
		this.cropId = cropId;
	}

	public String getCropName() {
		return cropName;
	}

	public void setCropName(String cropName) {
		this.cropName = cropName;
	}

	public String getCropType() {
		return cropType;
	}

	public void setCropType(String cropType) {
		this.cropType = cropType;
	}

	public Former getFormer() {
		return former;
	}

	public void setFormer(Former former) {
		this.former = former;
	}

	@Override
	public String toString() {
		return "Crop [cropId=" + cropId + ", cropName=" + cropName + ", cropType=" + cropType + "]";
	}

}
