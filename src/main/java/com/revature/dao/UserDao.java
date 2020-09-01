package com.revature.dao;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.revature.models.User;
import com.revature.utils.HibernateUtil;

public class UserDao implements UserDaoIf {
	
	private static final Logger log = LogManager.getLogger(UserDao.class);
	
	public UserDao() {
		super();
	}
	
	public List<User> findAll() {
		log.info("@findAll in UserDao");
		Session ses = HibernateUtil.getSession();
		
		//create a query
		@SuppressWarnings("unchecked")
		List<User> userList = ses.createQuery("FROM User").list();
		
		return userList;
	}
	
	public User findByUId(int id) {
		log.info("@afindById in UserDao");
		Session ses = HibernateUtil.getSession();
		
		try {
			User u = ses.get(User.class, id);
			return u;
		}
		catch(HibernateException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	@Override
	public User findByUsername(String username) {
		log.info("@findByUsername in UserDao");
		Session ses = HibernateUtil.getSession();
		try {
			User us = (User) ses.createQuery("FROM User WHERE username =" + username,User.class);
			return us;
		}
		catch(HibernateException e) {
			e.printStackTrace();
		}
		
		return null;	
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
	
	public boolean updateUser(User u) {
		log.info("@updateUser in UserDao");
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
