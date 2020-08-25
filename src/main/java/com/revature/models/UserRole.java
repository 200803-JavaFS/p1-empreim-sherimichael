package com.revature.models;

public class UserRole {
	
	private int roleId;
	private String uRole;
	
	public UserRole() {
		super();
	}

	public UserRole(int roleId, String uRole) {
		super();
		this.roleId = roleId;
		this.uRole = uRole;
	}

	public UserRole(String uRole) {
		super();
		this.uRole = uRole;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getuRole() {
		return uRole;
	}

	public void setuRole(String uRole) {
		this.uRole = uRole;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + roleId;
		result = prime * result + ((uRole == null) ? 0 : uRole.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserRole other = (UserRole) obj;
		if (roleId != other.roleId)
			return false;
		if (uRole == null) {
			if (other.uRole != null)
				return false;
		} else if (!uRole.equals(other.uRole))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UserRole [roleId=" + roleId + ", uRole=" + uRole + "]";
	}
}
