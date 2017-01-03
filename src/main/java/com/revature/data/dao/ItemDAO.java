package com.revature.data.dao;

import java.util.HashSet;

import org.hibernate.Session;

import com.revature.beans.Item;

public interface ItemDAO {
	
	public void setSession(Session session);
	
	HashSet<Item> getAllItems();
	
	Item getItemById(int id);
	
}
