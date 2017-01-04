package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "order_item")
public class Order_Item {

	@Id
	@Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	
    @ManyToOne
    @JoinColumn(name = "orders_id", nullable = false)
	private Order orders_id;

   @ManyToOne
   @JoinColumn(name = "item_id", nullable = false)
	private Item item;
	
   @Column(nullable = false)
	private int quantity;

	public Order_Item(Order orders_id, Item item, int quantity) {
		this.orders_id = orders_id;
		this.item = item;
		this.quantity = quantity;
	}

	public Order_Item() {
		super();
	}

	@Override
	public String toString() {
		return "Order_Item{" +
				"id=" + id +
				", orders_id=" + orders_id +
				", item=" + item +
				", quantity=" + quantity +
				'}';
	}

	public Order getOrders_id() {
		return orders_id;
	}

	public void setOrders_id(Order orders_id) {
		this.orders_id = orders_id;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
