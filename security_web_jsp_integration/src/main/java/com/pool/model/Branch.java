package com.pool.model;

public class Branch {
private Integer branchId;
private Integer bankId;
private String area;
private String landMark;
private String manager;
private String landLine;
private String phoneNumber;
public Branch() {
}
public Integer getBranchId() {
	return branchId;
}
public void setBranchId(Integer branchId) {
	this.branchId = branchId;
}
public Integer getBankId() {
	return bankId;
}
public void setBankId(Integer bankId) {
	this.bankId = bankId;
}
public String getArea() {
	return area;
}
public void setArea(String area) {
	this.area = area;
}
public String getLandMark() {
	return landMark;
}
public void setLandMark(String landMark) {
	this.landMark = landMark;
}
public String getManager() {
	return manager;
}
public void setManager(String manager) {
	this.manager = manager;
}
public String getLandLine() {
	return landLine;
}
public void setLandLine(String landLine) {
	this.landLine = landLine;
}
public String getPhoneNumber() {
	return phoneNumber;
}
public void setPhoneNumber(String phoneNumber) {
	this.phoneNumber = phoneNumber;
}
@Override
public String toString() {
	return "Branch [branchId=" + branchId + ", bankId=" + bankId + ", area=" + area + ", landMark=" + landMark
			+ ", manager=" + manager + ", landLine=" + landLine + ", phoneNumber=" + phoneNumber + "]";
}


}
