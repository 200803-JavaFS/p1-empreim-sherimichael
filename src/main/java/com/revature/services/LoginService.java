package com.revature.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.dao.UserDao; 
import com.revature.models.LoginDTO; 
import com.revature.models.User;

public class LoginService {
	
	private static final Logger log = LogManager.getLogger(UserDao.class);
	
    UserDao uDao = new UserDao();     
    
    public boolean login(LoginDTO l) { 
    	log.info("@login in LoginService");
    	User u = uDao.findByUsername(l.username);
		StringBuilder tempPassword = new StringBuilder();
		tempPassword.append(l.password.hashCode());
		String hashPassword = tempPassword.toString();
		
		if((u!=null) && hashPassword.equals(u.getPassword())) {
			return true;
		
		}else {
		return false; 
		}
	}
}
