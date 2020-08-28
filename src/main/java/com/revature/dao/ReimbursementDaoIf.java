package com.revature.dao;

import java.util.List;

import com.revature.models.Reimbursement;

public interface ReimbursementDaoIf {
	
	public List<Reimbursement> findAll();
	public Reimbursement findByReimId(int id);
	public List<Reimbursement> findByUser(int author);
	public void addReimbursement(Reimbursement addR);
	public void updateReimbursement(Reimbursement updateR);

}
