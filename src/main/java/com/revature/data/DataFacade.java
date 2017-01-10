package com.revature.data;

import com.revature.beans.*;

import java.util.HashSet;

public interface DataFacade {

//	Customer
    /**
     * This returns a customer with provided id
     * @param id
     * @return customer with specified id
     */
    Customer getCustomerById( int id );

//  Item
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

//	Order
    /**
     * This returns an order with provided id
     * @param id
     * @return order with specified id
     */
    Order getOrderById( int id );

	/**
	 * This inserts an order
	 * @param order
	 */
    void insertOrder( Order order );

	/**
	 * This deletes an order
	 * @param order
	 */
    void deleteOrder( Order order );

	HashSet<Order> getOrderByReservationId(int id);

//	OrderItem
	/**
	 * @return collection of all Order Items
	 */
	HashSet<OrderItem> getAllOrderItems();

	/**
	 * This method  Order Items  by id
	 * @param id
	 * @return
	 */
	OrderItem getOrderItemById(int id);
	/**
	 * This method returns a collection of Order Items 
	 *  with provided item order id 
	 * @param id
	 * @return
	 */
	HashSet<OrderItem> getOrderItemByOrderId(int id);

	/**
	 * This method insert an orderItem
	 * @param orderItem
	 */
	void insertOrderItem(OrderItem orderItem);

	/**
	 * This method updates an orderItem
	 * @param orderItem
	 */
	void updateOrderItem(OrderItem orderItem);

	/**
	 * This method deletes an orderItem
	 * @param orderItem
	 */
	void deleteOrderItem( OrderItem orderItem );

//	Reservation
	/**
	 * Returns a collection of Reservations belonging
	 *  to a Customer ID
	 * @param id
	 * @return set of Reservations belonging to a customer
	 */
	HashSet<Reservation> getReservationByCustomerId(int id);

	/**
	 * Returns a reservation with specified ID
	 * @param id
	 * @return Reservation obj with specified ID
	 */
	Reservation getReservationById(int id);

	void insertReservation(Reservation reservation);

	/**
	 * Updates a Reservation
	 * @param Reservation Object
	 */
	void updateReservation(Reservation reservation);

	/**
	 * Deletes a reservatoin
	 * @param Reservation Object
	 */
	void deleteReservation(Reservation reservation);

//	Table
	/**
	 * This returns a collection of all tables
	 *
	 * @return collection of all tables
	 */
	HashSet<ReservationTable> getAllTables();

	/**
	 * This returns a table with provided id
	 *
	 * @param id
	 * @return table with specified id
	 */
	ReservationTable getTableById(int id);

}
