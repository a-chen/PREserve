package com.revature.data.impl;

import java.util.HashSet;

import com.revature.data.dao.ItemDAO;
import org.hibernate.Query;
import org.hibernate.Session;

import com.revature.beans.Item;

public class ItemDAOImpl implements ItemDAO {

	Session session = null;

	@Override
	public void setSession(Session session) {
		this.session = session;
	}
	
    public ItemDAOImpl(Session session) {
        this.session = session;
    }

    public ItemDAOImpl() {}

	public HashSet<Item> getAllItems(){
		Query query = session.createQuery("from com.revature.beans.Item");
		return new HashSet<Item>(query.list());
	}
		
	public Item getItemById(int id) {
		String HQL="FROM com.revature.beans.Item WHERE id = :pk";
		Query query = session.createQuery(HQL);
		query.setInteger("pk", id);
		
		Item item = (Item) query.uniqueResult();
		return item;
	}

}
