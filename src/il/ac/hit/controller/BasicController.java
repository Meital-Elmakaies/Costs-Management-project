/* Meital Elmakaies 207058322
Yuval Rozilyo 313930703 */
package il.ac.hit.controller;

import il.ac.hit.model.ICostItemsDAO;

/**
 * BasicController class is an main controller
 *
 */
public class BasicController extends AbstractController {
	/**
	 * Class Constructor
	 * @param dao
	 */
    public BasicController(ICostItemsDAO dao) {
    	//initialization
        super(dao);
    }

    @Override
    public void init() {

    }
}
