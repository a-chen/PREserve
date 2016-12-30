package com.revature.data;

import com.revature.beans.ReservationTable;
import org.hibernate.Session;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import java.util.HashSet;

@Repository(value = "tableDAO")
@Scope(value = "prototype")
public class TableDAOImpl implements TableDAO {

    Session session;

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
