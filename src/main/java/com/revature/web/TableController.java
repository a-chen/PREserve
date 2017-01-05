package com.revature.web;

import com.revature.beans.ReservationTable;
import com.revature.middle.Delegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashSet;

@Controller
public class TableController {

    private Delegate businessDelegate;
    @Autowired
    public void setBusinessDelegate(Delegate businessDelegate) {
        this.businessDelegate = businessDelegate;
    }

    @RequestMapping(value = "/tables",
            method = RequestMethod.GET,
            produces = "application/json")
    @ResponseBody
    public HashSet<ReservationTable> getAll() {
        HashSet<ReservationTable> tables = businessDelegate.getAllTables();
        System.out.println(tables);
        return tables;
    }

    @RequestMapping("/helloWorld")
    public void helloWorld() {
        System.out.println("Hello World");
    }

}
