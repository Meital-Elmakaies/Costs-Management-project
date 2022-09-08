/* Meital Elmakaies 207058322
Yuval Rozilyo 313930703 */
package il.ac.hit.model;

import java.time.LocalDate;
import java.util.List;

/**
 * IProductsDAO Interface used for implement the design pattern
 * @author Meital Elmakaies
 */
public interface ICostItemsDAO {
     
	/**
     * addProduct method that add new CostItem to the DB
     */
    public void addCostItem(CostItem costItem) throws CostItemDAOException;
    /**
     *  deleteProduct method that will delete CostItem from products table
     *
     */
    public void deleteCostItem(int id) throws CostItemDAOException;
    /**
     * getProduct method that return a CostItem by id
     *
     */
    public CostItem getCostItem(int id) throws CostItemDAOException;
    /**
     * getProductsList method that return the list of CostItems
     */
    public List<CostItem> getCostItemsList()throws CostItemDAOException; 
    
	/**
	 * return list of users 
	 */
	public List<Users> getUsersList() throws CostItemDAOException;
    /**
     * The add user method add new users to the DB
     */
    public void addUser(Users user) throws CostItemDAOException;
    /**
     * return the list with specific date data for report
     */
	public List<CostItem> specificList(LocalDate start, LocalDate end) throws CostItemDAOException; 



}
