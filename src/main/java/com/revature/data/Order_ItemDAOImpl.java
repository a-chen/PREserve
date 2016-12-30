package com.revature.data;

import java.util.HashSet;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.revature.beans.Item;
import com.revature.beans.Order_Item;

public class Order_ItemDAOImpl implements Order_ItemDAO{

    Session session = null;

    Order_ItemDAOImpl(Session session) {
        this.session = session;
    }

	public HashSet<Order_Item> getAll(){
		Query query = session.createQuery("from com.revature.beans.Order_Item");
		
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
