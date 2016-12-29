package com.revature.data;

import com.revature.beans.ReservationTable;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.HashSet;

/**
 * This is the facade for the data tier.
 * All interactions with the database should occur through here.
 */
public class FacadeImpl implements Facade {

    //creates a session factory
    private SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    /**
     * This returns a collection of all tables
     * @return collection of all tables
     */
    public HashSet<ReservationTable> getAllTables() {
        Session session = sessionFactory.openSession();

        TableDAO dao = new TableDAOImpl(session);

        session.close();
        return dao.getAll();
    } // getAllTables

    /**
     * This returns a table with provided id
     * @param id
     * @return table with specified id
     */
    public ReservationTable getTableById(int id){
        Session session = sessionFactory.openSession();

        TableDAO dao = new TableDAOImpl(session);

        session.close();
        return dao.getTableById(id);
    } //getTableById

}
