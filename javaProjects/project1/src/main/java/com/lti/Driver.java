package com.lti;

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

public class Driver {
	
	static UserDao ud = new UserHibernate();
	static UserRoleDao urd = new UserRoleHibernate();
	static ReimbursementDao rd = new ReimbursementHibernate();
	static ReimbursementTypeDao rtd = new ReimbursementTypeHibernate();
	static ReimbursementStatusDao rsd = new ReimbursementStatusHibernate();
	
	public static void main(String[] args) throws UserNotFoundException {
		
		UserRole ur = new UserRole(1,"Admin");
		System.out.println(ur);
		System.out.println(urd.addUserRole(ur));
		
		ReimbursementType rt = new ReimbursementType("travel");
		System.out.println(rt);
		System.out.println(rtd.addReimbursementType(rt));
		
		ReimbursementStatus rs = new ReimbursementStatus("pending");
		System.out.println(rs);
		System.out.println(rsd.addReimbursementStatus(rs));
		
		


		
		
		User u = new User("Admin","Password","Chirs","Pantani","email", ur);
		System.out.println(u);
		System.out.println(ud.addUser(u));
		System.out.println("created user: " + ud.getUserById(1));
		
		Reimbursement r = new Reimbursement(100, new Timestamp(System.currentTimeMillis()), null, "description", u, null, rs, rt);
		System.out.println(r);
		System.out.println(rd.addReimbursement(r));
		System.out.println("created reimbursement: " + r);
	}

}
