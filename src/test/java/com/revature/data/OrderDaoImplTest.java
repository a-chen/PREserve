package com.revature.data;

import com.revature.annotations.SpringAnnotationConfig;
import com.revature.beans.Customer;
import com.revature.beans.Order;
import com.revature.beans.Reservation;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class OrderDaoImplTest {
    @Test
    public void getOrderById() {
        AbstractApplicationContext context =
                new AnnotationConfigApplicationContext(SpringAnnotationConfig.class);

        DataFacade facade = context.getBean("facade", DataFacade.class);
        System.out.println(facade.getOrderById(1));
        context.registerShutdownHook();
    }
    @Test
    public void insert(){
        /*AbstractApplicationContext context = new AnnotationConfigApplicationContext(SpringAnnotationConfig.class);
        DataFacade facade = context.getBean("facade", DataFacade.class);

        Customer customer = facade.getCustomerById(1);
        Reservation reservation = facade.getReservationById();
        Order order = new Order( reservation, customer );

        facade.insertOrder( order );
        context.registerShutdownHook();*/
    }
}
