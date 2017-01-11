package com.revature.web;

import com.revature.beans.Customer;
import com.revature.beans.Reservation;
import com.revature.beans.ReservationTable;
import com.revature.middle.Delegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;

@Controller
public class ReservationController {

    private Delegate businessDelegate;

    @Autowired
    public void setBusinessDelegate(Delegate businessDelegate) {
        this.businessDelegate = businessDelegate;
    }

    @RequestMapping(value = "/reservation",
            method = RequestMethod.GET,
            produces = "application/json")
    @ResponseBody
    public HashSet<Reservation> getReservations(@RequestParam(value="q") int id) {return businessDelegate.getReservationByCustomerId(id);}

    @RequestMapping(value = "/reservation/getReservedTables",
            method = RequestMethod.POST,
            consumes = "application/json")
    public @ResponseBody HashSet<ReservationTable> getReservedTables(@RequestBody @Valid Reservation reservation){
        HashSet<ReservationTable> tables = businessDelegate.getReservedTables(reservation);
        return tables;
    }

    @RequestMapping(value = "/reservation/insert",
            method = RequestMethod.POST,
            consumes = "application/json")
    public @ResponseBody HttpEntity submitReservation(@RequestBody @Valid Reservation reservation,
                                                      BindingResult result){
        //System.out.println(reservation.getCustomer().getFirstName());
        if(result.hasErrors()){
            return new ResponseEntity("Failed", HttpStatus.BAD_REQUEST);
        }
         //businessDelegate.createReservation(reservation);
        return new ResponseEntity<Reservation>(reservation, HttpStatus.CREATED);
    }
}
