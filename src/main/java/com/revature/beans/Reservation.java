package com.revature.beans;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "reservation")
public class Reservation {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private Date date;

    @OneToOne
    @JoinColumn(name = "tables_id", nullable = false)
    private ReservationTable table;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public Reservation(Date date, ReservationTable table, Customer customer) {
        super();
        this.date = date;
        this.table = table;
        this.customer = customer;
    }

    public Reservation() {
        super();
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", date=" + date +
                ", table=" + table +
                ", customer=" + customer +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public ReservationTable getTable() {
        return table;
    }

    public void setTable(ReservationTable table) {
        this.table = table;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
