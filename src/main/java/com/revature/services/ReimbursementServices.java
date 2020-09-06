package com.revature.services;

import java.util.List;

import com.revature.dao.RStatusDao;
import com.revature.dao.RTypeDao;
import com.revature.dao.ReimbursementDao;
import com.revature.dao.UserDao;
import com.revature.models.Reimbursement;
import com.revature.models.ReimbursementStatus;
import com.revature.models.inputRDTO;

public class ReimbursementServices {
	
	UserDao uDao = new UserDao();
	RTypeDao rtDao = new RTypeDao();
	ReimbursementDao rDao = new ReimbursementDao(); 
	RStatusDao rsDao = new RStatusDao();
	
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
	public boolean addReimbursement(inputRDTO rDTO, int uId) {
			Reimbursement r = new Reimbursement();
			r.setAuthor(uDao.findByUId(uId));
			r.setAmount(rDTO.getAmount());
			r.setDescription(rDTO.getDescription());
			r.setTypeId(rtDao.findById(rDTO.getTypeId()));
			if(rDao.addReimbursement(r)) {
				return true;
			}
			return false;
	}
	public boolean updateReimbursement(inputRDTO rDTO, int uId) {
		Reimbursement r = rDao.findByRId(rDTO.getReimId());
		ReimbursementStatus rs = rsDao.findByStatusId(rDTO.getStatusId());
		r.setStatusId(rs);
		r.setResolver(uDao.findByUId(uId));
		rDao.updateReimbursement(r);
		return false;
	}
}
