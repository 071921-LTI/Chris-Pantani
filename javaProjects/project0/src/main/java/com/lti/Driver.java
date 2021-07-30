package com.lti;

import com.lti.controllers.LoginScreen;
import com.lti.daos.EmployeeDao;
import com.lti.daos.EmployeePostgres;
import com.lti.models.Employee;

public class Driver {
	
	public static void main(String[] args) {
		//LoginScreen.displayLogin();
		
		EmployeeDao ed = new EmployeePostgres();
		
		Employee e = new Employee();
		e.setFirst_name("test_first_name");
		e.setLast_name("test_last_name");
		e.setEmail("test@test.com");
		e.setUsername("test_username");
		e.setPassword("testpass");
		
		int genId = ed.addEmployee(e);
		System.out.println("the generated id is: " + genId);
		System.out.println(ed.getEmployeeByID(genId));
	}

}
