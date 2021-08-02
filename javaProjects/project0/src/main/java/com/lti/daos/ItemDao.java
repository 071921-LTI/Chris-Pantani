package com.lti.daos;

import java.util.List;
import com.lti.models.Item;

public interface ItemDao {
	public abstract Item getItemByID(int id);
	public abstract List<Item> getItems();
	public abstract int addItem(Item item);
	public abstract boolean updateItem(Item item);
	public abstract int deleteItem(int id);
}
