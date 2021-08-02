package com.lti;

import com.lti.controllers.EmployeeScreen;
import com.lti.controllers.FrontScreen;
import com.lti.daos.CustomerDao;
import com.lti.daos.CustomerPostgres;
import com.lti.daos.EmployeeDao;
import com.lti.daos.EmployeePostgres;
import com.lti.daos.ItemDao;
import com.lti.daos.ItemPostgres;
import com.lti.exceptions.AuthException;
import com.lti.models.Employee;
import com.lti.services.AuthService;
import com.lti.services.AuthServiceImpl;

public class Driver {
	
	public static void main(String[] args) {
		
		
		EmployeeDao ed = new EmployeePostgres();
		AuthService as = new AuthServiceImpl();
		CustomerDao cd = new CustomerPostgres();
		ItemDao id = new ItemPostgres();
		
		FrontScreen.display();
		//System.out.println(id.getItemsCusView());
		
//		System.out.println(cd.getCustomerByUsername("testCus"));
		
//		String username = "cpantani";
//		String password = "password";
//		try {
//			if(as.empLogin(username, password)!= null);
//			System.out.println("log in works");
//		} catch (AuthException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		//Employee e = new Employee();
//		e.setFirst_name("test_first_name2");
//		e.setLast_name("test_last_name2");
//		e.setEmail("test@test.com2");
//		e.setUsername("test_username2");
//		e.setPassword("testpass2");
//		
//		int genId = ed.addEmployee(e);
//		System.out.println("the generated id is: " + genId);
//		System.out.println(ed.getEmployeeByID(genId));
		//System.out.println(ed.getEmployeeByUsername("cpantani").getId());
	}

}
