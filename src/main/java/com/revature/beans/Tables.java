package com.revature.beans;

import javax.persistence.*;

@Entity
@Table(name = "tables")
public class Tables {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private int capacity;

    @Override
    public String toString() {
        return "Tables{" +
                "id=" + id +
                ", capacity=" + capacity +
                '}';
    }

    public Tables(int id, int capacity) {
        super();
        this.id = id;
        this.capacity = capacity;
    }

    public Tables() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
