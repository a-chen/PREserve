package com.revature.data.dao;

import com.revature.beans.Reservation;
import org.hibernate.Session;

import java.util.HashSet;

public interface ReservationDAO {

    void setSession(Session session);

    /**
     * Creates a reservation
     * @param Reservation Object
     */
    void createReservation(Reservation reservation);

    /**
     * Returns a collection of Reservations belonging
     *  to a Customer ID
     * @param id
     * @return set of Reservations belonging to a customer
     */
    HashSet<Reservation> getReservationByCustomerId(int id);

    /**
     * Returns a reservation with specified ID
     * @param id
     * @return Reservation obj with specified ID
     */
    Reservation getReservationById(int id);

    /**
     * Updates a Reservation
     * @param Reservation Object
     */
    void updateReservation(Reservation reservation);

    /**
     * Deletes a reservatoin
     * @param Reservation Object
     */
    void deleteReservation(Reservation reservation);


}
