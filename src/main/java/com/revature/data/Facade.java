package com.revature.data;

import com.revature.beans.Tables;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.HashSet;

public class Facade {

    private SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public HashSet<Tables> getAllTables() {

        Session session = sessionFactory.openSession();
        TableDAOImpl dao = new TableDAOImpl(session);

        return dao.getAll();
    }

}
