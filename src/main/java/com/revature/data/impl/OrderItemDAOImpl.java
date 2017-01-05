package com.revature.data.impl;

import java.util.HashSet;

import com.revature.beans.OrderItem;
import com.revature.data.dao.Order_ItemDAO;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

<<<<<<< HEAD:src/main/java/com/revature/data/impl/Order_ItemDAOImpl.java
import com.revature.beans.Item;
import com.revature.beans.Order_Item;
import org.hibernate.criterion.Restrictions;
=======
import org.springframework.stereotype.Repository;
>>>>>>> 1ddc68902949ad49f12eeb800abd6b4221b2840e:src/main/java/com/revature/data/impl/OrderItemDAOImpl.java

@Repository(value = "orderItemDAO")
public class OrderItemDAOImpl implements Order_ItemDAO {

    private Session session;

	@Override
	public void setSession(Session session) {
		this.session = session;
	}

	public HashSet<OrderItem> getAll(){
        return new HashSet<>(session.createCriteria(OrderItem.class).list());
	}
	
<<<<<<< HEAD:src/main/java/com/revature/data/impl/Order_ItemDAOImpl.java
	public HashSet<Order_Item> getByOrderID(int id){
		Criteria criteria = session.createCriteria(Order_Item.class);
		criteria.add(Restrictions.eq("order.id", id));

		return new HashSet<Order_Item>(criteria.list());
=======
	public HashSet<OrderItem> getByOrderID(int id){
		String HQL = "select"
					+ " order_item.orders_id, order_item.item_id, order_item.quantity"
					+ " from com.revature.beans.OrderItem"
						+ " left join orders"
						+ " on order_item.orders_id = orders.id"
					+ " where orders.id= :order_id";
		Query query = session.createQuery(HQL);
		query.setInteger("order_id", id);
		
		return new HashSet<OrderItem>(query.list());
>>>>>>> 1ddc68902949ad49f12eeb800abd6b4221b2840e:src/main/java/com/revature/data/impl/OrderItemDAOImpl.java
	}
	
	public void insert(OrderItem order_item) {
		Transaction tx = session.beginTransaction();
		session.save(order_item);
		tx.commit();
	}

	public void update(OrderItem order_item) {
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(order_item);
		tx.commit();
	}

	public void delete(OrderItem order_item){
		Transaction tx = session.beginTransaction();
		session.delete(order_item);
		tx.commit();
	}


}
