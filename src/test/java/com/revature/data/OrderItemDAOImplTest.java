package com.revature.data;

import com.revature.beans.Item;
import com.revature.beans.Order;
import com.revature.beans.OrderItem;
import com.revature.data.dao.OrderItemDAO;
import com.revature.data.impl.ItemDAOImpl;
import com.revature.data.impl.OrderDAOImpl;
import com.revature.data.impl.OrderItemDAOImpl;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class OrderItemDAOImplTest {

    @Test
    public void getAllOrderItems() throws Exception {
        AbstractApplicationContext context =
                new ClassPathXmlApplicationContext("beans.xml");

        DataFacade facade = context.getBean("facade", DataFacade.class);
        System.out.println(facade.getAllorderItems());
        context.registerShutdownHook();
    }

    @Test
    public void getOrderItemByOrderId() {
        AbstractApplicationContext context =
                new ClassPathXmlApplicationContext("beans.xml");

        DataFacade facade = context.getBean("facade", DataFacade.class);
        System.out.println(facade.getorderItemByOrderId(1));
        context.registerShutdownHook();
    }

    @Ignore
    @Test
    public void insertOrderItem() {
        Order order = new OrderDAOImpl().getOrderById(1);
        Item item = new ItemDAOImpl().getItemById(1);
        OrderItemDAO dao = new OrderItemDAOImpl();

        OrderItem orderItem = new OrderItem(order, item, 2);
        dao.insert(orderItem);
        System.out.println("Inserted Order Item: " + orderItem);
    }

    @Ignore
    @Test
    public void deleteOrderItem() {
        Order order = new OrderDAOImpl().getOrderById(1);
        Item item = new ItemDAOImpl().getItemById(1);
        OrderItemDAO dao = new OrderItemDAOImpl();

        OrderItem orderItem = new OrderItem(order, item, 2);
        dao.delete(orderItem);
        System.out.println("Deleted Order Item: " + orderItem);
    }

    @Ignore
    @Test
    public void updateOrderItem() {
        Order order = new OrderDAOImpl().getOrderById(1);
        Item item = new ItemDAOImpl().getItemById(1);
        OrderItemDAO dao = new OrderItemDAOImpl();

        OrderItem orderItem = new OrderItem(order, item, 2);
        dao.update(orderItem);
        System.out.println("Updated Order Item: " + orderItem);
    }

}
