package com.revature.data.dao;

import com.revature.beans.Reservation;
import org.hibernate.Session;

import java.util.Date;
import java.util.HashSet;
import java.util.List;

public interface ReservationDAO {

    void setSession(Session session);

    /**
     * Returns a collection of Reservations belonging
     *  to a Customer ID
     * @param id
     * @return set of Reservations belonging to a customer
     */
    HashSet<Reservation> getByCustomerId(int id);

    /**
     * Returns a reservation with specified ID
     * @param id
     * @return Reservation obj with specified ID
     */
    Reservation getById(int id);

    /**
     * Creates a reservation
     * @param Reservation Object
     */
    void insert(Reservation reservation);

    /**
     * Updates a Reservation
     * @param Reservation Object
     */
    void update(Reservation reservation);

    /**
     * Deletes a reservation
     * @param reservation Object
     */
    void delete(Reservation reservation);

    public List<Reservation> getReservationsAfterTime(Date date);
}
