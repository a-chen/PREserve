package com.revature.data.dao;

import com.revature.beans.Customer;
import com.revature.beans.Order;
import com.revature.beans.Reservation;

import java.util.HashSet;

import org.hibernate.Session;

public interface OrderDAO {

    void setSession(Session session);

    /**
     * This returns an order with provided id
     * @param id
     * @return order with specified id
     */
    Order getById(int id );

    /**
     * This inserts an order with the provided order
     * @param order
     */
    void insert( Order order );

    void delete( Order order );

	HashSet<Order> getOrderByReservationId(int id);
}
