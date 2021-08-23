package com.lti;

import java.sql.SQLException;
import java.sql.Timestamp;

import com.lti.dao.ReimbursementDao;
import com.lti.dao.ReimbursementHibernate;
import com.lti.dao.ReimbursementStatusDao;
import com.lti.dao.ReimbursementStatusHibernate;
import com.lti.dao.ReimbursementTypeDao;
import com.lti.dao.ReimbursementTypeHibernate;
import com.lti.dao.UserDao;
import com.lti.dao.UserHibernate;
import com.lti.dao.UserRoleDao;
import com.lti.dao.UserRoleHibernate;
import com.lti.exceptions.UserNotFoundException;
import com.lti.models.Reimbursement;
import com.lti.models.ReimbursementStatus;
import com.lti.models.ReimbursementType;
import com.lti.models.User;
import com.lti.models.UserRole;
import com.lti.services.AuthService;
import com.lti.services.AuthServiceImpl;
import com.lti.services.ReimbursementService;
import com.lti.services.ReimbursementServiceImpl;

public class Driver {
	
	static UserDao ud = new UserHibernate();
	static UserRoleDao urd = new UserRoleHibernate();
	static ReimbursementDao rd = new ReimbursementHibernate();
	static ReimbursementTypeDao rtd = new ReimbursementTypeHibernate();
	static ReimbursementStatusDao rsd = new ReimbursementStatusHibernate();
	static AuthService as = new AuthServiceImpl();
	static ReimbursementService res = new ReimbursementServiceImpl();
	
	public static void main(String[] args) throws UserNotFoundException, SQLException {
		
		System.out.println(res.getReimbursements());

//		UserRole ur = new UserRole(3,"Employee");
//		System.out.println(ur);
//		System.out.println(urd.addUserRole(ur));
		
//		ReimbursementType rt = new ReimbursementType("Other");
//		System.out.println(rt);
//		System.out.println(rtd.addReimbursementType(rt));
		
//		ReimbursementStatus rs = new ReimbursementStatus("Denied");
//		System.out.println(rs);
//		System.out.println(rsd.addReimbursementStatus(rs));

//		ReimbursementStatus rs = rsd.getReimbursementStatusById(1);
//		User u = ud.getUserById(1);
//		System.out.println("status of pending: "+res.getReimbursementsByStatus(rs,u));
		
//		ReimbursementStatus rs1 = rsd.getReimbursementStatusById(2);
//		User u1 = ud.getUserById(2);
//		System.out.println("status of approved: "+rd.getReimbursementsByStatus(rs1, u1));

		
//		UserRole ur = urd.getUserRoleById(3);
//		
//		User u = new User("cpantani","Password","Chris","Pantani","email", ur);
//		System.out.println(u);
//		System.out.println(ud.addUser(u));
//		System.out.println("created user: " + ud.getUserById(1));
		
//		System.out.println(ud.getUserByUsername("cpantani"));
		
//		Reimbursement r = new Reimbursement(600, new Timestamp(System.currentTimeMillis()), null, "", ud.getUserById(1), null, rsd.getReimbursementStatusById(1), rtd.getReimbursementTypeById(2));
//		System.out.println(r);
//		System.out.println(rd.addReimbursement(r));
//		System.out.println("created reimbursement: " + r);

//		User u = ud.getUserById(1);
//		ReimbursementStatus rs = rsd.getReimbursementStatusById(1);
//		ReimbursementType rt = rtd.getReimbursementTypeById(1);
//		
//		Reimbursement r = new Reimbursement(300, new Timestamp(System.currentTimeMillis()), null, "description testing", u , null, rs, rt);
//		System.out.println(r);
//		System.out.println(rd.addReimbursement(r));
//		System.out.println("created reimbursement: " + r);

//		r.setResolver(u);
//		r.setResolved(new Timestamp(System.currentTimeMillis()));
//		rd.updateReimbursement(r);
//		System.out.println("Driver");
//		User u = ud.getUserByUsername("Admin");
		
//		System.out.println(urd.getUserRoleById(u.getUr()));

//		String username = "Admin";
//		String password = "Password";
//		User user = as.login(username, password);
//		if(user != null) {
//			System.out.println(user);
//		}
//		User u = ud.getUserById(1);
//		System.out.println(u.getId());
		
}}
