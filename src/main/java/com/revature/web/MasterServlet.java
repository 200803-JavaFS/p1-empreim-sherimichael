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
import com.revature.controllers.UserRoleController;
import com.revature.dao.UserDao;
import com.revature.models.LoginDTO;
import com.revature.models.User;
import com.revature.services.UserServices;

public class MasterServlet extends HttpServlet{
	
	public static final Logger log = LogManager.getLogger(MasterServlet.class);

	private static final long serialVersionUID = 1L;
	private static ReimbursementController rc = new ReimbursementController();
	private static LoginController lc = new LoginController();
	private static UserRoleController urc = new UserRoleController();
	private static UserDao uDao = new UserDao();
	
	private static UserServices us = new UserServices();
	
	public MasterServlet() {
		super();
	}
	
	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
		log.info("@doGet in MasterServlet");
		res.setContentType("application/json");
		
		res.setStatus(404);

		final String URI = req.getRequestURI().replace("/project1/", "");

		String[] portions = URI.split("/");

		System.out.println(Arrays.toString(portions));

		try {
			switch (portions[0]) {
			
			case "login":
				log.info("@login at MasterServletSwitch");
				lc.login(req, res);
				
				
				break;
				
			case "newrequest":
				log.info("@request at MasterServletSwitch");
				rc.addR(req, res);
				break;
				
			case "requests":
				log.info("@request at MasterServletSwitch");
				//rc.getRById(res, id);
				break;
			
			case "allreqs":
				log.info("@request at MasterServletSwitch");
				//rc.getRById(res, id);
				break;
				
			case "appden":
				log.info("@request at MasterServletSwitch");
				//rc.getRById(res, id);
				break;
				
			case "logout":
				log.info("@logout at MasterServletSwitch");
				lc.logout(req, res);
				break;
			}

		} catch (NumberFormatException e) {
			e.printStackTrace();
			res.getWriter().print("You are requesting a page that does not exist.");
			res.setStatus(400);
		}

	}
		

	@Override
	protected void doPost (HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
	}
}
