package com.revature.middle;

import com.revature.beans.Reservation;
import com.revature.data.DataFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class ReservationService {

    private DataFacade facade;
    @Autowired
    public void setFacade(DataFacade facade) {
        this.facade = facade;
    }

    HashSet<Reservation> getReservationByCustomerId(int id) {
        return facade.getReservationByCustomerId(id);
    }

    Reservation getReservationById(int id) {
        return facade.getReservationById(id);
    }

    void insertReservation(Reservation reservation) {
        facade.insertReservation(reservation);
    }

    void updateReservation(Reservation reservation) {
        facade.updateReservation(reservation);
    }

    void deleteReservation(Reservation reservation) {
        facade.deleteReservation(reservation);
    }

}
