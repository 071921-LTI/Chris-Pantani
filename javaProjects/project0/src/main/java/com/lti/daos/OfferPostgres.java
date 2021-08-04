package com.lti.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.lti.models.Customer;
import com.lti.models.Item;
import com.lti.models.Offer;
import com.lti.uitl.ConnectionUtil;

public class OfferPostgres implements OfferDao {

	@Override
	public Offer getOfferByID(int id) {
		String sql = "select * from offers where offer_id = ?";
		Offer offer = null;
		try(Connection con = ConnectionUtil.getConnectionFromEnv()){
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				int offerId = rs.getInt("offer_id");
				int itemId = rs.getInt("item");
				int customerId = rs.getInt("customer");
				double priceOffered = rs.getDouble("price_offered");
				
				offer = new Offer ( offerId, new Item (itemId) , new Customer(customerId) ,priceOffered);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return offer;
	}

	@Override
	public List<Offer> getOfferes() {
		List<Offer> offers = new ArrayList<>();
		
		try(Connection con = ConnectionUtil.getConnectionFromEnv()){
			String sql = "select * from offers";
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()) {
				int offerId = rs.getInt("offer_id");
				int itemId = rs.getInt("item");
				int customerId = rs.getInt("customer");
				double priceOffered = rs.getDouble("price_offered");
				
				Offer offer = new Offer ( offerId, new Item (itemId) , new Customer(customerId) ,priceOffered);
				offers.add(offer);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return offers;
	}
	
	@Override
	public List<Offer> getOffersItems() {
		List<Offer> offers = new ArrayList<>();
		
		try(Connection con = ConnectionUtil.getConnectionFromEnv()){
			String sql = "select * from offers join item";
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()) {
				int offerId = rs.getInt("offer_id");
				int itemId = rs.getInt("item");
				int customerId = rs.getInt("customer");
				double priceOffered = rs.getDouble("price_offered");
				
				Offer offer = new Offer ( offerId, new Item (itemId) , new Customer(customerId) ,priceOffered);
				offers.add(offer);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return offers;
	}


	@Override
	public int addOffer(Offer offer) {
		int id = -1;
		String sql = "insert into offers(item, customer, price_offered) values (?,?,?) returning offer_id;"; 
		
		try(Connection con = ConnectionUtil.getConnectionFromEnv()){
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, offer.getItem().getId());
			ps.setInt(2,  offer.getCustomer().getId());
			ps.setDouble(3, offer.getPrice_offered());
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next());{
				id = rs.getInt("offer_id");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id;
		
	}

	@Override
	public boolean updateOffer(Offer offer) {
		String sql = "update offers set item = ?, customer = ?, price_offered = ? where item_id = ?";
		int rowsChanged = -1;
		
		try(Connection con = ConnectionUtil.getConnectionFromEnv()){
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, offer.getItem().getId());
			ps.setInt(2,  offer.getCustomer().getId());
			ps.setDouble(3, offer.getPrice_offered());
			ps.setInt(4, offer.getId());
			
			rowsChanged = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(rowsChanged >0) {
			return true;
		}
		return false;
	}
	
	@Override
	public int deleteOffer(int id) {
		String sql = "delete from offers where offer_id = ?;";
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
	public int deleteOfferByItem(int id) {
		String sql = "delete from offers where item = ?;";
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
	public Offer getOfferByItem(int item_id) {
		String sql = "select * from offers where item = ?";
		Offer offer = null;
		try(Connection con = ConnectionUtil.getConnectionFromEnv()){
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, item_id);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				int offerId = rs.getInt("offer_id");
				int itemId = rs.getInt("item");
				int customerId = rs.getInt("customer");
				double priceOffered = rs.getDouble("price_offered");
				
				offer = new Offer ( offerId, new Item (itemId) , new Customer(customerId) ,priceOffered);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return offer;
	}

	@Override
	public Offer getOfferByCustomer(int cus_id) {
		String sql = "select * from offers where item = ?";
		Offer offer = null;
		try(Connection con = ConnectionUtil.getConnectionFromEnv()){
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, cus_id);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				int offerId = rs.getInt("offer_id");
				int itemId = rs.getInt("item");
				int customerId = rs.getInt("customer");
				double priceOffered = rs.getDouble("price_offered");
				
				offer = new Offer ( offerId, new Item (itemId) , new Customer(customerId) ,priceOffered);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return offer;
	}


}
