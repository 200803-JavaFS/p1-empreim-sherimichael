package com.revature.dao;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.revature.models.UserRole;
import com.revature.utils.HibernateUtil;

public class URoleDao implements URoleDaoIf {
	
	private static final Logger log = LogManager.getLogger(UserDao.class);

	@Override
	public List<UserRole> findAll() {
		log.info("@findAll in URoleDao");
		Session ses = HibernateUtil.getSession();
		
		@SuppressWarnings("unchecked")
		List<UserRole> uRList = ses.createQuery("FROM UserRole").list();
		
		return uRList;
	}

	@Override
	public UserRole findById(int id) {
		log.info("@afindById in URoleDao");
		Session ses = HibernateUtil.getSession();
		
		try {
			UserRole ur = ses.get(UserRole.class, id);
			return ur;
		}
		catch(HibernateException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public boolean addURole(UserRole ur) {
		log.info("@addRole in URoleDao");
		Session ses = HibernateUtil.getSession();
	
		try {
			ses.save(ur);
			return true;
		}catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateURole(UserRole ur) {
		log.info("@updateURole in URoleDao");
		Session ses = HibernateUtil.getSession();
		
		try {
			ses.merge(ur);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

}
