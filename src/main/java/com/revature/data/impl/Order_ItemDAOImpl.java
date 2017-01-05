package com.revature.data.impl;

import java.util.HashSet;

import com.revature.data.dao.Order_ItemDAO;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.beans.Item;
import com.revature.beans.Order_Item;
import org.hibernate.criterion.Restrictions;

public class Order_ItemDAOImpl implements Order_ItemDAO {

    private Session session;

	@Override
	public void setSession(Session session) {
		this.session = session;
	}

	public HashSet<Order_Item> getAll(){
        return new HashSet<>(session.createCriteria(Order_Item.class).list());
	}
	
	public HashSet<Order_Item> getByOrderID(int id){
		Criteria criteria = session.createCriteria(Order_Item.class);
		/*String HQL = " from Order_Item"
						+ " left join orders"
						+ " on order_item.orders_id = orders.id"
						+ " where orders.id= :orders_id";*/
		/*Query query = session.createQuery(HQL);
		query.setInteger("orders_id", id);*/
		criteria.add(Restrictions.eq("order", id));

		return new HashSet<Order_Item>(criteria.list());
	}

	/*public Set<Trainee> findBy(String major){
		Session session = sf.openSession();
		String HQL = "from Trainee where major = :q";
		Query query = session
				.createQuery(HQL);
		query.setString("q", major);
		return new HashSet<Trainee>(query.list());
	}*/
	
	public void insert(Order_Item order_item) {
		Transaction tx = session.beginTransaction();
		session.save(order_item);
		tx.commit();
	}

	public void update(Order_Item order_item) {
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(order_item);
		tx.commit();
	}

	public void delete(Order_Item order_item){
		Transaction tx = session.beginTransaction();
		session.delete(order_item);
		tx.commit();
	}


}
