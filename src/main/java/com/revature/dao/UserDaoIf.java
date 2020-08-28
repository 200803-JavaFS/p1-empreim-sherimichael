package com.revature.dao;

import java.util.List;

import com.revature.models.User;

public interface UserDaoIf {
		
	public List<User> findAll();
	public User findByUserId(int id);
	public void addUser(User u);	
	public void updateUser(User u);

}
