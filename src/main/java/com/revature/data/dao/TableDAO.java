package com.revature.data.dao;

import com.revature.beans.ReservationTable;
import org.hibernate.Session;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import java.util.HashSet;

public interface TableDAO {

    void setSession(Session session);

    /**
     * This returns a set of all tables
     * @return set of all tables
     */
    HashSet<ReservationTable> getAll();

    /**
     * This returns a table with provided id
     * @param id
     * @return table with specified id
     */
    ReservationTable getById(int id);
}
