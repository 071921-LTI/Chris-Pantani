package com.lti.controllers;

import java.util.Scanner;

import com.lti.daos.EmployeeDao;
import com.lti.daos.EmployeePostgres;

public class EmployeeScreen {

	EmployeeDao ed = new EmployeePostgres();
	static Scanner sc = new Scanner(System.in);
	
	public static void employeeScreen() {
		String input;
		do {
			System.out.println("Enter \n1 to add item \n2 to view pending offers \n3 to remove items \n4 to view all payments");
			input = sc.nextLine();
			switch(input) {
			case "1":
			
			case "2":
				
			case "3":
			
			case "4":
			}
		
		
		}while(!input.equals(4));
	}
	
	public void addItem() {
		
	}

}
