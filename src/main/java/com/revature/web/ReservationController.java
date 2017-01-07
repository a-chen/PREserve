package com.revature.web;

import com.revature.beans.Reservation;
import com.revature.middle.Delegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
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
    public HashSet<Reservation> getReservations(@RequestParam(value="q") int id) {
        HashSet<Reservation> reservations = businessDelegate.getReservationByCustomerId(id);
        System.out.println(reservations);
        return reservations;
        }

/*    @RequestMapping(value = "/reservation",
            method = RequestMethod.POST,
            consumes = "application/json")
    public ResponseEntity submitReservation(@RequestBody @Valid Reservation reservation,
                                            BindingResult result){
        System.out.println("in reservation method");
         //businessDelegate.createReservation(reservation);
        return new ResponseEntity(HttpStatus.CREATED);
    }*/
}
