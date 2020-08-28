package com.revature.dao;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.User;
import com.revature.utils.HibernateUtil;

public class UserDao implements UserDaoIf {
	
	private static final Logger log = LogManager.getLogger(UserDao.class);
	
	public UserDao() {
		super();
	}
	
	public List<User> findAll() {
		Session ses = HibernateUtil.getSession();
		
		@SuppressWarnings("unchecked")
		List<User> userList = ses.createQuery("FROM Users").list();
		
		return userList;
	}
	
	public User findByUserId(int id) {
		Session ses = HibernateUtil.getSession();
		
		User u = ses.get(User.class, id);
		
		return u;
	}
	
	public void addUser(User u) {
		log.info("@addUser in UserDao");
		Session ses = HibernateUtil.getSession();
		
		Transaction tx = ses.beginTransaction();
		
		ses.save(u);
		
		tx.commit();
	}
	
	public void updateUser(User u) {
		Session ses = HibernateUtil.getSession();
		ses.merge(u);
	}
}
