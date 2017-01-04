package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "order_items")
public class Order_Item {

    @OneToOne
    @JoinColumn(name = "order_id", nullable = false)
	private Order order;

    @OneToOne
    @JoinColumn(name = "item_id", nullable = false)
	private Item item;
	
    @Column(nullable = false)
	private int quantity;

    public Order_Item(Order order, Item item, int quantity) {
        this.order = order;
        this.item = item;
        this.quantity = quantity;
    }

	public Order_Item() {
		super();
	}

	@Override
	public String toString() {
		return "Order_Item [order=" + order + ", item=" + item + ", quantity=" + quantity + "]";
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
		
}
