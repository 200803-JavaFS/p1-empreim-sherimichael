package com.revature;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.dao.RStatusDao;
import com.revature.dao.RTypeDao;
import com.revature.dao.ReimbursementDao;
import com.revature.dao.URoleDao;
import com.revature.dao.UserDao;
import com.revature.models.Reimbursement;
import com.revature.models.ReimbursementStatus;
import com.revature.models.ReimbursementType;
import com.revature.models.User;
import com.revature.models.UserRole;

public class Driver {
		
	public static UserDao uDao = new UserDao();
	public static URoleDao uRDao = new URoleDao();
	public static ReimbursementDao rDao = new ReimbursementDao();
	public static RTypeDao rTDao = new RTypeDao();
	public static RStatusDao rSDao = new RStatusDao();
	
	private static final Logger log = LogManager.getLogger(Driver.class);

	public static void main(String[] args) {
		
		log.info("@main in Driver - app starting");
			
		insertValues();
			
		List<Reimbursement> rs = rDao.findAll();
			
			for(Reimbursement r : rs) {
				System.out.println(r);
			}
		}
		
		public static void insertValues() {
			
			String p = "password";
			StringBuilder sb = new StringBuilder();
			sb.append(p.hashCode());
			String hashp = sb.toString();
			
			UserRole ur1 = new UserRole("Employee");
			UserRole ur2 = new UserRole("Finance Manager");
			uRDao.addURole(ur1);
			uRDao.addURole(ur2);
			User u1 = new User("batman", hashp, "Bruce", "Wayne", "wayne@email.com", ur1);	
			uDao.addUser(u1);
			User u2 = new User("joker", hashp, "The", "Joker", "joker@email.com", ur2);
			uDao.addUser(u2);
				
			Reimbursement r1 = new Reimbursement();
			System.out.println(r1);
			Reimbursement r2 = new Reimbursement();
			List<Reimbursement> rList = Arrays.asList(r1, r2);
			ReimbursementStatus rs = new ReimbursementStatus("pending", rList);
			ReimbursementStatus rs2 = new ReimbursementStatus("approved", rList);
			ReimbursementStatus rs3 = new ReimbursementStatus("denied", rList);
			ReimbursementType rt = new ReimbursementType("travel", rList);
			ReimbursementType rt2 = new ReimbursementType("food", rList);
			ReimbursementType rt3 = new ReimbursementType("lodging", rList);
			ReimbursementType rt4 = new ReimbursementType("other", rList);
			rSDao.addRStatus(rs);
			rTDao.addRType(rt);
			Date date = new Date();
			Timestamp ts1 = new Timestamp(date.getTime());
			Timestamp ts2 = new Timestamp(date.getTime());
			Reimbursement r3 = new Reimbursement(27.56, ts1, ts2, "Client Mtg in Omaha", u1, u2, rs, rt2);
			Reimbursement r4 = new Reimbursement(65.34, ts1, ts2, "Client Mtg in Omaha", u1, u2, rs, rt3);
			Reimbursement r5 = new Reimbursement(5.78, ts1, ts2, "Gas to pickup Supplies", u1, u2, rs, rt4);
			Reimbursement r6 = new Reimbursement(100.00, ts1, ts2, "Client Mtg in Omaha", u1, u2, rs, rt);
			rDao.addReimbursement(r3);
			rDao.addReimbursement(r4);
			rDao.addReimbursement(r5);
			rDao.addReimbursement(r6);
		}
}
