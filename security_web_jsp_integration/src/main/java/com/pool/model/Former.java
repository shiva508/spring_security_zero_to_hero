package com.pool.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="FORMER")
public class Former {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="FARMER_ID")
	private Integer formerId;
	private String formerName;
	private String phoneNumber;
	private String village;
	private String mandal;
	private String district;
	private String phinCode;
	@OneToMany(mappedBy="former",cascade=CascadeType.ALL,orphanRemoval=true,fetch=FetchType.LAZY)
	private List<Crop> crops;
	public Former() {
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

	public List<Crop> getCrops() {
		if(crops ==null) {
			crops=new ArrayList<Crop>();
		}
		return crops;
	}

	public void setCrops(List<Crop> crops) {
		this.crops = crops;
	}

	

	public void addCrops( Crop crop) {
		if (crop !=null) {
			crop.setFormer(this);
			getCrops().add(crop);	
		}
		
	}

	@Override
	public String toString() {
		return "Former [formerId=" + formerId + ", formerName=" + formerName + ", phoneNumber=" + phoneNumber
				+ ", village=" + village + ", mandal=" + mandal + ", district=" + district + ", phinCode=" + phinCode
				+ ", crops=" + crops + "]";
	}

		
}
