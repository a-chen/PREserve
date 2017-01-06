package com.revature.data;

import com.revature.beans.*;
import com.revature.data.dao.*;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.HashSet;

/**
 * This is the facade for the data tier.
 * All interactions with the database should occur through here.
 */
@Component(value = "facade")
public class DataFacadeImpl implements DataFacade, ApplicationContextAware {

//  Spring setter dependency injection
    private CustomerDAO customerDAO;
    private ItemDAO itemDAO;
    private OrderDAO orderDAO;
    private OrderItemDAO orderItemDAO;
    private ReservationDAO reservationDAO;
    private TableDAO tableDAO;
    private ApplicationContext context;
//  Constructor DI
    private SessionFactory sessionFactory;

//   Customer
    /**
     * This returns a customer with provided id
     * @param id
     * @return customer with specified id
     */
    @Override
    public Customer getCustomerById( int id ) {
        Session session = sessionFactory.openSession();

        customerDAO.setSession( session );
        Customer customer = customerDAO.getById( id );

        session.close();
        return customer;
    }

//  Item
    @Override
	public HashSet<Item> getAllItems() {
		Session session = sessionFactory.openSession();
		itemDAO.setSession(session);
		HashSet<Item> items = itemDAO.getAll();
		session.close();
		return items;
	}

	@Override
	public Item getItemById(int id) {
		Session session = sessionFactory.openSession();

        itemDAO.setSession( session );
        Item item = itemDAO.getById( id );

        session.close();
        return item;
	}

//  Order
    /**
     * This returns an order with provided id
     * @param id
     * @return order with specified id
     */
    @Override
    public Order getOrderById(int id) {
        Session session = sessionFactory.openSession();

        orderDAO.setSession( session );
        Order order = orderDAO.getById( id );

        session.close();
        return order;
    }

    /**
     *This inserts an order
     * @param order
     */
    @Override
    public void insertOrder( Order order ) {
        Session session = sessionFactory.openSession();
        orderDAO.setSession( session );
        Transaction tx = session.beginTransaction();
        try{
            orderDAO.insert( order );
            tx.commit();
        }catch(Exception e){
            tx.rollback();
        }
        session.close();
    }

    /**
     * This deletes an order
     * @param order
     */
    @Override
    public void deleteOrder(Order order) {
        Session session = sessionFactory.openSession();
        orderDAO.setSession( session );

        Transaction tx = session.beginTransaction();
        try{
            orderDAO.delete( order );
            tx.commit();
        }catch( Exception e ){
            tx.rollback();
        }

        session.close();
    }

//  OrderItem
    @Override
    public HashSet<OrderItem> getAllOrderItems() {
        Session session = sessionFactory.openSession();
        orderItemDAO.setSession(session);
        HashSet<OrderItem> orderItems = orderItemDAO.getAll();
        session.close();
        return orderItems;
    }

    @Override
    public OrderItem getOrderItemById(int id) {
        Session session = sessionFactory.openSession();

        orderItemDAO.setSession( session );
        OrderItem orderItem = orderItemDAO.getByOrderItemId(id);

        session.close();
        return orderItem;
    }

    @Override
    public HashSet<OrderItem> getOrderItemByOrderId(int id) {
        Session session = sessionFactory.openSession();
        orderItemDAO.setSession(session);
        HashSet<OrderItem> orderItems = orderItemDAO.getByOrderID(id);
        session.close();
        return orderItems;
    }

    @Override
    public void insertOrderItem(OrderItem orderItem) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        orderItemDAO.setSession( session );
        try{
            orderItemDAO.insert( orderItem );
            tx.commit();
        }catch(Exception e){
            tx.rollback();
        }
        session.close();
    }

    @Override
    public void updateOrderItem(OrderItem orderItem) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        orderItemDAO.setSession( session );
        try{
            orderItemDAO.update( orderItem );
            tx.commit();
        }catch(Exception e){
            tx.rollback();
        }
        session.close();
    }

    @Override
    public void deleteOrderItem(OrderItem orderItem){
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        orderItemDAO.setSession(session);
        try {
            orderItemDAO.delete(orderItem);
            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }
        session.close();
    }

//  Reservation
    @Override
    public HashSet<Reservation> getReservationByCustomerId(int id) {
        Session session = sessionFactory.openSession();
        reservationDAO.setSession(session);
        HashSet<Reservation> reservations = reservationDAO.getByCustomerId(id);
        session.close();
        return reservations;
    }

    @Override
    public Reservation getReservationById(int id) {
        Session session = sessionFactory.openSession();
        reservationDAO.setSession(session);
        Reservation reservation = reservationDAO.getById(id);
        session.close();
        return reservation;
    }

    @Override
    public void insertReservation(Reservation reservation) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        reservationDAO.setSession(session);

        reservationDAO.insert(reservation);

        tx.commit();
        session.close();
    }

    @Override
    public void updateReservation(Reservation reservation) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        reservationDAO.setSession(session);

        reservationDAO.update(reservation);

        tx.commit();
        session.close();
    }

    @Override
    public void deleteReservation(Reservation reservation) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        reservationDAO.setSession(session);

        reservationDAO.delete(reservation);

        tx.commit();
        session.close();
    }

//  Table
    /**
     * This returns a collection of all tables
     *
     * @return collection of all tables
     */
    public HashSet<ReservationTable> getAllTables() {
        Session session = sessionFactory.openSession();

        tableDAO.setSession(session);
        HashSet<ReservationTable> tables = tableDAO.getAll();

        session.close();
        return tables;
    } // getAllTables

    /**
     * This returns a table with provided id
     *
     * @param id
     * @return table with specified id
     */
    public ReservationTable getTableById(int id) {
        Session session = sessionFactory.openSession();

        tableDAO.setSession(session);
        ReservationTable table = tableDAO.getById(id);

        session.close();
        return table;
    } //getById

//  Setters
    @Autowired
    public void setCustomerDAO(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }
    @Autowired
    public void setItemDAO(ItemDAO itemDAO) {
        this.itemDAO = itemDAO;
    }
    @Autowired
    public void setOrderDAO(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }
    @Autowired
    public void setorderItemDAO(OrderItemDAO orderItemDAO) {
        this.orderItemDAO = orderItemDAO;
    }
    @Autowired
    public void setReservationDAO(ReservationDAO reservationDAO) {
        this.reservationDAO = reservationDAO;
    }
    @Autowired
    public void setTableDAO(TableDAO tableDAO) {
        this.tableDAO = tableDAO;
    }
    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {
        this.context = context;
    }

//  Constructor
    public DataFacadeImpl() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }
}
