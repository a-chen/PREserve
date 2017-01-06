package com.revature.data;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CustomerDAOImplTest {
    static AbstractApplicationContext context;

    @BeforeClass
    public static void getClassPathAP(){
        context = new ClassPathXmlApplicationContext("beans.xml");
    }

    @Test
    public void getCustomerById() {
        DataFacade facade = context.getBean("facade", DataFacade.class);
        System.out.println(facade.getCustomerById(1));
    }

    @AfterClass
    public static void endClassPathAP(){
        context.registerShutdownHook();
    }
}
