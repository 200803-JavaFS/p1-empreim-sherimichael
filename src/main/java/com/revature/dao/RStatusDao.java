package com.revature.dao;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.revature.models.ReimbursementStatus;
import com.revature.models.ReimbursementType;
import com.revature.utils.HibernateUtil;

public class RStatusDao implements RStatusDaoIf {
	
	private static final Logger log = LogManager.getLogger(RTypeDao.class);

	@Override
	public List<ReimbursementStatus> findAll() {
		log.info("@findAll in RStatusDao");
		Session ses = HibernateUtil.getSession();
		
		@SuppressWarnings("unchecked")
		List<ReimbursementStatus> rSList = ses.createQuery("FROM ReimbursementStatus").list();
		
		return rSList;
	}

	@Override
	public ReimbursementStatus findByStatus(String status) {
		log.info("@afindByStatus in RStatusDao");
		Session ses = HibernateUtil.getSession();
		
		try {
			ReimbursementStatus rs = ses.get(ReimbursementStatus.class, status);
			return rs;
		}
		catch(HibernateException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public boolean addRStatus(ReimbursementStatus rs) {
		log.info("@addRStatus in RStattusDao");
		Session ses = HibernateUtil.getSession();
	
		try {
			ses.save(rs);
			return true;
		}catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateRStatus(ReimbursementStatus rs) {
		log.info("@updateRStatus in RStatusDao");
		Session ses = HibernateUtil.getSession();
		
		try {
			ses.merge(rs);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}
	

}
