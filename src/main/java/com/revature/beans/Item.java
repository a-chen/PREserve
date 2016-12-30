package com.revature.beans;

public class Item {

	private int id;
	private double price;
	private String name;
	private String description;
	
	@Override
	public String toString() {
		return "Item [id=" + id + ", price=" + price + ", name=" + name + ", description=" + description + "]";
	}

	public Item() {
		super();
	}

	public Item(int id, double price, String name, String description) {
		super();
		this.id = id;
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
