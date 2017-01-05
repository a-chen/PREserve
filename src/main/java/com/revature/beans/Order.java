package com.revature.beans;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @Column(name = "orders_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(name = "reservation_id")
    private Reservation reservation;

    @OneToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @OneToMany(mappedBy = "order")
    private Set<Order_Item> order_items;

    public Order(Reservation reservation, Customer customer) {
        this.reservation = reservation;
        this.customer = customer;
    }

    public Order() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Set<Order_Item> getOrder_items() {
        return order_items;
    }

    public void setOrder_items(Set<Order_Item> order_items) {
        this.order_items = order_items;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", reservation=" + reservation.getId() +
                ", customer=" + customer.getId() +
                ", order_items=" + order_items +
                '}';
    }
}
