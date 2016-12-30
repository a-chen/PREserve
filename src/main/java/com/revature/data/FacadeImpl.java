package com.revature.data;

/**
 * Created by bcant on 12/29/2016.
 */
public class FacadeImpl implements Facade {

    private CustomerDAO customerDAO;

    public FacadeImpl(){}

    public FacadeImpl(CustomerDAO customerDAO ){
        this.customerDAO = customerDAO;
    }
    public void setCustomerDAO( CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    public void getFullName(){
        customerDAO.getFullName();
    }
}
