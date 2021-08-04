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
			System.out.println("Enter \n1 to view avalable items \n2 to view owned items \n3 to view remaining payments \n4 exit to main screen");
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
				
				input = "5";
				
				
				break;
			case "2":
				System.out.println("these are your owned items");
				System.out.println(id.ownedItems(currentCus));
				input = "5";
				
				break;
			case "3":
				System.out.println("Here is a list of all purchased items and payments");
				System.out.println(id.paymentsItem(currentCus));
				System.out.println("enter the id of the item you wish to select");
				int itemPaymentId = sc.nextInt();
				
				Item paymentItem = id.getItemByID(itemPaymentId);
				
				System.out.println(paymentItem);
				double paymentMade = paymentItem.getPaymentMade(); //692.28
				double totalPrice = paymentItem.getPriceOffered(); //3000.0
				double remainingPay = totalPrice - paymentMade; //2307.72
				double weeklyPay = (totalPrice/26); //115.38
				double paymentsRemaining = Math.floor(remainingPay/weeklyPay); //2307.72/115.38
				System.out.println("your weekly paymemt is "+ weeklyPay +" paid every week over 6 months (26 weeks)");
				System.out.println("you have "+ paymentsRemaining + "weekly payments remaining");
				System.out.println("your total remaining payment for this item is: " + remainingPay);
				
				String makePayment;
				do {
					System.out.println("do you wish to make a payment? y(yes), n(no) \ny \nn");
					makePayment = sc.nextLine();
					switch(makePayment) {
					case "y":
						paymentMade = paymentMade + weeklyPay;
						System.out.println(paymentMade);
						paymentItem.setPaymentMade(paymentMade);
						id.updateItem(paymentItem);
						makePayment = "n";
						break;
						
					case "n":
						
						break;
					}
				}while(!makePayment.equals("n"));
				
				break;
				
			case "4":
				FrontScreen.display();
			}	
		} while (!input.equals("5"));
		}
	
}
