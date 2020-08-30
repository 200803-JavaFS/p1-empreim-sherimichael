package com.revature.dao;

import java.util.List;

import com.revature.models.User;

public interface UserDaoIf {
		
	public List<User> findAll();
	public User findByUserId(int id);
	public User findByUsername(String username);
	public boolean addUser(User u);	
	public boolean updateUser(User u);

}
