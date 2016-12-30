package com.revature.data;

import java.util.HashSet;

import org.hibernate.Query;
import org.hibernate.Session;

import com.revature.beans.Item;

public class ItemDAOImpl implements ItemDAO{

	Session session = null;

    ItemDAOImpl(Session session) {
        this.session = session;
    }

	public HashSet<Item> getAll(){
		Query query = session.createQuery("from com.revature.beans.Item");
		return new HashSet<Item>(query.list());
	}
		
	public Item getById(int id) {
		String HQL="FROM com.revature.beans.Item WHERE id = :pk";
		Query query = session.createQuery(HQL);
		query.setInteger("pk", id);
		
		Item item = (Item) query.uniqueResult();
		return item;
	}
}
