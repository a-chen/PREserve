package com.revature.data.dao;

import java.util.HashSet;

import com.revature.beans.OrderItem;
import org.hibernate.Session;

public interface OrderItemDAO {

	void setSession(Session session);

	HashSet<OrderItem> getAll();

	OrderItem getByOrderItemId(int id);

	HashSet<OrderItem> getByOrderID(int id);

	void insert(OrderItem orderItem);

	void update(OrderItem orderItem);

	void delete(OrderItem orderItem);
}
