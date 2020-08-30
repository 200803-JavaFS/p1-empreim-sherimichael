package com.revature.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.User;
import com.revature.services.UserServices;

public class UserController {
	
	private static UserServices us= new UserServices();
	private static ObjectMapper om = new ObjectMapper();
	
	public void getUsers(HttpServletResponse res, int userId) throws IOException {
		
		User u = us.findByUserId(userId);
		if (u == null) {
			res.setStatus(204);
		}else {
			res.setStatus(204);
			String json = om.writeValueAsString(u);
			res.getWriter().println(json);			
		}
	}
	
	public void getAllUsers(HttpServletResponse res) throws IOException {
		
		List<User> all = us.findAll();
		res.getWriter().println(om.writeValueAsString(all));
		res.setStatus(200);	
	}
	
	public void addUsers(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
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
			res.getWriter().println("User was created");
		} else {
			res.setStatus(403);
		}
		
	}
}
