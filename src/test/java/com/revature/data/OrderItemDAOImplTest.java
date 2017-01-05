package com.revature.data;

import com.revature.beans.Item;
import com.revature.beans.Order;
import com.revature.beans.OrderItem;
import com.revature.data.dao.OrderItemDAO;
import com.revature.data.impl.ItemDAOImpl;
import com.revature.data.impl.OrderDAOImpl;
import com.revature.data.impl.OrderItemDAOImpl;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class OrderItemDAOImplTest {
    static AbstractApplicationContext context;

    @BeforeClass
    public static void getClassPathAP(){
        context = new ClassPathXmlApplicationContext("beans.xml");
    }

    @Test
    public void getAllOrderItems() throws Exception {
        DataFacade facade = context.getBean("facade", DataFacade.class);
        System.out.println(facade.getAllorderItems());
    }

    @Test
    public void getOrderItemById() {
        DataFacade facade = context.getBean("facade", DataFacade.class);
        System.out.println(facade.getOrderItemById(1));
    }

    @Test
    public void getOrderItemByOrderId() {
        DataFacade facade = context.getBean("facade", DataFacade.class);
        System.out.println(facade.getorderItemByOrderId(1));
    }

    @Test
    public void insertOrderItem() {
        DataFacade facade = context.getBean("facade", DataFacade.class);

        Order order = facade.getOrderById(1);
        Item item = facade.getItemById(2);

        OrderItem orderItem = facade.getOrderItemById(1);
        facade.insertOrderItem(orderItem);
    }

    @Test
    public void deleteOrderItem() {
        DataFacade facade = context.getBean("facade", DataFacade.class);
        OrderItem orderItem = facade.getOrderItemById(2);
        facade.deleteOrderItem(orderItem);
    }

    @Test
    public void updateOrderItem() {
        DataFacade facade = context.getBean("facade", DataFacade.class);
        OrderItem orderItem = facade.getOrderItemById(1);
        orderItem.setItem(facade.getItemById(2));
        facade.updateOrderItem(orderItem);
    }

    @AfterClass
    public static void endClassPathAP(){
        context.registerShutdownHook();
    }
}
