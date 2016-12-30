package com.revature.data;

import org.junit.Test;

public class TableDAOImplTest {

    @Test
    public void getAllTables() throws Exception {
        DataFacadeImpl facade = new DataFacadeImpl();
        System.out.println(facade.getAllTables());
    }

}