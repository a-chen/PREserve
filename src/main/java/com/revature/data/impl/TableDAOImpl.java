package com.revature.data.impl;

import com.revature.beans.ReservationTable;
import com.revature.data.dao.TableDAO;
import org.hibernate.Session;

import java.util.HashSet;

public class TableDAOImpl implements TableDAO {

    Session session;

    @Override
    public void setSession(Session session) {
        this.session = session;
    }

    /**
     * This returns a set of all tables
     *
     * @return set of all tables
     */
    @Override
    public HashSet<ReservationTable> getAll() {
        return new HashSet<>(session.createCriteria(ReservationTable.class).list());
    }

    /**
     * This returns a table with provided id
     *
     * @param id
     * @return table with specified id
     */
    @Override
    public ReservationTable getTableById(int id) {
        return (ReservationTable) session.get(ReservationTable.class, id);
    }
}
