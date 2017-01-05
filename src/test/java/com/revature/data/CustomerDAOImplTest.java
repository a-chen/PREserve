package com.revature.data;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CustomerDAOImplTest {
    @Test
    public void getCustomerById() {
        AbstractApplicationContext context =
                new ClassPathXmlApplicationContext("beans.xml");

        DataFacade facade = context.getBean("facade", DataFacade.class);
        System.out.println(facade.getCustomerById(1));
        context.registerShutdownHook();
    }
}
