package com.revature.data.impl;

import com.revature.beans.Order;
import com.revature.data.dao.OrderDAO;
import org.hibernate.Session;

public class OrderDAOImpl implements OrderDAO {

    Session session;

    @Override
    public void setSession(Session session) {
        this.session = session;
    }

    /**
     * This returns a order with provided id
     * @param id
     * @return order with specified id
     */
    @Override
    public Order getOrderById(int id) {
        return (Order) session.get(Order.class, id);
    }
}
