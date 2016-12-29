package com.revature.data;

import com.revature.beans.ReservationTable;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.HashSet;

public class TableDAOImpl implements TableDAO{

    Session session = null;

    TableDAOImpl(Session session) {
        this.session = session;
    }

    /**
     * This returns a set of all tables
     * @return set of all tables
     */
    @Override
    public HashSet<ReservationTable> getAll() {
        Query query = session.createQuery("from com.revature.beans.ReservationTable");
        //returns list of results
        return new HashSet<>(query.list());
    }

    /**
     * This returns a table with provided id
     * @param id
     * @return table with specified id
     */
    @Override
    public ReservationTable getTableById(int id) {
        //TODO finish method body
        return null;
    }
}
