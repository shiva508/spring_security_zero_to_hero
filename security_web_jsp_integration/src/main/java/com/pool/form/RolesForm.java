package com.pool.form;

public class RolesForm {
private Integer roleId;
private String roleName;
public RolesForm() {
	super();
}
public Integer getRoleId() {
	return roleId;
}
public void setRoleId(Integer roleId) {
	this.roleId = roleId;
}
public String getRoleName() {
	return roleName;
}
public void setRoleName(String roleName) {
	this.roleName = roleName;
}
@Override
public String toString() {
	return "RolesForm [roleId=" + roleId + ", roleName=" + roleName + "]";
}

}
