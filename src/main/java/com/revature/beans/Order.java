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

    @OneToMany(mappedBy = "order", fetch = FetchType.EAGER)
    private Set<OrderItem> orderItems;

    public Order(Reservation reservation) {
        super();
        this.reservation = reservation;
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

    public Set<OrderItem> getorderItems() {
        return orderItems;
    }

    public void setorderItems(Set<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", reservation=" + reservation.getId() +
                ", orderItems=" + orderItems +
                '}';
    }
}
