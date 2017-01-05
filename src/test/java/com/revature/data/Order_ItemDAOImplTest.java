package com.revature.data;

import com.revature.beans.Item;
import com.revature.beans.Order;
import com.revature.beans.OrderItem;
import com.revature.data.dao.Order_ItemDAO;
import com.revature.data.impl.ItemDAOImpl;
import com.revature.data.impl.OrderDAOImpl;
import com.revature.data.impl.OrderItemDAOImpl;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Order_ItemDAOImplTest {

    @Test
    public void getAllOrder_Items() throws Exception {
        AbstractApplicationContext context =
                new ClassPathXmlApplicationContext("beans.xml");

        DataFacade facade = context.getBean("facade", DataFacade.class);
        System.out.println(facade.getAllOrder_Items());
        context.registerShutdownHook();
    }

    @Test
    public void getOrder_ItemByOrderId() {
        AbstractApplicationContext context =
                new ClassPathXmlApplicationContext("beans.xml");

        DataFacade facade = context.getBean("facade", DataFacade.class);
        System.out.println(facade.getOrder_ItemByOrderId(1));
        context.registerShutdownHook();
    }

    @Ignore
    @Test
    public void insertOrder_Item() {
        Order order = new OrderDAOImpl().getOrderById(1);
        Item item = new ItemDAOImpl().getItemById(1);
        Order_ItemDAO dao = new OrderItemDAOImpl();

        OrderItem order_item = new OrderItem(order, item, 2);
        dao.insert(order_item);
        System.out.println("Inserted Order Item: " + order_item);
    }

    @Ignore
    @Test
    public void deleteOrder_Item() {
        Order order = new OrderDAOImpl().getOrderById(1);
        Item item = new ItemDAOImpl().getItemById(1);
        Order_ItemDAO dao = new OrderItemDAOImpl();

        OrderItem order_item = new OrderItem(order, item, 2);
        dao.delete(order_item);
        System.out.println("Deleted Order Item: " + order_item);
    }

    @Ignore
    @Test
    public void updateOrder_Item() {
        Order order = new OrderDAOImpl().getOrderById(1);
        Item item = new ItemDAOImpl().getItemById(1);
        Order_ItemDAO dao = new OrderItemDAOImpl();

        OrderItem order_item = new OrderItem(order, item, 2);
        dao.update(order_item);
        System.out.println("Updated Order Item: " + order_item);
    }

}
