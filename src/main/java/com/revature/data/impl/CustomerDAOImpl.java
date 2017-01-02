package com.revature.data.impl;

import com.revature.beans.Customer;
import com.revature.data.dao.CustomerDAO;
import org.hibernate.Session;

public class CustomerDAOImpl implements CustomerDAO {
    Session session;

    @Override
    public void setSession(Session session) {
        this.session = session;
    }

    public CustomerDAOImpl(){}

    @Override
    public Customer getCustomerByUsername( int id ) { return (Customer) session.get(Customer.class, id); }
}
