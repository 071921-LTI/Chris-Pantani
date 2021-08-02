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
import com.lti.models.Item;
import com.lti.uitl.ConnectionUtil;

public class ItemPostgres implements ItemDao{

	@Override
	public Item getItemByID(int id) {
		String sql = "select * from items where item_id = ?";
		Item item = null;
		try(Connection con = ConnectionUtil.getConnectionFromEnv()){
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id); //1 refers to the first ? to deal with
			
			ResultSet rs = ps.executeQuery();

			if(rs.next()) {
				int itemId = rs.getInt("item_id");
				String name = rs.getString("item_name");
				double priceOffered = rs.getDouble("price_offered");
				double paymentMade = rs.getDouble("payment_made");
				boolean offerPending = rs.getBoolean("offer_pending");
				String itemDescription = rs.getString("item_description");
				boolean itemSold = rs.getBoolean("item_sold");
				int empId = rs.getInt("employee");
				int cusId = rs.getInt("customer");

				
				item = new Item (itemId, name, priceOffered, paymentMade, offerPending, itemDescription, itemSold, new Employee(empId) ,new Customer(cusId));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return item;
	}

	@Override
	public List<Item> getItems() {
		List<Item> items = new ArrayList<>();
		
		try(Connection con = ConnectionUtil.getConnectionFromEnv()){
			String sql = "select * from items";
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()) {
				int itemId = rs.getInt("item_id");
				String name = rs.getString("item_name");
				double priceOffered = rs.getDouble("price_offered");
				double paymentMade = rs.getDouble("payment_made");
				boolean offerPending = rs.getBoolean("offer_pending");
				String itemDescription = rs.getString("item_description");
				boolean itemSold = rs.getBoolean("item_sold");
				int empId = rs.getInt("employee");
				int cusId = rs.getInt("customer");
				
				Item item = new Item (itemId, name, priceOffered, paymentMade, offerPending, itemDescription, itemSold, new Employee(empId) ,new Customer(cusId));
				items.add(item);
				}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return items;
	}
	
	public List<Item> getItemsCusView() {
		List<Item> cusItems = new ArrayList<>();
		
		try(Connection con = ConnectionUtil.getConnectionFromEnv()){
			String sql = "select item_id, item_name, item_description,item_sold from items where item_sold = false";
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()) {
				int itemId = rs.getInt("item_id");
				String name = rs.getString("item_name");
				String itemDescription = rs.getString("item_description");
				boolean itemSold = rs.getBoolean("item_sold");
				
				Item item = new Item (itemId, name, itemDescription, itemSold);
				cusItems.add(item);
				}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cusItems;
	}
	
	@Override
	public int addItem(Item item) {
		int id = -1;
		String sql = "insert into items (item_name, price_offered, payment_made, offer_pending, item_description, item_sold, employee, customer ) values (?,?,?,?,?,?,?,?) returning item_id;";
		
		try(Connection con = ConnectionUtil.getConnectionFromEnv()){
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, item.getName());
			ps.setDouble(2, item.getPriceOffered());
			ps.setDouble(3, item.getPaymentMade());
			ps.setBoolean(4, item.isOfferPending());
			ps.setString(5, item.getItemDescription());
			ps.setBoolean(6, item.isItemSold());
			ps.setInt(7, item.getEmployee().getId());
			ps.setInt(8, item.getCustomer().getId());
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				id = rs.getInt("item_id");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id;
	}
		
	@Override
	public boolean updateItem(Item item) {
		String sql = " update items set item_name = ?, price_offered = ?, payment_made = ?,  offer_pending = ?, item_description = ?, item_sold= ? , employee = ?, customer = ?  where item_id = ?";
		int rowsChanged = -1;
		
		try(Connection con = ConnectionUtil.getConnectionFromEnv()){
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, item.getName());
			ps.setDouble(2, item.getPriceOffered());
			ps.setDouble(3, item.getPaymentMade());
			ps.setBoolean(4, item.isOfferPending());
			ps.setString(5, item.getItemDescription());
			ps.setBoolean(6, item.isItemSold());
			ps.setInt(7, item.getEmployee().getId());
			ps.setInt(8, item.getCustomer().getId());
			ps.setInt(9, item.getId());
			
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
	public int deleteItem(int id) {
		String sql = "delete from items where item_id = ?;";
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

}
