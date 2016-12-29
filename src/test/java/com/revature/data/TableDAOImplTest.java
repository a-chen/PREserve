package com.revature.data;

import org.junit.Test;

public class TableDAOImplTest {

    @Test
    public void getAllTables() throws Exception {
        FacadeImpl facade = new FacadeImpl();
        System.out.println(facade.getAllTables());
    }

}