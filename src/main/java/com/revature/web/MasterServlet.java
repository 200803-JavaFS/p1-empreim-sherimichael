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

	
	public MasterServlet() {
		super();
	}
	
	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
		log.info("@doGet in MasterServlet");
		
		/*
		 * functionalities: view reimbursement requests all and by employee for (open(pending) and closed(resolved))
		 */
		res.setContentType("application/json");
		
		res.setStatus(404);//setting explicitly bc web container(tomcat) sets default status when sends req to servlet

		final String URI = req.getRequestURI().replace("/project1/", "");

		String[] portions = URI.split("/");

		System.out.println(Arrays.toString(portions));
		
		if ((portions[0]).equals("reimbursement")) {
			if (req.getSession(false) != null && (boolean) req.getSession().getAttribute("Loggedin")) {
				if (portions.length == 2) {
					int reimbId = Integer.parseInt(portions[1]);
					rc.getRById(res, reimbId);
				} else if (portions.length == 1) {
					rc.getAll(res);
				}
			} else {
				res.setStatus(403);
				res.getWriter().println("You must be logged in to do that!");
			}
		} else {
		res.setStatus(400);
		}	 
	}
		

	@Override
	protected void doPost (HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		log.info("@doPost in MasterServlet");
		/*
		 * functionalities: login, logout, & employees can submit new reimbursement requests
		 */
		
		res.setContentType("application/json");
		res.setStatus(400);
		final String URI = req.getRequestURI().replace("/project1/", "");
		String[] portions = URI.split("/");
		
		
			try {
				switch (portions[0]) {
			
				case "login":
					log.info("@login in doPost at MasterServletSwitch");
					lc.login(req, res);	
					break;
				
				case "addR":
					log.info("@addR in doPost at MasterServletSwitch");
					rc.addR(req, res);
					break;
					
				case "changeStatus":
					log.info("@changeStatus in doPost at MasterServletSwitch");
					rc.updateR(req, res);
					break;
				
				case "logout":
					log.info("@logout in doPost at MasterServletSwitch");
					//lc.logout(req, res);
					break;
			}

		} catch (NumberFormatException e) {
			e.printStackTrace();
			res.getWriter().print("You are requesting a page that does not exist.");
			res.setStatus(400);
		}
	}
	
	@Override
	protected void doPut (HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		/*
		 * functionalities: finance managers can approve/deny pending requests by changing the status
		 * status codes: 1==pending, 2==approved, 3==denied
		 */
		
		res.setContentType("application/json");
		
		res.setStatus(400);

		final String URI = req.getRequestURI().replace("/project1/", "");

		String[] portions = URI.split("/");

		System.out.println(Arrays.toString(portions));
		
		if (URI.equals("request")) {
			log.info("@request in duPut at MasterServletSwitch");
			//rc.method			
		}
		
		

	}
}
