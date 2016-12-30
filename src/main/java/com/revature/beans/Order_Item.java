package com.revature.beans;

public class Order_Item {

	private Order order_id;
	private Item item_id;
	private int quantity;
	
	public Order_Item() {
		super();
	}

	public Order_Item(Order order_id, Item item_id, int quantity) {
		super();
		this.order_id = order_id;
		this.item_id = item_id;
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Order_Item [order_id=" + order_id + ", item_id=" + item_id + ", quantity=" + quantity + "]";
	}

	public Order getOrder_id() {
		return order_id;
	}

	public void setOrder_id(Order order_id) {
		this.order_id = order_id;
	}

	public Item getItem_id() {
		return item_id;
	}

	public void setItem_id(Item item_id) {
		this.item_id = item_id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
		
}
