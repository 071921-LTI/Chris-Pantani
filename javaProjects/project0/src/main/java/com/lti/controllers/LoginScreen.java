package com.lti.controllers;


import java.util.Scanner;

import com.lti.exceptions.AuthException;
import com.lti.exceptions.UserNotFoundException;
import com.lti.models.User;
import com.lti.services.AuthService;
import com.lti.services.AuthServiceImpl;
import com.lti.services.UserService;
import com.lti.services.UserServiceImpl;
import com.lti.controllers.MenuScreen;

public class LoginScreen {
	
	static Scanner sc = new Scanner(System.in);
	static UserService us = new UserServiceImpl();
	static AuthService as = new AuthServiceImpl();
	
	public static void displayLogin() {
		String input;
		do {
			System.out.println("Enter \n1 to login \n2 to register \n3 to exit");
			input = sc.nextLine();
			switch(input) {
			case "1":
				System.out.println("Enter a username");
				String username = sc.nextLine();
				
				try {
					User user = us.getUser(username);
					System.out.println("Enter Password");
					String password = sc.nextLine();
					User toCheck = new User(username, password);
					
					if(as.login(toCheck)) {
						System.out.println("Succesfully logged in");
						MenuScreen.displayMenu();
						input = "3";
					} else {
						System.out.println("Wrong Password");
					}
					
				}catch(UserNotFoundException e){
					System.out.println("user was not found");
				}catch(AuthException e) {
					System.out.println("wrong password");
				}
				break;
			case "2":
				System.out.println("Enter a username:");
				String newUsername =sc.nextLine();
				
				System.out.println("Enter a password");
				String newPassword = sc.nextLine();
				
				if (us.addUser(new User(newUsername, newPassword))) {
					System.out.println("Register Successfull");
					MenuScreen.displayMenu();
				} else {
					System.out.println("Unable to register new user");
				}
				break;
				default: System.out.println("invalid input try again");
			}
		} while(!input.equals("3"));
	}
	
	

}
