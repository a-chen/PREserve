package com.revature.web;

import com.revature.beans.Customer;
import com.revature.middle.Delegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@SessionAttributes("customer")
public class CustomerController {

    private Delegate businessDelegate;

    @Autowired
    public void setBusinessDelegate(Delegate businessDelegate) {
        this.businessDelegate = businessDelegate;
    }

    @RequestMapping(value = "/customer",
            method = RequestMethod.GET,
            produces = "application/json")
    @ResponseBody
    public ResponseEntity getCustomer(@RequestParam(value="q") int id) {
        return new ResponseEntity<Customer>(businessDelegate.getCustomerById(id), HttpStatus.OK);
    }
}
