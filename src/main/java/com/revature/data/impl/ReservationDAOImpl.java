package com.revature.data.impl;

import com.revature.beans.Reservation;
import com.revature.data.dao.ReservationDAO;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.HashSet;

public class ReservationDAOImpl implements ReservationDAO {

    private Session session;

    @Override
    public void setSession(Session session) {
        this.session = session;
    }

    @Override
    public void createReservation(Reservation reservation) {
        session.save(reservation);
    }

    @Override
    public HashSet<Reservation> getReservationByCustomerId(int id) {
        String hql = "from Reservation where customer_id = :q";
        Query query = session.createQuery(hql);
        query.setInteger("q", id);
        return new HashSet<>(query.list());
    }

    @Override
    public Reservation getReservationById(int reservationId) {
        String hql = "from Reservation where id = :pk";
        Query query = session.createQuery(hql);
        query.setInteger("pk", reservationId);
        return (Reservation) query.uniqueResult();
    }

    @Override
    public void updateReservation(Reservation reservation) {
        session.saveOrUpdate(reservation);
    }

    @Override
    public void deleteReservation(Reservation reservation) {
        session.delete(reservation);
    }
}
