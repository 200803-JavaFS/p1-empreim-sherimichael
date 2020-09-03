package com.revature.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.UserDao;
import com.revature.models.User;

public class UserRoleController {
	
private static final Logger log = LogManager.getLogger(UserDao.class);
	
	private static ObjectMapper om = new ObjectMapper();
	
	//This is to send the user role with your response so can go to role specific webpage
	public void getURole(HttpServletRequest req, HttpServletResponse res, User u) throws IOException {
		log.info("@getURole in UserRoleController");
		
		if (u == null) {
			res.setStatus(204);
		} else {
			res.setStatus(200);
			String json = om.writeValueAsString(u);
			res.getWriter().println(json);
		}
		
	}

}
