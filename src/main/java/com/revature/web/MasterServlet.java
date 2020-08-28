package com.revature.web;
import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import com.revature.controller.ReimbController;
//import com.revature.controller.UserController;


public class MasterServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	//private static UserController uc = new UserController();
	//private static ReimbController rc = new ReimbController();

	
	public MasterServlet() {
		super();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
	
		res.setContentType("application/json");
		res.setStatus(404);
		
		final String URI= req.getRequestURI().replace("/project1/", "");
		String[] portions = URI.split("/");
		

		System.out.println(Arrays.toString(portions));
		System.out.println("portions[0]:"+ portions[0]);
		try {
			System.out.println("@try in doGet() in MasterServlet");
			switch(portions[0]) {
				case "login":
					if (req.getMethod().equals("POST")) {
						//uc.login(req, res);
					}
//				case "employeeSuccess":
//					if (req.getMethod().equals("POST")) {
//						uc.display(req, res);
//					}
			}
					
		}catch (NumberFormatException e ) {
			e.printStackTrace();
			res.getWriter().print("Please enter an id that is an integer.");
			res.setStatus(400);
		}
	
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
	
	}

}
