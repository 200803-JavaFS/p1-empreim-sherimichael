package com.revature.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.UserDao;
import com.revature.models.User;
import com.revature.models.inputRDTO;
import com.revature.services.UserServices;

public class UserController {
	
	private static final Logger log = LogManager.getLogger(UserDao.class);
	
	private static UserServices us= new UserServices();
	private static ObjectMapper om = new ObjectMapper();
	
	public void getAllU(HttpServletResponse res) throws IOException {
		log.info("@getAllU in UserController");
		
		List<User> all = us.findAll();
		res.getWriter().println(om.writeValueAsString(all));
		res.setStatus(200);	
	}
	
	public void getUById(HttpServletResponse res, int userId) throws IOException {
		log.info("@getUById in UserController");
		
		User u = us.findByUserId(userId);
		if (u == null) {
			res.setStatus(204);
		}else {
			res.setStatus(204);
			String json = om.writeValueAsString(u);
			res.getWriter().println(json);			
		}
	}
	
	public void getUByUsername(HttpServletResponse res, String username) throws IOException {
		log.info("@getUByUsername in UserController");
		
		User u = us.findByUsername(username);
		if (u == null) {
			res.setStatus(204);
		}else {
			res.setStatus(204);
			String json = om.writeValueAsString(u);
			res.getWriter().println(json);			
		}
	}
	
	public void getUByEmail(HttpServletResponse res, String email) throws IOException {
		log.info("@getUByEmail in UserController");
		
		User u = us.findByUsername(email);
		if (u == null) {
			res.setStatus(204);
		}else {
			res.setStatus(204);
			String json = om.writeValueAsString(u);
			res.getWriter().println(json);			
		}
	}
	
	public void getByEmail(String body) throws IOException {
		log.info("@getByEmail in UserController");
		inputRDTO rDTO = om.readValue(body, inputRDTO.class);
		System.out.println("@getByEmail in UC rDTO = " + rDTO);
		
		/*
		User u = us.findByUsername(email);
		if (u == null) {
			res.setStatus(204);
		}else {
			res.setStatus(204);
			String json = om.writeValueAsString(u);
			res.getWriter().println(json);			
		}
		*/
	}
	
	
		
	public void addU(HttpServletRequest req, HttpServletResponse res) throws IOException {
		log.info("@gaddU in UserController");
		
		BufferedReader reader = req.getReader();
		
		StringBuilder sb = new StringBuilder();
		
		String line = reader.readLine();
		
		while (line != null) {
			sb.append(line);
			line = reader.readLine();
		}
		
		String body = new String(sb);
		
		System.out.println(body);
		
		User u = om.readValue(body, User.class);
		
		System.out.println(u);
		
		if (us.addUser(u)) {
			res.setStatus(201);
			res.getWriter().println("User was added");
		} else {
			res.setStatus(403);
		}		
	}
	
public void updateU(HttpServletRequest req, HttpServletResponse res) throws IOException {
		log.info("@updateU in UserController");
	
		BufferedReader reader = req.getReader();
		
		StringBuilder sb = new StringBuilder();
		
		String line = reader.readLine();
		
		while (line != null) {
			sb.append(line);
			line = reader.readLine();
		}
		
		String body = new String(sb);
		
		System.out.println(body);
		
		User u = om.readValue(body, User.class);
		
		System.out.println(u);
		
		if (us.updateUser(u)) {
			res.setStatus(201);
			res.getWriter().println("User was updated");
		} else {
			res.setStatus(403);
		}		
	}
}
