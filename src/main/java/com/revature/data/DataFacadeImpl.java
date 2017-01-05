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

    private CustomerDAO customerDAO;
    private ItemDAO itemDAO;
    private OrderDAO orderDAO;
    private Order_ItemDAO order_itemDAO;
    private ReservationDAO reservationDAO;
    private TableDAO tableDAO;
    private ApplicationContext context;

    private SessionFactory sessionFactory;

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
        ReservationTable table = tableDAO.getTableById(id);

        session.close();
        return table;
    } //getTableById

    /**
     * This returns a customer with provided id
     * @param id
     * @return customer with specified id
     */
    @Override
    public Customer getCustomerById( int id ) {
        Session session = sessionFactory.openSession();

        customerDAO.setSession( session );
        Customer customer = customerDAO.getCustomerById( id );

        session.close();
        return customer;
    }

    /**
     * This returns an order with provided id
     * @param id
     * @return order with specified id
     */
    @Override
    public Order getOrderById(int id) {
        Session session = sessionFactory.openSession();

        orderDAO.setSession( session );
        Order order = orderDAO.getOrderById( id );

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

    @Override
	public HashSet<Item> getAllItems() {
		Session session = sessionFactory.openSession();
		itemDAO.setSession(session);
		HashSet<Item> items = itemDAO.getAllItems();
		session.close();
		return items;
	}

	@Override
	public Item getItemById(int id) {
		Session session = sessionFactory.openSession();

        itemDAO.setSession( session );
        Item item = itemDAO.getItemById( id );

        session.close();
        return item;
	}

/**
 	//TODO how are we inserting order items?
    @Override
    public void insertOrder_Item(OrderItem order_item) {
        Session session = sessionFactory.openSession();
        order_itemDAO = context.getBean("order_itemDAO", Order_ItemDAO.class);
        order_itemDAO.setSession( session );
        Transaction tx = session.beginTransaction();
        try{
            order_itemDAO.insert( order_item );
            tx.commit();
        }catch(Exception e){
            transaction.rollback();
        }
        session.close();
    }
**/	
	@Override
	public HashSet<OrderItem> getAllOrder_Items() {
		Session session = sessionFactory.openSession();
        order_itemDAO.setSession(session);
        HashSet<OrderItem> order_items = order_itemDAO.getAll();
        session.close();
        return order_items;
	}

	@Override
	public HashSet<OrderItem> getOrder_ItemByOrderId(int id) {
		Session session = sessionFactory.openSession();
		order_itemDAO.setSession(session);
		HashSet<OrderItem> order_items = order_itemDAO.getByOrderID(id);
		session.close();
		return order_items;
	}

    @Override
    public void createReservation(Reservation reservation) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        reservationDAO.setSession(session);

        reservationDAO.createReservation(reservation);

        tx.commit();
        session.close();
    }

    @Override
    public HashSet<Reservation> getReservationByCustomerId(int id) {
        Session session = sessionFactory.openSession();
        reservationDAO.setSession(session);
        HashSet<Reservation> reservations = reservationDAO.getReservationByCustomerId(id);
        session.close();
        return reservations;
    }

    @Override
    public Reservation getReservationById(int id) {
        Session session = sessionFactory.openSession();
        reservationDAO.setSession(session);
        Reservation reservation = reservationDAO.getReservationById(id);
        session.close();
        return reservation;
    }

    @Override
    public void updateReservation(Reservation reservation) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        reservationDAO.setSession(session);

        reservationDAO.updateReservation(reservation);

        tx.commit();
        session.close();
    }

    @Override
    public void deleteReservation(Reservation reservation) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        reservationDAO.setSession(session);

        reservationDAO.deleteReservation(reservation);

        tx.commit();
        session.close();
    }

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
    public void setOrder_itemDAO(Order_ItemDAO order_itemDAO) {
        this.order_itemDAO = order_itemDAO;
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

    public DataFacadeImpl() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }
}
