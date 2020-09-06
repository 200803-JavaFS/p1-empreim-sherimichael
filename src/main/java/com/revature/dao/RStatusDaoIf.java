package com.revature.dao;

import java.util.List;

import com.revature.models.ReimbursementStatus;

public interface RStatusDaoIf {
	
	public List<ReimbursementStatus> findAll();
	public ReimbursementStatus findByStatus(String status);
	public ReimbursementStatus findByStatusId(int statusId);
	public boolean addRStatus(ReimbursementStatus rs);	
	public boolean updateRStatus(ReimbursementStatus rs);

}
