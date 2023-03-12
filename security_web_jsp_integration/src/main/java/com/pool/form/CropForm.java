package com.pool.form;

public class CropForm {
	private Integer cropId;
	private String cropName;
	private String cropType;
	public CropForm() {

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
	@Override
	public String toString() {
		return "CropForm [cropId=" + cropId + ", cropName=" + cropName + ", cropType=" + cropType + "]";
	}
	
	
	
}
