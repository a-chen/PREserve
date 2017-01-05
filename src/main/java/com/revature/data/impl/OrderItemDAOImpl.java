package com.revature.data.impl;

import java.util.HashSet;

import com.revature.beans.OrderItem;
import com.revature.data.dao.OrderItemDAO;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository(value = "orderItemDAO")
public class OrderItemDAOImpl implements OrderItemDAO {

    private Session session;

	@Override
	public void setSession(Session session) {
		this.session = session;
	}

	public HashSet<OrderItem> getAll(){
        return new HashSet<>(session.createCriteria(OrderItem.class).list());
	}

	@Override
	public OrderItem getByOrderItemId(int id) {
		return (OrderItem) session.get(OrderItem.class, id);
	}

	public HashSet<OrderItem> getByOrderID(int id){
		Criteria criteria = session.createCriteria(OrderItem.class);
		criteria.add(Restrictions.eq("order.id", id));

		return new HashSet<OrderItem>(criteria.list());
	}

	public void delete(OrderItem orderItem){
		session.delete(orderItem);
	}

	public void insert(OrderItem orderItem) {
		session.save(orderItem);
	}

	public void update(OrderItem orderItem) {
		session.saveOrUpdate(orderItem);
	}

}
