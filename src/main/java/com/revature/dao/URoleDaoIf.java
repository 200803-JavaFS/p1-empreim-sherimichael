package com.revature.dao;

import java.util.List;

import com.revature.models.User;
import com.revature.models.UserRole;

public interface URoleDaoIf {
	
	public List<UserRole> findAll();
	public UserRole findById(int id);
	public boolean addURole(UserRole ur);	
	public boolean updateURole(UserRole ur);

}
