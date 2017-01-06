package com.revature.middle;

import com.revature.beans.Order;
import com.revature.data.DataFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private DataFacade facade;

    @Autowired
    public void setFacade(DataFacade facade) {
        this.facade = facade;
    }

    Order getOrderById(int id) {
        return facade.getOrderById(id);
    }

    void insertOrder(Order order) {
        facade.insertOrder(order);
    }

    void deleteOrder(Order order) {
        facade.deleteOrder(order);
    }
}
