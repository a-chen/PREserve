package com.revature.data;

import com.revature.beans.Customer;
import com.revature.beans.Item;
import com.revature.beans.Order;
import com.revature.beans.Order_Item;
import com.revature.beans.ReservationTable;

import java.util.HashSet;

public interface DataFacade {

    /**
     * This returns a collection of all tables
     *
     * @return collection of all tables
     */
    public HashSet<ReservationTable> getAllTables();

    /**
     * This returns a table with provided id
     *
     * @param id
     * @return table with specified id
     */
    public ReservationTable getTableById(int id);

    /**
     * This returns a customer with provided username
     * @param id
     * @return customer with specified id
     */
    Customer getCustomerById( int id );

    /**
     * This returns an order with provided username
     * @param id
     * @return order with specified id
     */
    Order getOrderById( int id );

	/** 
	 * @return collection of all items
	 */
	HashSet<Item> getAllItems();
	
    /**
     * This method returns an Item with provided item id
     * @param id
     * @return
     */
	Item getItemById(int id);
	
	/**
	 * @return collection of all Order Items
	 */
	HashSet<Order_Item> getAllOrder_Items();
	
	/**
	 * This method returns a collection of Order Items 
	 *  with provided item order id 
	 * @param id
	 * @return
	 */
	HashSet<Order_Item> getOrder_ItemByOrderId(int id);
}
