package com.lti.controllers;

import java.util.Scanner;

import com.lti.daos.CustomerDao;
import com.lti.daos.CustomerPostgres;
import com.lti.daos.EmployeeDao;
import com.lti.daos.EmployeePostgres;
import com.lti.daos.ItemDao;
import com.lti.daos.ItemPostgres;
import com.lti.models.Customer;
import com.lti.models.Employee;
import com.lti.models.Item;

public class EmployeeScreen {

	static Scanner sc = new Scanner(System.in);
	static Employee e = new Employee();
	static Customer c = new Customer();
	static Item i = new Item();
	
	public static void display(Employee persistedEmp) {
		Employee currentEmp = persistedEmp;
		EmployeeDao ed = new EmployeePostgres();
		CustomerDao cd = new CustomerPostgres();
		ItemDao id = new ItemPostgres();
		 
		String input;
		do {
			System.out.println("Enter \n1 to add item \n2 to view pending offers \n3 to remove items \n4 to view all payments \n5 add new employee");
			input = sc.nextLine();
			switch(input) {
			case "1":
				
				//Item i = new Item();
				
				e = ed.getEmployeeByID(1); //add getID to this
				c = cd.getCustomerByID(1);//add get id for customer
				
				System.out.println("Enter name of item");
				String itemName = sc.nextLine();
				i.setName(itemName);
				
				i.setPriceOffered(0.0);
				
				i.setPaymentMade(0.0);
				
				i.setOfferPending(false);
				
				System.out.println("enter description of the item");
				String itemDescription = sc.nextLine();
				i.setItemDescription(itemDescription);
				
				i.setItemSold(false);
				
				i.setEmployee(e);
				
				i.setCustomer(c);
				
				int genId = id.addItem(i);
				System.out.println("the generated item id is: "+ genId);
				System.out.println(id.getItemByID(genId));
				
				
				
				input = "6";
				break;
			
			case "2":
				
			case "3":
			
			case "4":
				
			case "5":
				//Employee e = new Employee();
				
				System.out.println("Enter first name:");
				String firstName = sc.nextLine();
				e.setFirst_name(firstName);
				
				System.out.println("Enter last name:");
				String lastName = sc.nextLine();
				e.setLast_name(lastName);
				
				
				System.out.println("Enter username:");
				String username = sc.nextLine();
				e.setUsername(username);
				
				System.out.println("Enter password:");
				String password = sc.nextLine();
				e.setPassword(password);
				
				System.out.println("Enter email:");
				String email = sc.nextLine();
				e.setEmail(email);
				
//				int genId = ed.addEmployee(e);
//				System.out.println("the generated id is: " + genId);
//				System.out.println(ed.getEmployeeByID(genId));
				
				input = "6";
				break;
			}
		}while(!input.equals("6"));
	}
}
	
