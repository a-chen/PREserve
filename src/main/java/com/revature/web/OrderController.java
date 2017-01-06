package com.revature.web;

import com.revature.middle.Delegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class OrderController {

    private Delegate businessDelegate;
    @Autowired
    public void setBusinessDelegate(Delegate businessDelegate) {
        this.businessDelegate = businessDelegate;
    }
    
    @RequestMapping(value = "/order",
            method = RequestMethod.POST,
            produces = "application/JSON",
            consumes = "application/json")
    public void submitReservation(){
        System.out.println("in order method");
    }

}
