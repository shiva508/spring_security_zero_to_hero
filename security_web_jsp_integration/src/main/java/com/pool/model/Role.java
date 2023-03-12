package com.pool.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="role")
public class Role {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="role_id")
private Integer roleID;
@Column(name="role")
private String role;

public Role() {
	super();
}
public Role(Integer roleID, String role) {
	super();
	this.roleID = roleID;
	this.role = role;
}
public Integer getRoleID() {
	return roleID;
}
public void setRoleID(Integer roleID) {
	this.roleID = roleID;
}
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}
@Override
public String toString() {
	return "Role [roleID=" + roleID + ", role=" + role + "]";
}

}
