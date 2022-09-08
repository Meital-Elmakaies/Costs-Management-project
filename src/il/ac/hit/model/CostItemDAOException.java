/* Meital Elmakaies 207058322
Yuval Rozilyo 313930703 */
package il.ac.hit.model;
/**
 * class for items exceptions  
 * @author Meital Elmakaies
 *
 */
public class CostItemDAOException extends Exception{
	/**
	 * exception of CostItems DAO - return message of the problem 
	 */
    public CostItemDAOException(String message) {
        super(message);
    }
    /**
	 * exception of CostItems DAO - return message of the problem and the cause of it  
	 */
    public CostItemDAOException(String message, Throwable cause) {
        super(message, cause);
    }
}
