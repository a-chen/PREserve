package com.revature.beans;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "reservation_id", nullable = false)
    private int reservationId;

    @Column(name = "customer_id", nullable = false)
    private int customerId;

    public Order(int reservationId, int customerId) {
        this.reservationId = reservationId;
        this.customerId = customerId;
    }

    public Order() { super();}

    public int getId() {
        return id;
    }

    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", reservationId=" + reservationId +
                ", customerId=" + customerId +
                '}';
    }
}
