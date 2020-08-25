package com.revature.dao;

import java.util.List;

import com.revature.models.User;

public interface UserDaoIf {
		
	public List<User> findAll();
	public User findById(int id);
	public User findByUserPassword(String username, String password);
	public User findByUsername(String username);
	public boolean addUser(User u);	
	public boolean updateUser(User u);

}
