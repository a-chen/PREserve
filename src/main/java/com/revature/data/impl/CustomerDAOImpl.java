package com.revature.data.impl;

import com.revature.beans.Customer;
import com.revature.data.dao.CustomerDAO;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

@Repository(value = "customerDAO")
public class CustomerDAOImpl implements CustomerDAO {
    private Session session;

    @Override
    public void setSession(Session session) {
        this.session = session;
    }

    public CustomerDAOImpl(){}

    @Override
    public Customer getById(int id ) {
        return (Customer) session.get(Customer.class, id);
    }
}
