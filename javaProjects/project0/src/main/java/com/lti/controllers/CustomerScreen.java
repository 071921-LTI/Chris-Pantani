package com.lti.controllers;

import java.util.Scanner;

import com.lti.models.Customer;
import com.lti.models.Employee;

public class CustomerScreen {
	
	static Scanner sc = new Scanner(System.in);
	static Customer c = new Customer();
	
	public static void display(){
		
		String input;
		do {
			System.out.println("Enter \n1 to view avalable items \n2 to view owned items \n3 to view remaining payments");
			input = sc.nextLine();
			switch(input) {
			case "1":
				
				break;
			case "2":
				
				break;
			case "3":
				System.out.println("works");
				
				break;
			}
			
			
			
		} while (!input.equals("5"));
		}
	
}
