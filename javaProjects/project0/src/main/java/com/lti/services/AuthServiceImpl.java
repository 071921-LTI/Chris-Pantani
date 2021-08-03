package com.lti.services;

import com.lti.exceptions.AuthException;
import com.lti.models.Customer;
import com.lti.models.Employee;
import com.lti.services.AuthService;
import com.lti.uitl.ConnectionUtil;

import java.sql.Connection;
import java.sql.SQLException;

import com.lti.daos.CustomerDao;
import com.lti.daos.CustomerPostgres;
import com.lti.daos.EmployeeDao;
import com.lti.daos.EmployeePostgres;
import com.lti.models.Employee;

public class AuthServiceImpl implements AuthService{
	
	private EmployeeDao ed = new EmployeePostgres();
	private CustomerDao cd = new CustomerPostgres();
	
	@Override
	public Employee empLogin(String username, String password) throws AuthException {
		Employee currentEmp = null;
		Employee persistedEmp = ed.getEmployeeByUsername(username);
		if(persistedEmp.getPassword().equals(password)) {
			int empId = persistedEmp.getId();
			currentEmp = new Employee(empId);
			return currentEmp;
		}else {
			throw new AuthException();
		}
	}

	@Override
	public Customer cusLogin(String username, String password) throws AuthException {
		Customer currentcus = null;

		Customer persistedCus = cd.getCustomerByUsername(username);
		if(persistedCus.getPassword().equals(password)) {
			int cusId = persistedCus.getId();
			persistedCus = new Customer(cusId);
			return currentcus;
		} 
		return null;
	}
}
