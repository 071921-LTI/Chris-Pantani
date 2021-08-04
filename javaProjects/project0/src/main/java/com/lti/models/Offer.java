package com.lti.models;

import java.io.Serializable;

public class Offer implements Serializable{
	
	private int id;
	private Item item;
	private Customer customer;
	private double price_offered;
	
	
	public Offer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Offer(int id) {
		super();
		this.id = id;
		// TODO Auto-generated constructor stub
	}

	public Offer(int id, Item item, Customer customer, double price_offered) {
		super();
		this.id = id;
		this.item = item;
		this.customer = customer;
		this.price_offered = price_offered;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public double getPrice_offered() {
		return price_offered;
	}

	public void setPrice_offered(double price_offered) {
		this.price_offered = price_offered;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
		result = prime * result + id;
		result = prime * result + ((item == null) ? 0 : item.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price_offered);
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
		Offer other = (Offer) obj;
		if (customer == null) {
			if (other.customer != null)
				return false;
		} else if (!customer.equals(other.customer))
			return false;
		if (id != other.id)
			return false;
		if (item == null) {
			if (other.item != null)
				return false;
		} else if (!item.equals(other.item))
			return false;
		if (Double.doubleToLongBits(price_offered) != Double.doubleToLongBits(other.price_offered))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Offer [id=" + id + ", item=" + item + ", customer=" + customer + ", price_offered=" + price_offered
				+ "]";
	}
	
	
	

}
