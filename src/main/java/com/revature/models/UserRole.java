package com.revature.models;


import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_roles")
public class UserRole implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_role_id", nullable=false)
	private int uRoleId;
	
	@Column(name="user_role", nullable=false)
	private String uRole;
	
	//@OneToMany(mappedBy="userRoleId")
	//private List<User> uList;
	
	public UserRole() {
		super();
	}

	public UserRole(int roleId, String uRole) {
		super();
		this.uRoleId = roleId;
		this.uRole = uRole;
	}

	public UserRole(String uRole) {
		super();
		this.uRole = uRole;
	}

	public int getRoleId() {
		return uRoleId;
	}

	public void setRoleId(int roleId) {
		this.uRoleId = roleId;
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
		result = prime * result + uRoleId;
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
		if (uRoleId != other.uRoleId)
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
		return "UserRole [roleId=" + uRoleId + ", uRole=" + uRole + "]";
	}
}
