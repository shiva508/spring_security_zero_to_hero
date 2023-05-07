package com.pool.forms;

public class RoleForm {

	private Integer authoriteId;
	private String authority;
	private String userName;

	public RoleForm(String authority) {
		super();
		this.authority = authority;
	}

	public RoleForm() {

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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "RoleForm [authoriteId=" + authoriteId + ", authority=" + authority + ", userName=" + userName + "]";
	}
}
