package com.revature.middle;

import com.revature.beans.*;
import com.revature.data.DataFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;

/**
 * Business Delegate
 *  All logic should go in their respective controllers
 */
@Service(value = "businessDelegate")
public class Delegate {

    //Spring setter dependency injection
    private CustomerService customerService;
    private ItemService itemService;
    private OrderService orderService;
    private OrderItemService orderItemService;
    private ReservationService reservationService;
    private TableService tableService;

    //CustomerService
    public Customer getCustomerById(int id ) {
        return customerService.getCustomerById(id);
    }

    //ItemService
    public HashSet<Item> getAllItems() {
        return itemService.getAllItems();
    }
    public Item getItemById(int id) {
        return itemService.getItemById(id);
    }

    //OrderService
    public Order getOrderById(int id) {
        return orderService.getOrderById(id);
    }
    public void insertOrder(Order order) {
        orderService.insertOrder(order);
    }
    public void deleteOrder(Order order) {
        orderService.deleteOrder(order);
    }

    //OrderItemService
    public HashSet<OrderItem> getAllOrderItems(){
        return orderItemService.getAllOrderItems();
    }
    public OrderItem getOrderItemById(int id){
        return orderItemService.getOrderItemById(id);
    }
    public HashSet<OrderItem> getOrderItemByOrderId(int id) {
        return orderItemService.getOrderItemByOrderId(id);
    }
    public void insertOrderItem(OrderItem orderItem) {
        orderItemService.insertOrderItem(orderItem);
    }
    public void updateOrderItem(OrderItem orderItem) {
        orderItemService.updateOrderItem(orderItem);
    }
    public void deleteOrderItem(OrderItem orderItem) {
        orderItemService.deleteOrderItem(orderItem);
    }

    //ReservationService
    public HashSet<Reservation> getReservationByCustomerId(int id) {
        return reservationService.getReservationByCustomerId(id);
    }
    public Reservation getReservationById(int id) {
        return reservationService.getReservationById(id);
    }
    public void insertReservation(Reservation reservation) {
        reservationService.insertReservation(reservation);
    }
    public void updateReservation(Reservation reservation) {
        reservationService.updateReservation(reservation);
    }
    public void deleteReservation(Reservation reservation) {
        reservationService.deleteReservation(reservation);
    }

    //TableService
    public HashSet<ReservationTable> getAllTables(){
        return tableService.getAllTables();
    }
    public ReservationTable getTableById(int id) {
        return tableService.getTableById(id);
    }

    //Setters
    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }
    @Autowired
    public void setItemService(ItemService itemService) {
        this.itemService = itemService;
    }
    @Autowired
    public void setOrderItemService(OrderItemService orderItemService) {
        this.orderItemService = orderItemService;
    }
    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }
    @Autowired
    public void setReservationService(ReservationService reservationService) {
        this.reservationService = reservationService;
    }
    @Autowired
    public void setTableService(TableService tableService) {
        this.tableService = tableService;
    }

}
