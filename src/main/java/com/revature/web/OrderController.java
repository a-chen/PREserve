package com.revature.web;

import com.revature.beans.Order;
import com.revature.middle.Delegate;

import java.util.HashSet;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class OrderController {

    private Delegate businessDelegate;
    @Autowired
    public void setBusinessDelegate(Delegate businessDelegate) {
        this.businessDelegate = businessDelegate;
    }

    @RequestMapping(value = "/order",
            method = RequestMethod.GET,
            produces = "application/json")
    @ResponseBody
    public HashSet<Order> getOrder(@RequestParam(value="q") int id) {
    	return businessDelegate.getOrderByReservationId(id);
    }

    @RequestMapping(value = "/order/insert",
            method = RequestMethod.POST,
            consumes = "application/json")
    public @ResponseBody HttpEntity submitReservation(@RequestBody @Valid Order order,
                                            BindingResult result){
//        System.out.println(order.getCustomer().getFirstName());
        if(result.hasErrors()){
            return new ResponseEntity("Failed", HttpStatus.BAD_REQUEST);
        }
         //businessDelegate.createReservation(reservation);
        return new ResponseEntity<Order>(order, HttpStatus.CREATED);
    }
}
