package com.revature.data.dao;

import java.util.HashSet;

import com.revature.beans.OrderItem;
import org.hibernate.Session;

public interface OrderItemDAO {

	void setSession(Session session);

	HashSet<OrderItem> getAll();
	
	HashSet<OrderItem> getByOrderID(int id);
	
	void delete(OrderItem orderItem);
	
	void insert(OrderItem orderItem);

	void update(OrderItem orderItem);
	
}
