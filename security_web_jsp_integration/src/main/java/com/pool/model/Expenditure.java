package com.pool.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Table
@Entity
public class Expenditure implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer expenditureId;
	private String amount;
	private String details;
	@Temporal(TemporalType.DATE)
	private Date entryDate;
	private Integer typeOfExpence;
	private Integer userId;

	public Expenditure() {

	}

	public Integer getExpenditureId() {
		return expenditureId;
	}

	public void setExpenditureId(Integer expenditureId) {
		this.expenditureId = expenditureId;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public Date getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}

	public Integer getTypeOfExpence() {
		return typeOfExpence;
	}

	public void setTypeOfExpence(Integer typeOfExpence) {
		this.typeOfExpence = typeOfExpence;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Expenditure [expenditureId=" + expenditureId + ", amount=" + amount + ", details=" + details
				+ ", entryDate=" + entryDate + ", typeOfExpence=" + typeOfExpence + ", userId=" + userId + "]";
	}

}
