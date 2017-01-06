package com.revature.web;

import com.revature.beans.Customer;
import com.revature.beans.ReservationTable;
import com.revature.middle.Delegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashSet;

@Controller
public class CustomerController {

    private Delegate businessDelegate;

    @Autowired
    public void setBusinessDelegate(Delegate businessDelegate) {
        this.businessDelegate = businessDelegate;
    }

    @RequestMapping(value = "/customers",
            method = RequestMethod.GET,
            produces = "application/json")
    @ResponseBody
    public Customer getCustomer() {
        Customer customer = businessDelegate.getCustomerById(id);
        System.out.println(tables);
        return tables;
    }
}
