package com.revature.data.dao;

import java.util.HashSet;

import com.revature.beans.Order_Item;

public interface Order_ItemDAO {

	HashSet<Order_Item> getAll();
	
	void delete(Order_Item order_item);
	
	void insert(Order_Item order_item);

	void update(Order_Item order_item);
}
