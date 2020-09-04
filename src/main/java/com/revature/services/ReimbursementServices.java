package com.revature.services;

import java.util.List;

import com.revature.dao.ReimbursementDao;
import com.revature.dao.ReimbursementDaoIf;
import com.revature.models.Reimbursement;
import com.revature.models.inputRDTO;

public class ReimbursementServices {
	
	ReimbursementDaoIf rDao = new ReimbursementDao();
	
	public List<Reimbursement> findAll() {
		return rDao.findAll();
	}
	public Reimbursement findByRId(int id) {
		return rDao.findByRId(id);
	}
	public List<Reimbursement> findByUser(int author) {
		return rDao.findByUser(author);
	}
	public List<Reimbursement> findByRStatus(int statusId) {
		return rDao.findByRStatus(statusId);
	}
	public List<Reimbursement> findByUserStatus(int author, int statusId) {
		return rDao.findByUserStatus(author, statusId);
	}
	public boolean addReimbursement(inputRDTO addR, int userId) {
		return rDao.addReimbursement(addR, userId);
	}
	public boolean updateReimbursement(inputRDTO updateR) {
		return rDao.addReimbursement(updateR);
	}
}
