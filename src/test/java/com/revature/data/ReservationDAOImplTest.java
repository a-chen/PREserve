package com.revature.data;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ReservationDAOImplTest {
    static AbstractApplicationContext context;

    @BeforeClass
    public static void getClassPathAP(){
        context = new ClassPathXmlApplicationContext("beans.xml");
    }

    @Test
    public void getTableById() {
        DataFacade facade = context.getBean("facade", DataFacade.class);
        System.out.println(facade.getReservationById(1));
    }

    @AfterClass
    public static void endClassPathAP(){
        context.registerShutdownHook();
    }
}
