package com.revature.data.impl;

import com.revature.beans.Customer;
import com.revature.beans.Order;
import com.revature.beans.Reservation;
import com.revature.data.dao.OrderDAO;
import org.hibernate.Session;

public class OrderDAOImpl implements OrderDAO {

    Session session;

    @Override
    public void setSession(Session session) {
        this.session = session;
    }

    /**
     * This returns an order with provided id
     * @param id
     * @return order with specified id
     */
    @Override
    public Order getOrderById(int id) {
        return (Order) session.get(Order.class, id);
    }

    /**
     * This inserts an order with the provided order
     * @param order
     */
    @Override
    public void insert( Order order ) { session.saveOrUpdate( order ); }
}
