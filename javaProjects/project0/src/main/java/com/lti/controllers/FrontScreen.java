package com.lti.controllers;

import java.util.Scanner;

import com.lti.daos.CustomerDao;
import com.lti.daos.CustomerPostgres;
import com.lti.daos.EmployeeDao;
import com.lti.daos.EmployeePostgres;
import com.lti.exceptions.AuthException;
import com.lti.exceptions.UserNotFoundException;
import com.lti.models.Customer;
import com.lti.models.Employee;
import com.lti.services.AuthService;
import com.lti.services.AuthServiceImpl;

public class FrontScreen {
	
	public static EmployeeDao ed = new EmployeePostgres();
	public static CustomerDao cd = new CustomerPostgres();
	public static AuthService as = new AuthServiceImpl();
	public static Employee currentEmp = new Employee();
	public static Customer currentCus = new Customer();
	
	static Scanner sc = new Scanner(System.in);
	
	public static void display() {
		String input;
		do {
			System.out.println("Enter \n1 if customer \n2 if employee \n3 to exit");
			input = sc.nextLine();
			switch(input) {
			case "1":
				String input2;
				do {
				System.out.println("Enter \n1 to Register \n2 to Login \n3 to exit");
				input2 = sc.nextLine();
				switch(input2) {
				case "1":
					
					break;
					
				case "2":
					System.out.println("enter username");
					String cusUsername =sc.nextLine();
					System.out.println("enter password");
					String cusPassword = sc.nextLine();
					
					Customer persistedCus = cd.getCustomerByUsername(cusUsername);
					if(persistedCus == null) {
						System.out.println("user does not exist");
						break;
					}else {
						if(persistedCus.getPassword().equals(cusPassword)) {
							int cusId = persistedCus.getId();
							currentCus = new Customer(cusId);
							System.out.println("it works");
							//CustomerScreen.display();
							input = "3";
							break;
						}else {
							System.out.println("wrong password");
							}	
						}
					break;
					
				case "3":
					display();
					
				}
				} while(input2 != "4");
				
				
				
				
			case "2":
				System.out.println("enter username");
				String empUsername =sc.nextLine();
				System.out.println("enter password");
				String empUpassword = sc.nextLine();
				
				Employee persistedEmp = ed.getEmployeeByUsername(empUsername);
				if(persistedEmp == null) {
					System.out.println("user does not exist");
					break;
				}else {
					if(persistedEmp.getPassword().equals(empUpassword)) {
						int empId = persistedEmp.getId();
						currentEmp = new Employee(empId);
						System.out.println("it works");
						EmployeeScreen.display();
						input = "3";
						break;
					}else {
						System.out.println("wrong password");
						}	
					}
				
				break;
				
			case "3":
				
			}
			
			
			
		}while(!input.equals("3"));
	
		}
	}

