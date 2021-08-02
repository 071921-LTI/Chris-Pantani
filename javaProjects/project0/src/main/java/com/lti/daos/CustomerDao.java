package com.lti.daos;

import java.util.List;
import com.lti.models.Customer;

public interface CustomerDao {
	public abstract Customer getCustomerByID(int id);
	public abstract List<Customer> getCustomers();
	public abstract int addCustomer(Customer customer);
	public abstract boolean updateCustomer(Customer customer);
	public abstract int deleteCustomer(int id);
	public abstract Customer getCustomerByEmail(String email);
	public abstract Customer getCustomerByUsername(String username);
}
