package com.lti.models;

import java.io.Serializable;

public class Item implements  Serializable{
	
	private int id;
	private String name;
	private double priceOffered;
	private double paymentMade;
	private boolean offerPending;
	private String itemDescription;
	private boolean itemSold;
	private Employee employee;
	private Customer customer;
	
	
	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Item(int id) {
		super();
		this.id = id;
		// TODO Auto-generated constructor stub
	}

	public Item(int id, String name, double priceOffered, double paymentMade, boolean offerPending,
			String itemDescription, boolean itemSold, Employee employee, Customer customer) {
		super();
		this.id = id;
		this.name = name;
		this.priceOffered = priceOffered;
		this.paymentMade = paymentMade;
		this.offerPending = offerPending;
		this.itemDescription = itemDescription;
		this.itemSold = itemSold;
		this.employee = employee;
		this.customer = customer;
	}
	
	public Item(int id, String name,String itemDescription, boolean itemSold) {
		super();
		this.id = id;
		this.name = name;
		this.itemDescription = itemDescription;
		this.itemSold = itemSold;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPriceOffered() {
		return priceOffered;
	}

	public void setPriceOffered(double priceOffered) {
		this.priceOffered = priceOffered;
	}

	public double getPaymentMade() {
		return paymentMade;
	}

	public void setPaymentMade(double paymentMade) {
		this.paymentMade = paymentMade;
	}

	public boolean isOfferPending() {
		return offerPending;
	}

	public void setOfferPending(boolean offerPending) {
		this.offerPending = offerPending;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public boolean isItemSold() {
		return itemSold;
	}

	public void setItemSold(boolean itemSold) {
		this.itemSold = itemSold;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
		result = prime * result + ((employee == null) ? 0 : employee.hashCode());
		result = prime * result + id;
		result = prime * result + ((itemDescription == null) ? 0 : itemDescription.hashCode());
		result = prime * result + (itemSold ? 1231 : 1237);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + (offerPending ? 1231 : 1237);
		long temp;
		temp = Double.doubleToLongBits(paymentMade);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(priceOffered);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (customer == null) {
			if (other.customer != null)
				return false;
		} else if (!customer.equals(other.customer))
			return false;
		if (employee == null) {
			if (other.employee != null)
				return false;
		} else if (!employee.equals(other.employee))
			return false;
		if (id != other.id)
			return false;
		if (itemDescription == null) {
			if (other.itemDescription != null)
				return false;
		} else if (!itemDescription.equals(other.itemDescription))
			return false;
		if (itemSold != other.itemSold)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (offerPending != other.offerPending)
			return false;
		if (Double.doubleToLongBits(paymentMade) != Double.doubleToLongBits(other.paymentMade))
			return false;
		if (Double.doubleToLongBits(priceOffered) != Double.doubleToLongBits(other.priceOffered))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", priceOffered=" + priceOffered + ", paymentMade=" + paymentMade
				+ ", offerPending=" + offerPending + ", itemDescription=" + itemDescription + ", itemSold=" + itemSold
				+ ", employee=" + employee + ", customer=" + customer + "]";
	}

	
	
	
}
