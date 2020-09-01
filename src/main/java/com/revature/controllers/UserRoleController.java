package com.revature.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.UserDao;
import com.revature.services.UserServices;

public class UserRoleController {
	
private static final Logger log = LogManager.getLogger(UserDao.class);
	
	private static UserServices us= new UserServices();
	private static ObjectMapper om = new ObjectMapper();

}
