package com.lti.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.lti.models.Customer;
import com.lti.models.Employee;
import com.lti.uitl.ConnectionUtil;

public class CustomerPostgres implements CustomerDao {

	@Override
	public Customer getCustomerByID(int id) {
		String sql = "select * from customers where cus_id = ?";
		Customer cus = null;
		try(Connection con = ConnectionUtil.getConnectionFromEnv()){
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id); //1 refers to the first ? to deal with
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				int cusId = rs.getInt("cus_id");
				String first_name = rs.getString("cus_first_name");
				String last_name = rs.getString("cus_last_name");
				String username = rs.getString("cus_username");
				String password = rs.getString("cus_password");
				String email = rs.getString("cus_email");
				cus = new Customer(cusId, username, password ,first_name, last_name, email);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cus;
	}

	@Override
	public List<Customer> getCustomers() {
		List<Customer> customers = new ArrayList<>();
		
		try(Connection con = ConnectionUtil.getConnectionFromEnv()){
			String sql = "select * from customers";
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()) {
				int cusId = rs.getInt("cus_id");
				String first_name = rs.getString("cus_first_name");
				String last_name = rs.getString("cus_last_name");
				String username = rs.getString("cus_username");
				String password = rs.getString("cus_password");
				String email = rs.getString("cus_email");
				
				Customer customer = new Customer(cusId, username, password ,first_name, last_name, email);
				customers.add(customer);
				}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return customers;
	}

	@Override
	public int addCustomer(Customer customer) {
		int id = -1;
		String sql = "insert into customers (cus_username, cus_password, cus_first_name, cus_last_name, cus_email) values (?,?,?,?,?) returning cus_id;";
		
		try(Connection con = ConnectionUtil.getConnectionFromEnv()){
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, customer.getUsername());
			ps.setString(2, customer.getPassword());
			ps.setString(3, customer.getFirst_name());
			ps.setString(4, customer.getLast_name());
			ps.setString(5, customer.getEmail());
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				id = rs.getInt("cus_id");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id;
	}

	@Override
	public boolean updateCustomer(Customer customer) {
		String sql = " update customers set cus_username = ?, cus_password = ?, cus_first_name = ?, cus_last_name = ?, cus_email = ? where cus_id = ?";
		int rowsChanged = -1;
		
		try(Connection con = ConnectionUtil.getConnectionFromEnv()){
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, customer.getUsername());
			ps.setString(2, customer.getPassword());
			ps.setString(3, customer.getFirst_name());
			ps.setString(4, customer.getLast_name());
			ps.setString(5, customer.getEmail());
			
			rowsChanged = ps.executeUpdate();
;		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(rowsChanged >0) {
			return true;
		}
		return false;
	}
	@Override
	public int deleteCustomer(int id) {
		String sql = "delete from customers where cus_id = ?;";
		int rowsChanged = -1;
		
		try(Connection con = ConnectionUtil.getConnectionFromEnv()) {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			
			rowsChanged = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rowsChanged;	
	}

	@Override
	public Customer getCustomerByEmail(String email) {
		String sql = "select * from customers where cus_email = ?";
		Customer cus = null;
		try(Connection con = ConnectionUtil.getConnectionFromEnv()) {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, email);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				int cusId = rs.getInt("cus_id");
				String first_name = rs.getString("cus_first_name");
				String last_name = rs.getString("cus_last_name");
				String username = rs.getString("cus_username");
				String password = rs.getString("cus_password");
				String cus_email = rs.getString("cus_email");
				cus = new Customer(cusId, username, password ,first_name, last_name, cus_email);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cus;
	}

	@Override
	public Customer getCustomerByUsername(String username) {
		String sql = "select * from customers where cus_username = ?";
		Customer cus = null;
		try(Connection con = ConnectionUtil.getConnectionFromEnv()) {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, username);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				int cusId = rs.getInt("cus_id");
				String first_name = rs.getString("cus_first_name");
				String last_name = rs.getString("cus_last_name");
				String cusUsername = rs.getString("cus_username");
				String password = rs.getString("cus_password");
				String cus_email = rs.getString("cus_email");
				cus = new Customer(cusId, cusUsername, password ,first_name, last_name, cus_email);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cus;
	}
}
