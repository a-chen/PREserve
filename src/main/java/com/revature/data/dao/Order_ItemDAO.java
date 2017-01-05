package com.revature.data.dao;

import java.util.HashSet;

import com.revature.beans.OrderItem;
import org.hibernate.Session;

public interface Order_ItemDAO {

	void setSession(Session session);

	HashSet<OrderItem> getAll();
	
	HashSet<OrderItem> getByOrderID(int id);
	
	void delete(OrderItem order_item);
	
	void insert(OrderItem order_item);

	void update(OrderItem order_item);
	
}
