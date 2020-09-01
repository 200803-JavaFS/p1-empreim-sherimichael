package com.revature.dao;

import java.util.List;

import com.revature.models.Reimbursement;

public interface ReimbursementDaoIf {
	
	public List<Reimbursement> findAll();
	public Reimbursement findByRId(int id);
	public List<Reimbursement> findByUser(String email);
	public List<Reimbursement> findByRStatus(String status);
	public boolean addReimbursement(Reimbursement addR);
	public boolean updateReimbursement(Reimbursement updateR);
	

}
