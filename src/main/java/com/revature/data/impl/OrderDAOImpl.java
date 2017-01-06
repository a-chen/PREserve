package com.revature.data.impl;

import com.revature.beans.Customer;
import com.revature.beans.Order;
import com.revature.beans.Reservation;
import com.revature.data.dao.OrderDAO;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

@Repository(value = "orderDAO")
public class OrderDAOImpl implements OrderDAO {

    private Session session;

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
    public Order getById(int id) {
        return (Order) session.get(Order.class, id);
    }

    /**
     * This inserts an order with the provided order
     * @param order
     */
    @Override
    public void insert( Order order ) { session.saveOrUpdate( order ); }

    @Override
    public void delete(Order order) { session.delete( order ); }
}
