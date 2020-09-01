package com.revature.dao;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.revature.models.ReimbursementType;
import com.revature.utils.HibernateUtil;

public class RTypeDao implements RTypeDaoIf {
	
	private static final Logger log = LogManager.getLogger(RTypeDao.class);

	@Override
	public List<ReimbursementType> findAll() {
		log.info("@findAll in RTypeDao");
		Session ses = HibernateUtil.getSession();
		
		@SuppressWarnings("unchecked")
		List<ReimbursementType> rTList = ses.createQuery("FROM ReimbursementType").list();
		
		return rTList;
	}

	@Override
	public ReimbursementType findById(int id) {
		log.info("@afindById in RTypeDao");
		Session ses = HibernateUtil.getSession();
		
		try {
			ReimbursementType rt = ses.get(ReimbursementType.class, id);
			return rt;
		}
		catch(HibernateException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public boolean addRType(ReimbursementType rt) {
		log.info("@addRType in RTypeDao");
		Session ses = HibernateUtil.getSession();
	
		try {
			ses.save(rt);
			return true;
		}catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateRType(ReimbursementType rt) {
		log.info("@updateRType in RTypeDao");
		Session ses = HibernateUtil.getSession();
		
		try {
			ses.merge(rt);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

}
