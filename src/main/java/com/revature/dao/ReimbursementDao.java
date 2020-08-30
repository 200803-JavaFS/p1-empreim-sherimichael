package com.revature.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.revature.models.Reimbursement;
import com.revature.models.ReimbursementStatus;
import com.revature.models.ReimbursementType;
import com.revature.utils.HibernateUtil;

public class ReimbursementDao implements ReimbursementDaoIf {

		public ReimbursementDao() {
			super();
		}
		
		@Override
		public List<Reimbursement> findAll() {
			Session ses = HibernateUtil.getSession();
			
			@SuppressWarnings("unchecked")
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
			
			@SuppressWarnings("unchecked")
			List<Reimbursement> rList = ses.createQuery("FROM Reimbursement WHERE author = ?").list();
			
			return rList;
		}
		
		@Override
		public boolean addRType(ReimbursementType rType) {
			Session ses = HibernateUtil.getSession();
			
			try {
				ses.save(rType);
				return true;
			}catch (HibernateException e) {
				e.printStackTrace();
				return false;
			}
			
		}
		
		@Override
		public boolean addRStatus(ReimbursementStatus rStatus) {
			Session ses = HibernateUtil.getSession();
			
			try {
				ses.save(rStatus);
				return true;
			}catch (HibernateException e) {
				e.printStackTrace();
				return false;
			}
			
		}
		
		@Override
		public boolean addReimbursement(Reimbursement reimbursement) {
			Session ses = HibernateUtil.getSession();
			
			try {
				ses.save(reimbursement);
				return true;
			}catch (HibernateException e) {
				e.printStackTrace();
				return false;
			}
			
		}
		
		@Override
		public boolean updateReimbursement(Reimbursement r) {
			Session ses = HibernateUtil.getSession();
			try {
				ses.merge(r);
				return true;
			} catch (HibernateException e) {
				e.printStackTrace();
				return false;
			}
		}
}
