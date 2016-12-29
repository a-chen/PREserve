package com.revature.data;

import com.revature.beans.Tables;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.HashSet;
import java.util.List;

public class TableDAOImpl {

    Session session;

    public TableDAOImpl(Session session) {
        this.session = session;
    }

    public HashSet<Tables> getAll() {
        Query query = session.createQuery("from com.revature.beans.Tables");
        //returns list of results
        return (HashSet<Tables>) query.list();
    }
}
