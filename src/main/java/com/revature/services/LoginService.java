package com.revature.services;

import com.revature.dao.UserDao; 
import com.revature.models.LoginDTO; 
import com.revature.models.User;

public class LoginService {
	
    UserDao uDao = new UserDao();     
    
    public boolean login(LoginDTO l) {        
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
