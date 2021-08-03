package com.lti.daos;

import java.util.List;

import com.lti.models.Customer;
import com.lti.models.Item;

public interface ItemDao {
	public abstract Item getItemByID(int id);
	public abstract Item getItemByCustomerId(int id);
	public abstract List<Item> getItems();
	public abstract List<Item> getItemsCusView();
	public abstract List<Item> ownedItems(Customer cus);
	public abstract List<Item> paymentsItem(Customer cus);
	public abstract List<Item> soldItems();
	public abstract int addItem(Item item);
	public abstract boolean updateItem(Item item);
	public abstract int deleteItem(int id);

}
