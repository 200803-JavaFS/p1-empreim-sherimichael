package com.revature.services;

import java.util.List;

import com.revature.dao.UserDao;
import com.revature.dao.UserDaoIf;
import com.revature.models.User;

public class UserServices {
	
	UserDaoIf uDao = new UserDao();
	
	public List<User> findAll() {
		return uDao.findAll();
	}
	public User findByUserId(int id) {
		return uDao.findByUId(id);
	}
		
	public User findByUsername(String username) {
		return uDao.findByUsername(username);
	}

	public boolean addUser(User u) {
		return uDao.addUser(u);
	}
	
	public boolean updateUser(User u) {
		return uDao.updateUser(u);
	}
}
