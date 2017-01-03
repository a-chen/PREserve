package com.revature.data;

import com.revature.beans.*;
import com.revature.data.dao.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.HashSet;

/**
 * This is the facade for the data tier.
 * All interactions with the database should occur through here.
 */
public class DataFacadeImpl implements DataFacade, ApplicationContextAware {

    private CustomerDAO customerDAO;
    private ItemDAO itemDAO;
    private OrderDAO orderDAO;
    private Order_ItemDAO order_itemDAO;
    private ReservationDAO reservationDAO;
    private TableDAO tableDAO;

    private SessionFactory sessionFactory;
    private ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {
        this.context = context;
    }

    /**
     * This sets all DAO beans
     * @param customerDAO
     * @param itemDAO
     * @param orderDAO
     * @param order_itemDAO
     * @param reservationDAO
     * @param tableDAO
     */
    public DataFacadeImpl(CustomerDAO customerDAO, ItemDAO itemDAO,
                           OrderDAO orderDAO, Order_ItemDAO order_itemDAO,
                           ReservationDAO reservationDAO, TableDAO tableDAO) {

        sessionFactory = new Configuration().configure().buildSessionFactory();
        this.customerDAO = customerDAO;
        this.itemDAO = itemDAO;
        this.orderDAO = orderDAO;
        this.order_itemDAO = order_itemDAO;
        this.reservationDAO = reservationDAO;
        this.tableDAO = tableDAO;
    }

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
	
	@Override
	public HashSet<Order_Item> getAllOrder_Items() {
		Session session = sessionFactory.openSession();
        order_itemDAO.setSession(session);
        HashSet<Order_Item> order_items = order_itemDAO.getAll();
        session.close();
        return order_items;
	}

	@Override
	public HashSet<Order_Item> getOrder_ItemByOrderId(int id) {
		Session session = sessionFactory.openSession();
		order_itemDAO.setSession(session);
		HashSet<Order_Item> order_items = order_itemDAO.getByOrderID(id);
		session.close();
		return order_items;
	}

    @Override
    public void createReservation(Reservation reservation) {
        Session session = sessionFactory.openSession();
        reservationDAO.setSession(session);
        reservationDAO.createReservation(reservation);
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
        reservationDAO.setSession(session);
        reservationDAO.updateReservation(reservation);
        session.close();
    }

    @Override
    public void deleteReservation(Reservation reservation) {
        Session session = sessionFactory.openSession();
        reservationDAO.setSession(session);
        reservationDAO.deleteReservation(reservation);
        session.close();
    }
}
