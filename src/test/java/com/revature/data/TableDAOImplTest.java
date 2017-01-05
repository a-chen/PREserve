package com.revature.data;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TableDAOImplTest {

 /*   @Before
    public void runBeforeMethod*/

    @Test
    public void getAllTables() throws Exception {
        AbstractApplicationContext context =
                new ClassPathXmlApplicationContext("beans.xml");

        DataFacade facade = context.getBean("facade", DataFacade.class);
        System.out.println(facade.getAllTables());
        context.registerShutdownHook();
    }

    @Test
    public void getTableById() {
        AbstractApplicationContext context =
                new ClassPathXmlApplicationContext("beans.xml");

        DataFacade facade = context.getBean("facade", DataFacade.class);
        System.out.println(facade.getTableById(1));
        context.registerShutdownHook();
    }
}