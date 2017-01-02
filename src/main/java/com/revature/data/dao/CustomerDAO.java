package com.revature.data.dao;

import com.revature.beans.Customer;
import org.hibernate.Session;

public interface CustomerDAO {

    void setSession(Session session);

    /**
     * This returns a customer with provided id
     * @param id
     * @return table with specified id
     */
    Customer getCustomerById( int id );
}
