package com.revature.services;

import com.revature.dao.UserDao; 
import com.revature.models.LoginDTO; 
import com.revature.models.User;

public class LoginService {
	
    UserDao uDao = new UserDao();     
    
    public boolean login(LoginDTO l) {        
    	
    	User u = uDao.findByUsername(l.username);         
    	
    	if((u!=null) && l.password.equals(u.getPassword())) {            
    		return true;         
    	} else {         
    	return false;      
    	}
    }
}
