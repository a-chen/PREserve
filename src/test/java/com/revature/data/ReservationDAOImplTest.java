package com.revature.data;

import com.revature.beans.Reservation;
import com.revature.beans.ReservationTable;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

public class ReservationDAOImplTest {
    static AbstractApplicationContext context;

    @BeforeClass
    public static void getClassPathAP(){
        context = new ClassPathXmlApplicationContext("beans.xml");
    }

    @Test
    public void insertReservation(){
        Date date = new Date();
        DataFacade facade = context.getBean("facade", DataFacade.class);

        Reservation reservation = new Reservation(new java.sql.Timestamp(date.getTime()), facade.getTableById(2), facade.getCustomerById(1));
        facade.insertReservation(reservation);
    }

    @Test
    public void getReservationById() {
        DataFacade facade = context.getBean("facade", DataFacade.class);
        System.out.println(facade.getReservationById(1));
    }

    @Test
    public void getReservationByCustomerId() {
        DataFacade facade = context.getBean("facade", DataFacade.class);
        System.out.println(facade.getReservationByCustomerId(1));
    }

    @Test
    public void updateReservation() {
        DataFacade facade = context.getBean("facade", DataFacade.class);

        Reservation reservation = facade.getReservationById(1);
        reservation.setTable(facade.getTableById(4));
        facade.updateReservation(reservation);
    }

    @Test
    public void deleteReservation() {
        DataFacade facade = context.getBean("facade", DataFacade.class);
        facade.deleteReservation(facade.getReservationById(2));
    }

    @AfterClass
    public static void endClassPathAP(){
        context.registerShutdownHook();
    }
}
