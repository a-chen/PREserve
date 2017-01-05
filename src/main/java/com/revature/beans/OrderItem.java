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
public class OrderItem {

	@Id
	@Column(name = "order_item_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	
    @ManyToOne
	@JoinColumn(name = "orders_id", nullable = false)
	private Order order;

   @ManyToOne
   @JoinColumn(name = "item_id", nullable = false)
	private Item item;
	
   @Column(nullable = false)
	private int quantity;

    public OrderItem(Order order, Item item, int quantity) {
        this.order = order;
        this.item = item;
        this.quantity = quantity;
    }

	public OrderItem() {
		super();
	}

	@Override
	public String toString() {
		return "OrderItem [order=" + order.getId() + ", item=" + item.getId() + ", quantity=" + quantity + "]";
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
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
