package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "item")
public class Item {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
    
    @Column(nullable = false)
	private double price;
	
    @Column(nullable = false)
	private String name;

    @Column(nullable = true)
	private String description;
	
	@Override
	public String toString() {
		return "Item [id=" + id + ", price=" + price + ", name=" + name + ", description=" + description + "]";
	}

	public Item() {
		super();
	}

	public Item(double price, String name, String description) {
        super();
		this.price = price;
		this.name = name;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
		
}
