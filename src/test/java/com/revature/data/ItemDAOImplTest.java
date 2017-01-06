package com.revature.data;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ItemDAOImplTest {
    static AbstractApplicationContext context;

    @BeforeClass
    public static void getClassPathAP(){
        context = new ClassPathXmlApplicationContext("beans.xml");
    }

    @Test
    public void getAllItems() throws Exception {
        DataFacade facade = context.getBean("facade", DataFacade.class);
        System.out.println(facade.getAllItems());
    }

    @Test
    public void getItemById() {
        DataFacade facade = context.getBean("facade", DataFacade.class);
        System.out.println(facade.getItemById(1));
    }
    @AfterClass
    public static void endClassPathAP(){
        context.registerShutdownHook();
    }

}
