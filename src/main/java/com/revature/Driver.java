package com.revature;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.dao.ReimbursementDao;
import com.revature.dao.UserDao;
import com.revature.models.Reimbursement;
import com.revature.models.User;

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
			User u1 = new User("batman", "batmobile", "Bruce", "Wayne", "bruce@email.com", 0);
			uDao.addUser(u1);
			User u2 = new User("joker", "whysoserious", "The", "Joker", "joker@email.com", 1);
			uDao.addUser(u2);
			
			Reimbursement r1 = new Reimbursement(27.56, "Timestamp", "Timestamp", "Client Mtg", u1, u2, 1, 2);
			rDao.addReimbursement(r1);
			
		}


}
