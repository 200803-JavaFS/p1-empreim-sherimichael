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
import com.revature.models.Reimbursement;
import com.revature.models.inputRDTO;
import com.revature.services.ReimbursementServices;

public class ReimbursementController {
	
	private static final Logger log = LogManager.getLogger(UserDao.class);
	
	private static ReimbursementServices rs = new ReimbursementServices();
	private static ObjectMapper om = new ObjectMapper();
	
	public void getAll(HttpServletResponse res) throws IOException{
		log.info("@getAll in ReimbursementController");
		
		List<Reimbursement> allR = rs.findAll();
		
		res.getWriter().println(om.writeValueAsString(allR));
		res.setStatus(200);
	}

	public void getRById(HttpServletResponse res, int id) throws IOException{
		log.info("@getRById in ReimbursementController");
	
		Reimbursement r = rs.findByRId(id);
	
		if(r == null) {
			res.setStatus(204);
			return;
		}
	
		res.setStatus(200);
		String json = om.writeValueAsString(r);
		res.getWriter().println(json);
	}
	
	public void getRByStatus(HttpServletResponse res, int statusId) throws IOException {
		log.info("@getRByStatus in ReimbursementController");
		
		List<Reimbursement> allRStatus = rs.findByRStatus(statusId);
		
		res.getWriter().println(om.writeValueAsString(allRStatus));
		res.setStatus(200);
	}
	
	public void getRByAuthorStatus(HttpServletResponse res, int author, int statusId) throws IOException{
		log.info("@getRByAuthorStatus in ReimbursementController");
		
		List<Reimbursement> userStatus = rs.findByUserStatus(author, statusId);
		
		res.getWriter().println(om.writeValueAsString(userStatus));
		res.setStatus(200);
	}
	
	public void addR(HttpServletRequest req, HttpServletResponse res) throws IOException{
		log.info("@addR in ReimbursementController");
		
		BufferedReader reader = req.getReader();
		
		StringBuilder sb = new StringBuilder();
		
		String line = reader.readLine();
		
		while(line != null) {
			sb.append(line);
			line = reader.readLine();
		}
		
		String body = new String(sb);
		
		inputRDTO rDTO = om.readValue(body, inputRDTO.class);
		if(rs.addReimbursement(rDTO)) {
			res.setStatus(201);
			res.getWriter().println("Reimbursement Request Added");
		}
		else {
			res.setStatus(403);
		}
	}
	
public void updateR(HttpServletRequest req, HttpServletResponse res) throws IOException{
		log.info("@updateR in ReimbursementController");
		
		BufferedReader reader = req.getReader();
		
		StringBuilder sb = new StringBuilder();
		
		String line = reader.readLine();
		
		while(line != null) {
			sb.append(line);
			line = reader.readLine();
		}
		
		String body = new String(sb);
		
		inputRDTO r = om.readValue(body, inputRDTO.class);
		
		if(rs.addReimbursement(r)) {
			res.setStatus(201);
			res.getWriter().println("Reimbursement Request Updated");
		}
		else {
			res.setStatus(403);
		}
	}
}
