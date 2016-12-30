package com.revature.data;

/**
 * Created by bcant on 12/29/2016.
 */
public class CustomerDAOImpl implements CustomerDAO{

    public CustomerDAOImpl(){}

    @Override
    public void getFullName() {
        System.out.println( "Getting customer's full name: Dan Pickles" );
    }
}
