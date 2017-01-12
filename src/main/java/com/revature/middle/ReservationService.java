package com.revature.middle;

import com.revature.beans.Reservation;
import com.revature.beans.ReservationTable;
import com.revature.data.DataFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

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

    public HashSet<ReservationTable> getAvailableTables(Reservation reservation){
        HashSet<ReservationTable> tables = facade.getAllTables();
        List<ReservationTable> toRemove = new ArrayList<ReservationTable>();

        for(ReservationTable temp : tables){
            if(reservation.getPatrons() > temp.getCapacity())
                toRemove.add(temp);
        }

        tables.removeAll(toRemove);
        toRemove.clear();

        List<Reservation> getReservationAfter = facade.getReservationsAfterTime(reservation.getDate());

        for(Reservation temp : getReservationAfter){
            if( reservation.getDate().equals( temp.getDate() ) )
                for( ReservationTable temp2 : tables ) {
                    if(temp2.getId() == temp.getTable().getId())
                        toRemove.add(temp2);
                }
        }
        tables.removeAll(toRemove);
        return tables;
    }

}
