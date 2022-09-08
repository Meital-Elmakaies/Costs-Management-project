/* Meital Elmakaies 207058322
Yuval Rozilyo 313930703 */
package il.ac.hit.controller;

import il.ac.hit.model.*;
import il.ac.hit.validation.Validation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * The UserController class is an user controller in order to perform user
 * actions
 * 
 */
public class UserController extends BasicController {
	private HttpSession session = null;
	private Validation val = null;

	/**
	 * Class Constructor
	 * 
	 * @param dao
	 */
	public UserController(ICostItemsDAO dao) {
		super(dao);
		val = new Validation();
	}

	/**
	 * The products method get all the cost items from the model and send it to the
	 * view via HttpServletRequest object
	 * 
	 * @param request
	 * @param response
	 * @throws CostItemDAOException
	 */
	public void products(HttpServletRequest request, HttpServletResponse response) throws CostItemDAOException {
		// take the list from the DB
		List<CostItem> userList = null;
		List<CostItem> vec = dao.getCostItemsList();
		// to know what user use the app - for specific details
		session = request.getSession();
		Users user = (Users) session.getAttribute("match");
		if (user != null) {
			userList = new LinkedList<CostItem>();
			// to take the specific details of the user
			for (CostItem item : vec) {
				if (item.getUser().equals(user.getUsername())) {
					userList.add(item);
				}

			}
		}
		// use it to for the jsp
		request.setAttribute("data", userList);

	}

	/**
	 * The addproduct method take all the user inputs and add a new product to the
	 * DB
	 * 
	 * @param request
	 * @param response
	 * @throws CostItemDAOException
	 */
	public void addproduct(HttpServletRequest request, HttpServletResponse response) throws CostItemDAOException {
		// take all the user details
		double price = 0.0;
		int id = 0;
		String name = request.getParameter("name");
		String priceStr = request.getParameter("price");
		String idStr = request.getParameter("ID");
		String cateStr = request.getParameter("category");
		String dateStr = request.getParameter("date");
		String description = request.getParameter("description");

		// validation checking
		if (name != null && description != null && priceStr != null && idStr != null && cateStr != null
				&& dateStr != null) {
			if (val.checkItems(description, name, cateStr, idStr, priceStr, dateStr)) {
				price = Double.parseDouble(priceStr);
				id = Integer.parseInt(idStr);
				// to know what user use the app - for specific details
				session = request.getSession();
				Users users = (Users) session.getAttribute("match");
				if (users != null) {
					// create new item
					CostItem item = new CostItem(id, name, description, price, dateStr, cateStr, users.getUsername());
					// add the new item to the DB
					dao.addCostItem(item);

					// use it to for the jsp
					request.setAttribute("product", item);
				}
			}

		}
	}

	/**
	 * The deleteProducts method gets a product id that the user want to delete and
	 * delete it from the DB
	 * 
	 * @param request
	 * @param response
	 * @throws CostItemDAOException
	 */
	public void deleteproduct(HttpServletRequest request, HttpServletResponse response) throws CostItemDAOException {
		// take the user detail
		int id = 0;
		String idStr = request.getParameter("ID");
		// validtion checking
		if (idStr != null) {
			if (val.checkId(idStr)) {
				id = Integer.parseInt(idStr);
				CostItem item = dao.getCostItem(id);
				// to know what user use the app - for specific details
				session = request.getSession();
				Users user = (Users) session.getAttribute("match");
				// checking if the item ID the user worte is fit to his items ID
				if (user.getUsername().equals(item.getUser())) {
					dao.deleteCostItem(id);
					// use it to for the jsp
					request.setAttribute("delete", item);
				}
			}

		}
	}

	/**
	 * The getproduct method get a product id from the user, find it in the DB and
	 * send it to the view via the HttpServletRequest
	 * 
	 * @param request
	 * @param response
	 * @throws CostItemDAOException
	 */
	public void getproduct(HttpServletRequest request, HttpServletResponse response) throws CostItemDAOException {
		// take all the user detail
		int id = 0;
		String idStr = request.getParameter("ID");
		// validtion checking
		if (idStr != null) {
			if (val.checkId(idStr)) {
				id = Integer.parseInt(idStr);
				CostItem item = dao.getCostItem(id);
				// to know what user use the app - for specific details
				session = request.getSession();
				Users user = (Users) session.getAttribute("match");
				// checking if the item ID the user worte is fit to his items ID
				if (user.getUsername().equals(item.getUser())) {
					// use it to for the jsp
					request.setAttribute("idproduct", item);
				}
			}
		}
	}

	/**
	 * The login method get the user name and the password from and check if exist
	 * in the list
	 * 
	 * @param request
	 * @param response
	 * @throws CostItemDAOException
	 */
	public void login(HttpServletRequest request, HttpServletResponse response) throws CostItemDAOException {
		// take all the user details
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		// validtion checking
		if (username != null && password != null) {
			// create new user
			Users user = new Users(username, password);
			// take the list from the DB
			List<Users> vec = dao.getUsersList();
			// checking if the this user exist
			session = request.getSession();
			if (vec.contains(user)) {
				// if exist send that there is match with the login details
				//request.setAttribute("match", user);
				session.setAttribute("match", user);

				
			} else {
				// if not exist send that there is no match with the login details
				session.setAttribute("noMatch", user);
				
			}
			
		}

	}

	/**
	 * The register method get the user name and the password from the user and
	 * create new user
	 * 
	 * @param request
	 * @param response
	 * @throws CostItemDAOException
	 */
	public void register(HttpServletRequest request, HttpServletResponse response) throws CostItemDAOException {
		// take all the user details
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		// validtion checking
		if (username != null && password != null) {

			// create new user
			Users user = new Users(username, password);
			
			// Puts the user in the DB
			dao.addUser(user);
			// use it to for the jsp
			request.setAttribute("add", user);
		}

	}

	// }
	/**
	 * The report method get all the cost items of the user and speecific dates from
	 * this list and summarized the spending it take it from the model and send it
	 * to the view via HttpServletRequest object
	 * 
	 * @param request
	 * @param response
	 * @throws CostItemDAOException
	 */
	public void report(HttpServletRequest request, HttpServletResponse response) throws CostItemDAOException {
		List<CostItem> userList = null;
		double sum = 0;
		// take all the user details (start date and end date for the report
		String start = request.getParameter("start");
		String end = request.getParameter("end");
		// validtion checking
		if (start != null && end != null) {

			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			// convert String to LocalDate
			LocalDate startDate = LocalDate.parse(start, formatter);
			LocalDate endDate = LocalDate.parse(end, formatter);
			// take the list from the DB with the specific dates of all the users
			List<CostItem> reportList = dao.specificList(startDate, endDate);
			// to know what user use the app - for specific details
			session = request.getSession();
			Users user = (Users) session.getAttribute("match");
			// create a new list - that will contain the specific dates the user ask for
			// with the user details
			userList = new LinkedList<CostItem>();
			// run on the list and find the specific user and also do sum for the spending
			// the user did
			for (CostItem item : reportList) {
				if (item.getUser().equals(user.getUsername())) {
					sum += item.getPrice();
					userList.add(item);
				}

			}

		}
		// use it to for the jsp
		request.setAttribute("sum", sum);
		request.setAttribute("listUser", userList);

	}

	/**
	 * The sign out method sign out the user that using the app
	 * 
	 * @param request
	 * @param response
	 * @throws CostItemDAOException
	 */
	public void signout(HttpServletRequest request, HttpServletResponse response) throws CostItemDAOException {
		// get the user session
		session = request.getSession();
		// clear the session
		session.invalidate();
	}
}
