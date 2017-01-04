package com.revature.data.impl;

import java.util.HashSet;

import com.revature.data.dao.Order_ItemDAO;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.beans.Item;
import com.revature.beans.Order_Item;

public class Order_ItemDAOImpl implements Order_ItemDAO {

    private Session session;

	@Override
	public void setSession(Session session) {
		this.session = session;
	}

	public HashSet<Order_Item> getAll(){
        return new HashSet<>(session.createCriteria(Order_Item.class).list());
	}
	
	public HashSet<Order_Item> getByOrderID(int id){
		String HQL = "select"
					+ " order_item.orders_id, order_item.item_id, order_item.quantity"
					+ " from com.revature.beans.Order_Item"
						+ " left join orders"
						+ " on order_item.orders_id = orders.id"
					+ " where orders.id= :order_id";
		Query query = session.createQuery(HQL);
		query.setInteger("order_id", id);
		
		return new HashSet<Order_Item>(query.list());
	}
	
	public void insert(Order_Item order_item) {
		Transaction tx = session.beginTransaction();
		session.save(order_item);
		tx.commit();
	}

	public void update(Order_Item order_item) {
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(order_item);
		tx.commit();
	}

	public void delete(Order_Item order_item){
		Transaction tx = session.beginTransaction();
		session.delete(order_item);
		tx.commit();
	}


}
