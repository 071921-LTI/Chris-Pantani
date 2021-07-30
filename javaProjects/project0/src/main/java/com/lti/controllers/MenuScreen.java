package com.lti.controllers;

import java.util.Scanner;

public class MenuScreen {
	static Scanner sc = new Scanner(System.in);

	
	public static void displayMenu() {
		System.out.println("THIS IS THE MENU SCREEN, enter a number or word");
		String input = sc.nextLine();
		System.out.println("you are now in the menue screen: " + input + "heres the proof");
	}
}
