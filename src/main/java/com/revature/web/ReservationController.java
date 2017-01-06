package com.revature.web;

import com.revature.middle.Delegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ReservationController {

    private Delegate businessDelegate;
    @Autowired
    public void setBusinessDelegate(Delegate businessDelegate) {
        this.businessDelegate = businessDelegate;
    }

    @RequestMapping(value = "/reservation/{id}",
            method = RequestMethod.GET,
            produces = "application/JSON")
    public String submitReservation(@PathVariable int id){
        return new Delegate();
    }

}
