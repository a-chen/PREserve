package com.revature.data;

import java.util.HashSet;

import com.revature.beans.Item;

public interface ItemDAO {
	
	HashSet<Item> getAll();
	
	Item getById(int id);
	
}
