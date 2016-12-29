package com.revature.data;

import com.revature.beans.ReservationTable;

import java.util.HashSet;

public interface TableDAO {

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
    ReservationTable getTableById(int id);
}
