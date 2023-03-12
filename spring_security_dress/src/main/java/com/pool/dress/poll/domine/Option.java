package com.pool.dress.poll.domine;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_OPTION")
public class Option {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "OPTION_ID")
	private Long optionId;
	
	@Column(name = "OPTION_VALUE")
	private String optionValue;
	
	public Option() {
		
	}
	public Long getOptionId() {
		return optionId;
	}
	public void setOptionId(Long optionId) {
		this.optionId = optionId;
	}
	public String getOptionValue() {
		return optionValue;
	}
	public void setOptionValue(String optionValue) {
		this.optionValue = optionValue;
	}
	@Override
	public String toString() {
		return "Option [optionId=" + optionId + ", optionValue=" + optionValue + "]";
	}
	
	
}
