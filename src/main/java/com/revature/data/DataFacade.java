package com.revature.data;

import com.revature.beans.Customer;
import com.revature.beans.ReservationTable;
import org.springframework.context.ApplicationContext;

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
     * @return
     */
    Customer getCustomerByUsername( int id );
}
