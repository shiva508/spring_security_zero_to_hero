package com.pool.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;


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
