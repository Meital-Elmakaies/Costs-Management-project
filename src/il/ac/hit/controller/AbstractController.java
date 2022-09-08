/* Meital Elmakaies 207058322
Yuval Rozilyo 313930703 */
package il.ac.hit.controller;
import il.ac.hit.model.ICostItemsDAO;

/**
 * AbstractController is an abstract class that represent the controller
 *
 */
public abstract class AbstractController {

	protected ICostItemsDAO dao;
	/**
	 * Class Constructor
	 * @param dao
	 */
    AbstractController(ICostItemsDAO dao) {
    	//initialization
        this.dao = dao;
    }

    public abstract void init();
}
