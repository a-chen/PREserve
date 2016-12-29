package com.revature.data;

/**
 * Created by bcant on 12/29/2016.
 */
public class Facade {

    private CustomerDAO customerDAO;

    public Facade(){}

    public Facade( CustomerDAO customerDAO ){
        this.customerDAO = customerDAO;
    }
    public void setCustomerDAO( CustomerDAO customerDAO) {
        System.out.println("Facade setting customerDAO");
        this.customerDAO = customerDAO;
    }

    public void getFullName(){
        customerDAO.getFullName();
    }
}
