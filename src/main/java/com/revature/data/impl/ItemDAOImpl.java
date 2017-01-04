package com.revature.data.impl;

import java.util.HashSet;

import com.revature.data.dao.ItemDAO;
import org.hibernate.Query;
import org.hibernate.Session;

import com.revature.beans.Item;
import com.revature.beans.ReservationTable;

public class ItemDAOImpl implements ItemDAO {

	private Session session;

	@Override
	public void setSession(Session session) {
		this.session = session;
	}

	@Override
	public HashSet<Item> getAllItems(){
        return new HashSet<>(session.createCriteria(Item.class).list());
	}

	@Override	
	public Item getItemById(int id) {
        return (Item) session.get(Item.class, id);
	}

}
