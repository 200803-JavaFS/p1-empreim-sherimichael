package com.revature.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.Reimbursement;
import com.revature.utils.HibernateUtil;

public class ReimbursementDao implements ReimbursementDaoIf {

		public ReimbursementDao() {
			super();
		}
		
		@Override
		public List<Reimbursement> findAll() {
			Session ses = HibernateUtil.getSession();
			
			List<Reimbursement> rList = ses.createQuery("FROM Reimbursement").list();
			
			return rList;
		}
		
		@Override
		public Reimbursement findByReimId(int id) {
			Session ses = HibernateUtil.getSession();
			
			Reimbursement r = ses.get(Reimbursement.class, id);
			
			return r;
		}
		
		@Override
		public List<Reimbursement> findByUser(int author) {
			Session ses = HibernateUtil.getSession();
			
			List<Reimbursement> rList = ses.createQuery("FROM Reimbursement WHERE author = ?").list();
			
			return rList;
		}
		
		@Override
		public void addReimbursement(Reimbursement r) {
			Session ses = HibernateUtil.getSession();
			
			Transaction tx = ses.beginTransaction();
			
			ses.save(r);
			
			tx.commit();
		}
		
		@Override
		public void updateReimbursement(Reimbursement r) {
			Session ses = HibernateUtil.getSession();
			ses.merge(r);
		}
}
