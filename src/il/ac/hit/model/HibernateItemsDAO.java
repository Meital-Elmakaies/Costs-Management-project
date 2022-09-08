/* Meital Elmakaies 207058322
Yuval Rozilyo 313930703 */
package il.ac.hit.model;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * This class manages all the communication with the DB with the design patter
 * (singleton) and using Hibernate Framework
 * 
 * @author Meital Elmakaies
 */

public class HibernateItemsDAO implements ICostItemsDAO {

	private static HibernateItemsDAO instance;
	private SessionFactory factory;

	static {
		HibernateItemsDAO.instance = new HibernateItemsDAO();
	}

	/**
	 * Class Constructor
	 */
	private HibernateItemsDAO() {
		// creating factory for getting sessions
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}

	}

	/**
	 * This method return instance of the HibernateItemsDAO class
	 */
	public static HibernateItemsDAO getInstance() {
		return HibernateItemsDAO.instance;
	}

	/**
	 * The addProduct method add new CostItem to the DB
	 */
	@Override
	public void addCostItem(CostItem product) throws CostItemDAOException {
		// open new session
		Session session = factory.openSession();
		Transaction tx = null;

		try {

			tx = session.beginTransaction();
			// save product to the DB
			session.save(product);
			tx.commit();

		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			throw new CostItemDAOException("failed to add new product", e);
		} finally {
			try {
				// end the session
				session.close();
			} catch (HibernateException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * deleteProduct method will delete CostItem from products table
	 *
	 */
	@Override
	public void deleteCostItem(int id) throws CostItemDAOException {

		Session session = factory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			CostItem product = (CostItem) session.get(CostItem.class, id);
			session.delete(product);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			throw new CostItemDAOException("failed to delete product", e);
		} finally {
			try {
				session.close();
			} catch (HibernateException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * getProduct method return a CostItem by id
	 *
	 */

	@Override
	public CostItem getCostItem(int id) throws CostItemDAOException {

		Session session = factory.openSession();
		Transaction tx = null;
		CostItem costItem = null;

		try {
			tx = session.beginTransaction();
			costItem = (CostItem) session.get(CostItem.class, id);
			tx.commit();

		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			throw new CostItemDAOException("Error Finding the product", e);
		} finally {
			try {
				session.close();
			} catch (HibernateException e) {
				e.printStackTrace();
			}
		}

		return costItem;
	}

	/**
	 * getProductsList return the list of CostItems
	 */
	@Override
	public List<CostItem> getCostItemsList() throws CostItemDAOException {

		Session session = factory.openSession();
		Transaction tx = null;
		List<CostItem> costItem = null;
		try {
			tx = session.beginTransaction();
			costItem = session.createQuery("FROM CostItem").list();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			throw new CostItemDAOException("failed to print CostItems list", e);
		} finally {
			try {
				session.close();
			} catch (HibernateException e) {
				e.printStackTrace();
			}

		}
		return costItem;

	}

	/**
	 * return list of users
	 */
	public List<Users> getUsersList() throws CostItemDAOException {
		Session session = factory.openSession();
		Transaction tx = null;
		List<Users> users = null;
		try {
			tx = session.beginTransaction();
			users = session.createQuery("FROM Users").list();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			throw new CostItemDAOException("failed to print users list", e);
		} finally {
			try {
				session.close();
			} catch (HibernateException e) {
				e.printStackTrace();
			}

		}
		return users;

	}

	/**
	 * The add user method add new users to the DB
	 */
	@Override
	public void addUser(Users user) throws CostItemDAOException {
		//open a session
		Session session = factory.openSession();
		Transaction tx = null;

		try {
			//save to db
			tx = session.beginTransaction();
			session.save(user);
			tx.commit();

		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			throw new CostItemDAOException("failed to add new user", e);
		} finally {
			try {
				session.close();
			} catch (HibernateException e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * 
	 * The specificList  method return list of specific dates from the DB
 
	 * 
	 */
	public List<CostItem> specificList(LocalDate start, LocalDate end) throws CostItemDAOException {
		List<CostItem> report = null;
		List<CostItem> newReport = new LinkedList<CostItem>();

		report = getCostItemsList();
		//check if the dates are valid
		if (start.isAfter(end)) {
			throw new CostItemDAOException("Error dates");
		}

		for (CostItem item : report) {
			
			String d = item.getDate();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			// convert String to LocalDate
			LocalDate localDate = LocalDate.parse(d, formatter);
			
			if(localDate.isAfter(start)&& localDate.isBefore(end)) {
				
				newReport.add(item);
			}

		
		}
		return newReport;
	}

}
