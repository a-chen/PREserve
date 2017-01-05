package com.revature.data;

import com.revature.beans.Customer;
import com.revature.beans.Order;
import com.revature.beans.Reservation;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class OrderDaoImplTest {
    @Test
    public void getOrderById() {
        AbstractApplicationContext context =
                new ClassPathXmlApplicationContext("beans.xml");

        DataFacade facade = context.getBean("facade", DataFacade.class);
        System.out.println(facade.getOrderById(1));
        context.registerShutdownHook();
    }

    @Test
    public void insert() {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        DataFacade facade = context.getBean("facade", DataFacade.class);

        Customer customer = facade.getCustomerById(1);
        Reservation reservation = facade.getReservationById(1);
        Order order = new Order(reservation, customer);

        facade.insertOrder(order);
        context.registerShutdownHook();
    }

    @Test
    public void delete() {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        DataFacade facade = context.getBean("facade", DataFacade.class);

        Order order = facade.getOrderById(1);
        facade.deleteOrder(order);

        context.registerShutdownHook();
    }
}
