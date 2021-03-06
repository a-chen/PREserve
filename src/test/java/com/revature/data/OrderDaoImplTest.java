package com.revature.data;

import com.revature.beans.Order;
import com.revature.beans.Reservation;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class OrderDaoImplTest {
    static AbstractApplicationContext context;

    @BeforeClass
    public static void getClassPathAP() {
        context = new ClassPathXmlApplicationContext("beans.xml");
    }

    @AfterClass
    public static void endClassPathAP() {
        context.registerShutdownHook();
    }

    @Test
    public void getOrderByReservationId() {
        DataFacade facade = context.getBean("facade", DataFacade.class);
        System.out.println(facade.getOrderByReservationId(1));
    }

    @Ignore
    @Test
    public void getOrderById() {
        DataFacade facade = context.getBean("facade", DataFacade.class);
        System.out.println(facade.getOrderById(1));
    }

    @Ignore
    @Test
    public void insert() {
        DataFacade facade = context.getBean("facade", DataFacade.class);

        Reservation reservation = facade.getReservationById(1);
        Order order = new Order(reservation);

        facade.insertOrder(order);
    }

    @Ignore
    @Test
    public void delete() {
        DataFacade facade = context.getBean("facade", DataFacade.class);

        Order order = facade.getOrderById(2);
        facade.deleteOrder(order);
    }
}
