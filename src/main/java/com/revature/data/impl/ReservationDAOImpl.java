package com.revature.data.impl;

import com.revature.beans.Reservation;
import com.revature.data.dao.ReservationDAO;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.HashSet;

@Repository(value = "reservationDAO")
public class ReservationDAOImpl implements ReservationDAO {

    private Session session;

    @Override
    public void setSession(Session session) {
        this.session = session;
    }

    @Override
    public void insert(Reservation reservation) {
        session.save(reservation);
    }

    @Override
    public HashSet<Reservation> getByCustomerId(int id) {
        String hql = "from Reservation where customer.id = :q";
        Query query = session.createQuery(hql);
        query.setInteger("q", id);
        return new HashSet<>(query.list());
    }

    @Override
    public Reservation getById(int reservationId) {
        String hql = "from Reservation where id = :pk";
        Query query = session.createQuery(hql);
        query.setInteger("pk", reservationId);
        return (Reservation) query.uniqueResult();
    }

    @Override
    public void update(Reservation reservation) {
        session.saveOrUpdate(reservation);
    }

    @Override
    public void delete(Reservation reservation) {
        if(reservation != null)
            session.delete(reservation);
    }

    @Override
    public HashSet<Reservation> getReservationsAfterTime(Date date) {
        String hql = "from Reservation where date >= :t";
        Query query = session.createQuery(hql);
        query.setTimestamp("t", date);
        return new HashSet<>(query.list());
    }
}
