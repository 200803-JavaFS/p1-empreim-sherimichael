package com.revature.dao;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.revature.controllers.LoginController;
import com.revature.models.User;
import com.revature.models.UserRole;
import com.revature.utils.HibernateUtil;

public class UserDao implements UserDaoIf {
	
	private static final Logger log = LogManager.getLogger(UserDao.class);
	private static LoginController lc = new LoginController();
	
	public UserDao() {
		super();
	}
	
	@Override
	public List<User> findAll() {
		log.info("@findAll in UserDao");
		Session ses = HibernateUtil.getSession();
		
		//create a query
		@SuppressWarnings("unchecked")
		List<User> userList = ses.createQuery("FROM User").list();
		
		return userList;
	}
	
	@Override
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
			List<User> us = ses.createQuery("from User where username ='" + username+"'",User.class).list();
			//System.out.println("@findByUsername in UDao List<User> us = " + us);
			//System.out.println("@findByUsername in UDao username = " + username);
			return us.get(0);
		}
		catch(HibernateException e) {
			e.printStackTrace();
		}
		
		return null;	
	}
	
	@Override
	public User findByEmail(String email) {
		log.info("@findByEmail in UserDao");
		Session ses = HibernateUtil.getSession();
		try {
			List<User> us = ses.createQuery("from User where email ='" + email+"'",User.class).list();
			//System.out.println("@findByEmail in UDao List<User> us = " + us);
			//System.out.println("@findByEMail in UDao email= " + email);
			return us.get(0);
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
