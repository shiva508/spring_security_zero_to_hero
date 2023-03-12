package com.pool.form;

public class AddressForm {
	private Integer addressId;
	private String villageName;
	private String mandal;
	private String distrct;
	public AddressForm() {
	}
	public Integer getAddressId() {
		return addressId;
	}
	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}
	public String getVillageName() {
		return villageName;
	}
	public void setVillageName(String villageName) {
		this.villageName = villageName;
	}
	public String getMandal() {
		return mandal;
	}
	public void setMandal(String mandal) {
		this.mandal = mandal;
	}
	public String getDistrct() {
		return distrct;
	}
	public void setDistrct(String distrct) {
		this.distrct = distrct;
	}
	@Override
	public String toString() {
		return "AddressForm [addressId=" + addressId + ", villageName=" + villageName + ", mandal=" + mandal
				+ ", distrct=" + distrct + "]";
	}
	
	
}
