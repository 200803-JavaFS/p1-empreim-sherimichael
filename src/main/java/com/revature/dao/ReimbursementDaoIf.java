package com.revature.dao;

import java.util.List;

import com.revature.models.Reimbursement;
import com.revature.models.ReimbursementStatus;
import com.revature.models.ReimbursementType;

public interface ReimbursementDaoIf {
	
	public List<Reimbursement> findAll();
	public Reimbursement findByReimId(int id);
	public List<Reimbursement> findByUser(int author);
	public boolean addRType(ReimbursementType rType);
	public boolean addRStatus(ReimbursementStatus rStatus);
	public boolean addReimbursement(Reimbursement addR);
	public boolean updateReimbursement(Reimbursement updateR);

}
