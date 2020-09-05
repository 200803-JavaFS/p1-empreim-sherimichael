package com.revature;

import java.sql.Timestamp;
import java.util.Arrays;
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
import com.revature.models.inputRDTO;

public class Driver {
		
	public static UserDao uDao = new UserDao();
	public static URoleDao uRDao = new URoleDao();
	public static ReimbursementDao rDao = new ReimbursementDao();
	public static RTypeDao rTDao = new RTypeDao();
	public static RStatusDao rSDao = new RStatusDao();
	
	private static final Logger log = LogManager.getLogger(Driver.class);

	public static void main(String[] args) {
		
		log.info("@main in Driver - app starting");
			
		//insertValues();
			
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
	
			
			inputRDTO r1 = new inputRDTO();
			System.out.println(r1);
			inputRDTO r2 = new inputRDTO();
			List<inputRDTO> rList = Arrays.asList(r1, r2);
			ReimbursementStatus rs = new ReimbursementStatus("pending", rList);
			ReimbursementStatus rs2 = new ReimbursementStatus("approved", rList);
			ReimbursementStatus rs3 = new ReimbursementStatus("denied", rList);
			ReimbursementType rt = new ReimbursementType("travel", rList);
			ReimbursementType rt2 = new ReimbursementType("food", rList);
			ReimbursementType rt3 = new ReimbursementType("lodging", rList);
			ReimbursementType rt4 = new ReimbursementType("other", rList);
			rSDao.addRStatus(rs);
			rSDao.addRStatus(rs2);
			rSDao.addRStatus(rs3);
			rTDao.addRType(rt);
			rTDao.addRType(rt2);
			rTDao.addRType(rt3);
			rTDao.addRType(rt4);
			Timestamp t1 = new Timestamp(System.currentTimeMillis());
			Timestamp t2 = new Timestamp(System.currentTimeMillis());
			Reimbursement r3 = new Reimbursement(27.56,t1, t2, "Client Mtg in Omaha",u1, u2, rs2,rt2);
			Reimbursement r5 = new Reimbursement(5.78, t1, null, "Gas to pickup Supplies", u1, null, rs, rt4);
			Reimbursement r6 = new Reimbursement(100.00,t1, t2, "Client Mtg in Omaha",u1, u2,rs3, rt);
			Reimbursement r7 = new Reimbursement(20.00,t1, null, "Client Mtg in Omaha", u1, null, rs, rt4);
			rDao.addReimbursement(r3);
			rDao.addReimbursement(r5);
			rDao.addReimbursement(r6);
			rDao.addReimbursement(r7);
			
		}
}
