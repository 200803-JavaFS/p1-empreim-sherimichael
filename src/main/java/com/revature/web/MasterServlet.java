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
		// By default tomcat will send back a successful status code if it finds servlet method.
		// Because all requests will hit this method, we are defaulting to not found and
		// will override for success requests.
		res.setStatus(404);

		final String URI = req.getRequestURI().replace("/project1/", "");

		String[] portions = URI.split("/");

		System.out.println(Arrays.toString(portions));

		try {
			switch (portions[0]) {
			case "Users":
				if (req.getSession(false) != null && (boolean) req.getSession().getAttribute("Loggedin")) {
					if (req.getMethod().equals("GET")) {
						if (portions.length == 2) {
							int userId = Integer.parseInt(portions[1]);
							uc.getUById(res, userId);
						} else if (portions.length == 1) {
							uc.getAllU(res);
						}
					} else if (req.getMethod().equals("POST")) {
						uc.addU(req, res);
					}
				} else {
					res.setStatus(403);
					res.getWriter().println("You must be logged in to do that!");
				}
				break;
				
			case "UserRoles":
				if (req.getSession(false) != null && (boolean) req.getSession().getAttribute("Loggedin")) {
					if (req.getMethod().equals("GET")) {
						if (portions.length == 2) {
							int userRolesId = Integer.parseInt(portions[1]);
							//uc.getURole(res, userRolesId);
						} 
					} else if (req.getMethod().equals("POST")) {
						//uc.addURoles(req, res);
					}
				} else {
					res.setStatus(403);
					res.getWriter().println("You must be logged in to do that!");
				}
				break;
				
			case "Reimbursement":
				if (req.getSession(false) != null && (boolean) req.getSession().getAttribute("Loggedin")) {
					if (req.getMethod().equals("GET")) {
						if (portions.length == 2) {
							int reimbId = Integer.parseInt(portions[1]);
							rc.getRById(res, reimbId);
						} else if (portions.length == 1) {
							rc.getAll(res);
						}
					} else if (req.getMethod().equals("POST")) {
						rc.addR(req, res);
					}
				
				} else {
					res.setStatus(403);
					res.getWriter().println("You must be logged in to do that!");
				}
				break;
				
			case "Login":
				lc.login(req, res);
				break;
				
			case "Logout":
				lc.logout(req, res);
				break;
			}

		} catch (NumberFormatException e) {
			e.printStackTrace();
			res.getWriter().print("The user id you provided is not an integer");
			res.setStatus(400);
		}

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
