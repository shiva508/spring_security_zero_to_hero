package com.security.model;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;




@Entity
@Table(name="authorities")
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer authoriteId;
	private String authority;
	@ManyToOne
	@JoinColumn(name="userId")
	@JsonIgnore
	private Registration registration;
	
	public Role() {
	
	}
	public Integer getAuthoriteId() {
		return authoriteId;
	}
	public void setAuthoriteId(Integer authoriteId) {
		this.authoriteId = authoriteId;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	public Registration getRegistration() {
		return registration;
	}
	public void setRegistration(Registration registration) {
		this.registration = registration;
	}
	
}
