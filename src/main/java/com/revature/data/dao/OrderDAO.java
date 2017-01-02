package com.revature.data.dao;

import com.revature.beans.Order;
import org.hibernate.Session;

public interface OrderDAO {

    public void setSession(Session session);

    /**
     * This returns an order with provided id
     * @param id
     * @return order with specified id
     */
    Order getOrderById( int id );
}
