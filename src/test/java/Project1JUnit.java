import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.models.Reimbursement;
import com.revature.models.ReimbursementStatus;
import com.revature.models.ReimbursementType;
import com.revature.models.User;
import com.revature.models.UserRole;
import com.revature.models.inputRDTO;
import com.revature.services.LoginService;
import com.revature.services.ReimbursementServices;
import com.revature.services.UserServices;

public class Project1JUnit {
	
	public static ReimbursementStatus rstest;
	public static ReimbursementType rttest;
	public static Reimbursement rtest;
	public static User utest;
	public static UserRole urtest;
	public static inputRDTO rDTOtest;
	
	public static LoginService ls;
	public static ReimbursementServices rs;
	public static UserServices us;
	
	@BeforeClass
	public static void setServices() {
		ls = new LoginService();
		rs = new ReimbursementServices();
		us = new UserServices();
	}
	
	@Before
	public void setTests() {
		urtest = new UserRole(1, "Employee");
		utest = new User("test3", "355", "Test", "Test", "test5@gmail.com", urtest);
		rstest = new ReimbursementStatus(1, "pending", null);
		rttest = new ReimbursementType(1, "food", null);
		rtest = new Reimbursement(77, null, null, "test description", utest, utest, rstest, rttest);
		rDTOtest = new inputRDTO("test2","test3","test4", 3, "test5", "test6");
	}
	
	@Test
	public void addUserTest() {
		boolean addedUser = us.addUser(utest);
		assertEquals(addedUser, true);
	}
	
	
	@Test
	public void addReimbursementTest() {
		boolean addedR = rs.addReimbursement(rDTOtest);
		assertTrue(addedR);
	}
	
	@AfterClass
	public static void reset() {
		urtest = null;
		utest = null;
		rstest = null;
		rttest = null;
		rtest = null;
		ls = null;
		rs = null;
		us = null;
	}

}
