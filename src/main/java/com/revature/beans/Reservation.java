package com.revature.beans;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "reservation")
public class Reservation {

    @Id
    @Column(name = "reservation_id")
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

    @Column(name = "patrons", nullable = true)
    private int patrons;

    public Reservation(Date date, ReservationTable table, Customer customer, int patrons) {
        this.date = date;
        this.table = table;
        this.customer = customer;
        this.patrons = patrons;
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
                ", patrons=" + patrons +
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

    public int getPatrons() {return patrons;}

    public void setPatrons(int patrons) {this.patrons = patrons;}
}
