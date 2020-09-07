package com.revature.services;

import java.util.List;

import com.revature.dao.RStatusDao;
import com.revature.dao.RTypeDao;
import com.revature.dao.ReimbursementDao;
import com.revature.dao.UserDao;
import com.revature.models.LoginDTO;
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
	
	public List<Reimbursement> findRByAuthor(int author) {
		return rDao.findRByAuthor(author);	
	}

	public boolean addReimbursement(inputRDTO rDTO) {
			Reimbursement r = new Reimbursement();
			int amount = Integer.parseInt(rDTO.amount);
			int typeId = Integer.parseInt(rDTO.typeId);
			
			r.setAuthor(uDao.findByUsername(rDTO.author));
			r.setAmount(amount);
			r.setDescription(rDTO.description);
			r.setStatusId(rsDao.findByStatusId(rDTO.statusId));
			r.setTypeId(rtDao.findById(typeId));
			if(rDao.addReimbursement(r)) {
				return true;
			}
			return false;
	}
	public boolean updateReimbursement(inputRDTO rDTO) {
		Reimbursement r = rDao.findByRId(rDTO.reimId);
		ReimbursementStatus rs = rsDao.findByStatusId(rDTO.statusId);
		r.setStatusId(rs);
		r.setResolver(uDao.findByUsername(rDTO.author));
		rDao.updateReimbursement(r);
		return false;
	}
}
