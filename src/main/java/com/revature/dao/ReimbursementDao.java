package com.revature.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.Reimbursement;
import com.revature.utils.HibernateUtil;

public class ReimbursementDAO {

		public ReimbursementDAO() {
			super();
		}
		
		public void insert(Reimbursement r) {
			Session ses = HibernateUtil.getSession();
			
			Transaction tx = ses.beginTransaction();
			
			ses.save(r);
			
			tx.commit();
		}
		
		public void update(Reimbursement r) {
			Session ses = HibernateUtil.getSession();
			ses.merge(r);
		}
		
		public List<Reimbursement> findByStatus(int id) {
			Session ses = HibernateUtil.getSession();
			
			List<Reimbursement> rList = ses.createQuery("FROM Reimbursement").list();
			
			return rList;
		}
		
		public List<Reimbursement> findByUser(int id) {
			Session ses = HibernateUtil.getSession();
			
			List<Reimbursement> rList = ses.createQuery("FROM Reimbursement").list();
			
			return rList;
		}
		
		public Reimbursement selectById(int id) {
			Session ses = HibernateUtil.getSession();
			
			Reimbursement r = ses.get(Reimbursement.class, id);
			
			return r;
		}
		
		public List<Reimbursement> findAll() {
			Session ses = HibernateUtil.getSession();
			
			List<Reimbursement> rList = ses.createQuery("FROM Reimbursement").list();
			
			return rList;
		}
	}
		
}
