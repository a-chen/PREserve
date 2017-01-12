package com.revature.web;

import com.revature.beans.Item;
import com.revature.middle.Delegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;

@RestController    // infers @ResponseBody on all methods && @Controller
@CrossOrigin(origins = "*")
public class ItemController {

    private Delegate businessDelegate;

    @Autowired
    public void setBusinessDelegate(Delegate businessDelegate) {
        this.businessDelegate = businessDelegate;
    }

    @RequestMapping(value = "/items",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public HashSet<Item> getItems() {
        return businessDelegate.getAllItems();
    }

}
