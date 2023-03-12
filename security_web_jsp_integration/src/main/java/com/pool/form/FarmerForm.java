package com.pool.form;

import java.util.ArrayList;
import java.util.List;

public class FarmerForm {
	private Integer formerId;
	private String formerName;
	private String phoneNumber;
	private String village;
	private String mandal;
	private String district;
	private String phinCode;
	private List<CropForm> cropList=new ArrayList<CropForm>();
	public FarmerForm() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getFormerId() {
		return formerId;
	}
	public void setFormerId(Integer formerId) {
		this.formerId = formerId;
	}
	public String getFormerName() {
		return formerName;
	}
	public void setFormerName(String formerName) {
		this.formerName = formerName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getVillage() {
		return village;
	}
	public void setVillage(String village) {
		this.village = village;
	}
	public String getMandal() {
		return mandal;
	}
	public void setMandal(String mandal) {
		this.mandal = mandal;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getPhinCode() {
		return phinCode;
	}
	public void setPhinCode(String phinCode) {
		this.phinCode = phinCode;
	}
	public List<CropForm> getCropList() {
		return cropList;
	}
	public void setCropList(List<CropForm> cropList) {
		this.cropList = cropList;
	}
	@Override
	public String toString() {
		return "FarmerForm [formerId=" + formerId + ", formerName=" + formerName + ", phoneNumber=" + phoneNumber
				+ ", village=" + village + ", mandal=" + mandal + ", district=" + district + ", phinCode=" + phinCode
				+ ", cropList=" + cropList + "]";
	}

}
