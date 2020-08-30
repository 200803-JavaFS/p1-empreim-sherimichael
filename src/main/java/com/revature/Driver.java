package com.revature;

import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.dao.ReimbursementDao;
import com.revature.dao.UserDao;
import com.revature.models.Reimbursement;
import com.revature.models.ReimbursementStatus;
import com.revature.models.ReimbursementType;
import com.revature.models.User;
import com.revature.models.UserRole;

public class Driver {
		
	public static UserDao uDao = new UserDao();
	public static ReimbursementDao rDao = new ReimbursementDao();
	
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
			UserRole uRole0 = new UserRole(0, "Employee");
			UserRole uRole1 = new UserRole(1, "Finance Manager");
			User u1 = new User("batman", "batmobile", "Bruce", "Wayne", "wayne@email.com", uRole0);
			uDao.addUserRole(uRole0);
			uDao.addUserRole(uRole1);	
			uDao.addUser(u1);
			User u2 = new User("joker", "whysoserious", "The", "Joker", "joker@email.com", uRole1 );
			uDao.addUser(u2);
			
			
			Reimbursement r1 = new Reimbursement();
			Reimbursement r2 = new Reimbursement();
			List<Reimbursement> rList = Arrays.asList(r1, r2);
			ReimbursementStatus rs = new ReimbursementStatus(1, "pending", rList);
			ReimbursementType rt = new ReimbursementType(2, "travel", rList);
			rDao.addRStatus(rs);
			rDao.addRType(rt);
			Reimbursement r3 = new Reimbursement(27.56, "Timestamp", "Timestamp", "Client Mtg", u1, u2, rs, rt);
			rDao.addReimbursement(r3);	
		}
}
