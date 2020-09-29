package com.revature.controllers;


import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.UserDao;
import com.revature.models.LoginDTO;
import com.revature.services.LoginService;
import com.revature.services.UserServices;

public class LoginController {
	
	private static final Logger log = LogManager.getLogger(UserDao.class);
	
	private static LoginService ls = new LoginService();
	private static UserServices us = new UserServices();
	private static ObjectMapper om = new ObjectMapper();
	
	public void login(HttpServletRequest req, HttpServletResponse res) throws IOException {
		log.info("@Login Controller");
		
		BufferedReader reader = req.getReader();

		StringBuilder sb = new StringBuilder();

		String line = reader.readLine();

		while (line != null) {
			sb.append(line);
			line = reader.readLine();
		}

		String body = new String(sb);

				LoginDTO l = om.readValue(body, LoginDTO.class);
				
				if (ls.login(l)) {
					
					HttpSession ses = req.getSession();
					ses.setAttribute("user", l);
					ses.setAttribute("loggedin", true);
					res.setStatus(200);
					ses.setAttribute("user_role_id", us.findByUsername(l.username).getUserRoleId().getRoleId());
					//System.out.println("in LC ses = " + ses);
					String json = om.writeValueAsString((Integer)ses.getAttribute("user_role_id"));
					res.getWriter().println(json);
				} else {
					HttpSession ses = req.getSession(false);
					if (ses != null) {
					ses.invalidate();
					}
					res.setStatus(401);
					res.getWriter().println("Login failed");
				}			
		}

	public void logout(HttpServletRequest req, HttpServletResponse res) throws IOException {
		log.info("@Logout Controller");
		
		HttpSession ses = req.getSession(false);

		if (ses != null) {
			LoginDTO l = (LoginDTO) ses.getAttribute("user");
			ses.invalidate();
			res.setStatus(200);
			res.getWriter().println(l.username + " has logged out successfully");
		} else {
			res.setStatus(400);
			res.getWriter().println("You must be logged in to logout!");
		}
	}
}
