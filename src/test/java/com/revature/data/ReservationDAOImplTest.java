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
       // long time = 1485788400000;
        //System.out.println(date.getTime());
        Reservation reservation = new Reservation(new java.sql.Timestamp(1485788400000L), facade.getTableById(3), facade.getCustomerById(1), 6);
        facade.insertReservation(reservation);
        //1485788400000L
        //'2017-01-10 05:41:59'
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

    @Test
    public void getReservationAfterTime(){
        DataFacade facade = context.getBean("facade", DataFacade.class);
        Date date = new Date(1485788400000L);
        System.out.println(facade.getReservationsAfterTime(date));
    }

    @AfterClass
    public static void endClassPathAP(){
        context.registerShutdownHook();
    }
}
