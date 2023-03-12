package com.pool.model;

import java.util.Date;

public class Load {
private Integer loadId;
private double amount;
private Date fromDuriation;
private Date toDuriation;
private String dutiationInDays;
public Load() {

}
public Integer getLoadId() {
	return loadId;
}
public void setLoadId(Integer loadId) {
	this.loadId = loadId;
}
public double getAmount() {
	return amount;
}
public void setAmount(double amount) {
	this.amount = amount;
}
public Date getFromDuriation() {
	return fromDuriation;
}
public void setFromDuriation(Date fromDuriation) {
	this.fromDuriation = fromDuriation;
}
public Date getToDuriation() {
	return toDuriation;
}
public void setToDuriation(Date toDuriation) {
	this.toDuriation = toDuriation;
}
public String getDutiationInDays() {
	return dutiationInDays;
}
public void setDutiationInDays(String dutiationInDays) {
	this.dutiationInDays = dutiationInDays;
}
@Override
public String toString() {
	return "Load [loadId=" + loadId + ", amount=" + amount + ", fromDuriation=" + fromDuriation + ", toDuriation="
			+ toDuriation + ", dutiationInDays=" + dutiationInDays + "]";
}

}
