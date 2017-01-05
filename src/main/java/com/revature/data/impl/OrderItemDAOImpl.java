package com.revature.data.impl;

import java.util.HashSet;

import com.revature.beans.OrderItem;
import com.revature.data.dao.Order_ItemDAO;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.beans.Item;
import com.revature.beans.OrderItem;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository(value = "orderItemDAO")
public class OrderItemDAOImpl implements Order_ItemDAO {

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
	
	public void insert(OrderItem order_item) {
		Transaction tx = session.beginTransaction();
		session.save(order_item);
		tx.commit();
	}

	public void update(OrderItem order_item) {
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(order_item);
		tx.commit();
	}

	public void delete(OrderItem order_item){
		Transaction tx = session.beginTransaction();
		session.delete(order_item);
		tx.commit();
	}


}
