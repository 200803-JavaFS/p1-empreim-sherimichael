package com.revature.web;
import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.controllers.LoginController;
import com.revature.controllers.ReimbursementController;
import com.revature.controllers.UserController;

//import com.revature.controller.ReimbController;
//import com.revature.controller.UserController;


public class MasterServlet extends HttpServlet{
	
	public static final Logger logger = LogManager.getLogger(MasterServlet.class);

	private static final long serialVersionUID = 1L;
	private static UserController uc = new UserController();
	private static ReimbursementController rc = new ReimbursementController();
	private static LoginController lc = new LoginController();
	
	public MasterServlet() {
		super();
	}
	
	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
		
		res.setContentType("application/json");
		
		res.setStatus(404);
	}
		
	@Override
	protected void doPost (HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		final String uri = req.getRequestURI().replace("/project-1/", "");	
			
		switch(uri.toLowerCase()) {
			case "login":
				logger.info("@login in MasterServletswitch");
				lc.login(req, res);
				break;
			case "register":
				logger.info("@register in MasterServletswitch");
				//lc.register(req, res);
				break;
				
			}
		}
}
