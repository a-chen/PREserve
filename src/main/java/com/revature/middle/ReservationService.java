package com.revature.middle;

import com.revature.beans.Reservation;
import com.revature.beans.ReservationTable;
import com.revature.data.DataFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
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

    public HashSet<ReservationTable> getAvailableTables(Reservation reservation){
        HashSet<ReservationTable> tables = facade.getAllTables();
        HashSet<ReservationTable> toRemove = new HashSet<ReservationTable>();
        for(ReservationTable temp : tables){
            if(reservation.getPatrons() > temp.getCapacity())
                toRemove.add(temp);
        }
        tables.removeAll(toRemove);
        System.out.println(toRemove);
        toRemove.clear();

        SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-DD hh:mm:ss");
        //Date date = format.parse(reservation.getDate());
        HashSet<Reservation> getReservationAfter = facade.getReservationsAfterTime(reservation.getDate());

        System.out.println("AFTER: " + getReservationAfter);
        for(Reservation temp : getReservationAfter){
            //System.out.println("reservation: " + reservation.getDate() + " TEMP: " + temp.getDate());
            if(reservation.getDate().equals(temp.getDate())){
                //System.out.println("in loop");
                toRemove.add(facade.getTableById(temp.getTable().getId()));
            }
        }
        System.out.println(toRemove);
        tables.removeAll(toRemove);
        //System.out.println(reservation.getDate());
       // System.out.println(getReservationAfter);
        return tables;
    }

}
