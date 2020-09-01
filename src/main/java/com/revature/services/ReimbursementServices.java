package com.revature.services;

import java.util.List;

import com.revature.dao.ReimbursementDao;
import com.revature.dao.ReimbursementDaoIf;
import com.revature.models.Reimbursement;

public class ReimbursementServices {
	
	ReimbursementDaoIf rDao = new ReimbursementDao();
	
	public List<Reimbursement> findAll() {
		return rDao.findAll();
	}
	public Reimbursement findByRId(int id) {
		return rDao.findByRId(id);
	}
	public List<Reimbursement> findByUser(String email) {
		return rDao.findByUser(email);
	}
	public List<Reimbursement> findByRStatus(String status) {
		return rDao.findByRStatus(status);
	}
	public boolean addReimbursement(Reimbursement addR) {
		return rDao.addReimbursement(addR);
	}
	public boolean updateReimbursement(Reimbursement updateR) {
		return rDao.addReimbursement(updateR);
	}
}
