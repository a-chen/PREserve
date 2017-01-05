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

	public HashSet<OrderItem> getByOrderID(int id){
		Criteria criteria = session.createCriteria(OrderItem.class);
		criteria.add(Restrictions.eq("order.id", id));

		return new HashSet<OrderItem>(criteria.list());
	}
	
	public void insert(OrderItem orderItem) {
		Transaction tx = session.beginTransaction();
		session.save(orderItem);
		tx.commit();
	}

	public void update(OrderItem orderItem) {
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(orderItem);
		tx.commit();
	}

	public void delete(OrderItem orderItem){
		Transaction tx = session.beginTransaction();
		session.delete(orderItem);
		tx.commit();
	}


}
