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
	public boolean addReimbursement(inputRDTO addR) {
		Reimbursement r = new Reimbursement(addR.getAmount(), null, null, addR.getDescription(), addR.getAuthor(), null, addR.getStatusId(), addR.getTypeId());
		return rDao.addReimbursement(r);
	}
	public boolean updateReimbursement(inputRDTO rDTO) {
		Reimbursement r = new Reimbursement(rDTO.getAmount(), null, null, rDTO.getDescription(), rDTO.getAuthor(), null, rDTO.getStatusId(), rDTO.getTypeId());
		return rDao.addReimbursement(r);
	}
}
