package com.revature.dao;

import java.util.List;

import com.revature.models.ReimbursementType;

public interface RTypeDaoIf {
	
	public List<ReimbursementType> findAll();
	public ReimbursementType findById(int id);
	public boolean addRType(ReimbursementType rt);	
	public boolean updateRType(ReimbursementType rt);
}
