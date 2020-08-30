package com.revature.dao;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.revature.models.User;
import com.revature.models.UserRole;
import com.revature.utils.HibernateUtil;

public class UserDao implements UserDaoIf {
	
	private static final Logger log = LogManager.getLogger(UserDao.class);
	
	public UserDao() {
		super();
	}
	
	public List<User> findAll() {
		//opening session to perform op on dB
		Session ses = HibernateUtil.getSession();
		
		//create a query
		@SuppressWarnings("unchecked")
		List<User> userList = ses.createQuery("FROM User").list();
		
		return userList;
	}
	
	public User findByUserId(int id) {
		Session ses = HibernateUtil.getSession();
		
		User u = ses.get(User.class, id);
		
		return u;
	}
	
	@Override
	public User findByUsername(String username) {
		Session ses = HibernateUtil.getSession();
		@SuppressWarnings("unchecked")
		List<User> uList = ses.createQuery("FROM User WHERE username=" + username).list();                  
		User u = uList.get(0);   
		//just lists the first one if there are more than one                  
		return u;    		
	}
	
	public boolean addUser(User u) {
		log.info("@addUser in UserDao");
		Session ses = HibernateUtil.getSession();
	
		try {
			ses.save(u);
			return true;
		}catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean addUserRole(UserRole uRole) {
		log.info("@addUserRole in UserDao");
		Session ses = HibernateUtil.getSession();
	
		try {
			ses.save(uRole);
			return true;
		}catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean updateUser(User u) {
		Session ses = HibernateUtil.getSession();
		
		try {
			ses.merge(u);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}
}
