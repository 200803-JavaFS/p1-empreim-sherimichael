package com.revature.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.UserDao;
import com.revature.models.LoginDTO;
import com.revature.models.Reimbursement;
import com.revature.models.User;
import com.revature.models.inputRDTO;
import com.revature.services.ReimbursementServices;
import com.revature.services.UserServices;

public class ReimbursementController {
	
	private static final Logger log = LogManager.getLogger(UserDao.class);
	
	private static UserServices us = new UserServices();
	private static ReimbursementServices rs = new ReimbursementServices();
	private static ObjectMapper om = new ObjectMapper();
	
	public void getAll(HttpServletResponse res) throws IOException{
		log.info("@getAll in ReimbursementController");
		
		List<Reimbursement> allR = rs.findAll();
		System.out.println("@getAll allR = " + allR);
		
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
	
	public void findRByAuthor(HttpServletResponse res, int author) throws IOException {
		List<Reimbursement> all = rs.findRByAuthor(author);
		res.getWriter().println(om.writeValueAsString(all));
		res.setStatus(200);
	}
	
	public void addR(HttpServletRequest req, HttpServletResponse res) throws IOException{
		log.info("@addR in ReimbursementController");
		
		BufferedReader reader = req.getReader();
		
		StringBuilder s = new StringBuilder();
		
		String line = reader.readLine();
		
		while(line != null) {
			s.append(line);
			line = reader.readLine();
		}
		
		String body = new String(s);
		
		System.out.println("@addR in RCon body = " + body);
		
		inputRDTO rDTO = om.readValue(body, inputRDTO.class);
		
		if(rs.addReimbursement(rDTO)) {
			res.setStatus(200);
		}
		else {
			res.setStatus(401);
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
		
		inputRDTO rDTO = om.readValue(body, inputRDTO.class);
		
		if(rs.updateReimbursement(rDTO)) {
			res.setStatus(201);
			res.getWriter().println("Status Changed");
		}
		else {
			res.setStatus(403);
		}
	}

public void findByUname(HttpServletRequest req, HttpServletResponse res) throws IOException{
	HttpSession ses = req.getSession(false);
	LoginDTO l = (LoginDTO) ses.getAttribute("user");
	System.out.println(l.username);
    User u = us.findByUsername(l.username);
    log.info("@fndByUname in RCon User u =" + u);
    List<Reimbursement> rList = rs.findRByAuthor(u.getUserId());
    System.out.println(rList);
    List<inputRDTO> rDTOList = new ArrayList<>();
    res.setStatus(200);
    inputRDTO rDTO= new inputRDTO();
    for (Reimbursement r: rList) {
    	rDTO.author = Integer.toString(r.getAuthor().getUserId());
		rDTO.amount = Double.toString(r.getAmount());
		rDTO.reimId = r.getReimbId();
		if(r.getResolver()!= null) {
			rDTO.resolver = Integer.toString(r.getResolver().getUserId());
		}
		else {
			rDTO.resolver = null;
		}
		rDTO.description = r.getDescription();
		rDTO.statusId = (r.getStatusId().getStatusId());
		rDTO.typeId = Integer.toString(r.getTypeId().getTypeId());
		rDTOList.add(rDTO);
	}
	System.out.println(rDTOList.toString());
	
	
	try {
		res.getWriter().println(om.writeValueAsString(rDTOList));
	} catch (JsonProcessingException e) {
			res.setStatus(400);
		e.printStackTrace();
	} catch (IOException e) {
			res.setStatus(401);
		e.printStackTrace();
	}
    }
}
