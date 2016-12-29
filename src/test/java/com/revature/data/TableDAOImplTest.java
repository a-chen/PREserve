package com.revature.data;

import org.junit.Test;

public class TableDAOImplTest {

    @Test
    public void getAll() throws Exception {
        Facade facade = new Facade();
        System.out.println(facade.getAllTables());
    }

}