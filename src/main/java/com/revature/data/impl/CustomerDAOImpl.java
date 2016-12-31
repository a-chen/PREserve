package com.revature.data.impl;

import com.revature.data.dao.CustomerDAO;

public class CustomerDAOImpl implements CustomerDAO {

    public CustomerDAOImpl(){}

    @Override
    public void getFullName() {
        System.out.println( "Getting customer's full name: Dan Pickles" );
    }
}
