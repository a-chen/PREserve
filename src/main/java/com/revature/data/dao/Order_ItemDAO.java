package com.revature.data.dao;

import java.util.HashSet;

import org.hibernate.Session;

import com.revature.beans.Order_Item;

public interface Order_ItemDAO {

	public void setSession(Session session);

	HashSet<Order_Item> getAll();
	
	HashSet<Order_Item> getByOrderID(int id);
	
	void delete(Order_Item order_item);
	
	void insert(Order_Item order_item);

	void update(Order_Item order_item);
	
}
