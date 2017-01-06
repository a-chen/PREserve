package com.revature.data;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TableDAOImplTest {

    static AbstractApplicationContext context;

    @BeforeClass
    public static void getClassPathAP(){
        context = new ClassPathXmlApplicationContext("beans.xml");
    }

    @Test
    public void getAllTables() throws Exception {
        DataFacade facade = context.getBean("facade", DataFacade.class);
        System.out.println(facade.getAllTables());
    }

    @Test
    public void getTableById() {
        DataFacade facade = context.getBean("facade", DataFacade.class);
        System.out.println(facade.getTableById(1));
    }

    @AfterClass
    public static void endClassPathAP(){
        context.registerShutdownHook();
    }
}