package com.revature.data;

import com.revature.annotations.SpringAnnotationConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

/**
 * Created by bcant on 1/2/2017.
 */
public class OrderDaoImplTest {
    @Test
    public void getOrderById() {
        AbstractApplicationContext context =
                new AnnotationConfigApplicationContext(SpringAnnotationConfig.class);

        DataFacade facade = context.getBean("facade", DataFacade.class);
        System.out.println(facade.getOrderById(1));
        context.registerShutdownHook();
    }
}
