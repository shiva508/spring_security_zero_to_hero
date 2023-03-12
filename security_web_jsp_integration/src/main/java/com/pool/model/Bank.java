package com.pool.model;

public class Bank {
private Integer bankId;
private String bankName;
private Integer loanId;
private Integer bankType;
public Bank() {

}
public Integer getBankId() {
	return bankId;
}
public void setBankId(Integer bankId) {
	this.bankId = bankId;
}
public String getBankName() {
	return bankName;
}
public void setBankName(String bankName) {
	this.bankName = bankName;
}
public Integer getLoanId() {
	return loanId;
}
public void setLoanId(Integer loanId) {
	this.loanId = loanId;
}
public Integer getBankType() {
	return bankType;
}
public void setBankType(Integer bankType) {
	this.bankType = bankType;
}
@Override
public String toString() {
	return "Bank [bankId=" + bankId + ", bankName=" + bankName + ", loanId=" + loanId + ", bankType=" + bankType + "]";
}

}
