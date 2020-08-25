package com.revature.dao;

import java.util.List;

import com.revature.models.Reimbursement;

public interface ReimbursementDaoIf {
	
	public List<Reimbursement> findAll();
	public Reimbursement findById(int id);
	public List<Reimbursement> findByUser(int userId);
	public List<Reimbursement> findByStatus(String status);
	public boolean addReimbursement(Reimbursement addR);
	public boolean updateReimbursement(Reimbursement updateR);

}
