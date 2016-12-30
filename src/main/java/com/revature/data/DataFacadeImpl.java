package com.revature.data;

import com.revature.beans.ReservationTable;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.HashSet;

/**
 * This is the facade for the data tier.
 * All interactions with the database should occur through here.
 */
@Component(value = "facade")
public class DataFacadeImpl implements DataFacade, ApplicationContextAware {

    private SessionFactory sessionFactory;
    private ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {
        this.context = context;
    }

    public DataFacadeImpl() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    /**
     * This returns a collection of all tables
     * @return collection of all tables
     */
    public HashSet<ReservationTable> getAllTables() {
        Session session = sessionFactory.openSession();

        TableDAO dao = context.getBean("tableDAO", TableDAO.class);
        HashSet<ReservationTable> tables = dao.getAll();

        session.close();
        return tables;
    } // getAllTables

    /**
     * This returns a table with provided id
     * @param id
     * @return table with specified id
     */
    public ReservationTable getTableById(int id){
        Session session = sessionFactory.openSession();

        TableDAO dao = context.getBean("tableDAO", TableDAO.class);
        ReservationTable table = dao.getTableById(id);

        session.close();
        return table;
    } //getTableById


}
