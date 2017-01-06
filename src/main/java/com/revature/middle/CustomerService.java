package com.revature.middle;

import com.revature.beans.Customer;
import com.revature.data.DataFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private DataFacade facade;
    @Autowired
    public void setFacade(DataFacade facade) {
        this.facade = facade;
    }

    Customer getCustomerById(int id ) {
        return facade.getCustomerById(id);
    }

}
