package com.lti.controllers;

import java.util.Scanner;

import com.lti.daos.CustomerDao;
import com.lti.daos.CustomerPostgres;
import com.lti.daos.EmployeeDao;
import com.lti.daos.EmployeePostgres;
import com.lti.daos.ItemDao;
import com.lti.daos.ItemPostgres;
import com.lti.daos.OfferDao;
import com.lti.daos.OfferPostgres;
import com.lti.models.Customer;
import com.lti.models.Employee;
import com.lti.models.Item;
import com.lti.models.Offer;

public class CustomerScreen {
	
	static Scanner sc = new Scanner(System.in);
	static Customer c = new Customer();
	static Item i = new Item();
	static Offer o = new Offer();
	public static Item curItem = new Item();
	
	public static void display(Customer persistedCus){
		Customer currentCus = persistedCus;
		EmployeeDao ed = new EmployeePostgres();
		CustomerDao cd = new CustomerPostgres();
		ItemDao id = new ItemPostgres();
		OfferDao od = new OfferPostgres();
		
		int cusId = currentCus.getId();
		
		String input;
		do {
			System.out.println("Enter \n1 to view avalable items \n2 to view owned items \n3 to view remaining payments");
			input = sc.nextLine();
			switch(input) {
			case "1":
				
				System.out.println(id.getItemsCusView());
				int itemSelect;
				double offer;
				System.out.println("enter the id number of the item you wish to bid on");
				itemSelect = sc.nextInt();
				curItem = id.getItemByID(itemSelect);
				int itemId = curItem.getId();
				System.out.println("input your offer for selected item");
				offer = sc.nextDouble();
				
				o.setItem(curItem);
				o.setCustomer(currentCus);
				o.setPrice_offered(offer);
				
				od.addOffer(o);
				
//				i = id.getItemByID(itemId);
				curItem.setOfferPending(true);
				
				id.updateItem(curItem);
				
				
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
