package com.revature.middle;

import com.revature.beans.Order;
import com.revature.beans.OrderItem;
import com.revature.data.DataFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class OrderItemService {

    private DataFacade facade;
    @Autowired
    public void setFacade(DataFacade facade) {
        this.facade = facade;
    }

    HashSet<OrderItem> getAllOrderItems(){
        return facade.getAllOrderItems();
    }

    OrderItem getOrderItemById(int id){
        return facade.getOrderItemById(id);
    }

    HashSet<OrderItem> getOrderItemByOrderId(int id) {
        return facade.getOrderItemByOrderId(id);
    }

    void insertOrderItem(OrderItem orderItem) {
        facade.insertOrderItem(orderItem);
    }

    void updateOrderItem(OrderItem orderItem) {
        facade.updateOrderItem(orderItem);
    }

    void deleteOrderItem(OrderItem orderItem) {
        facade.deleteOrderItem(orderItem);
    }

}
