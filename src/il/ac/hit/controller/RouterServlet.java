/* Meital Elmakaies 207058322
Yuval Rozilyo 313930703 */
package il.ac.hit.controller;

import javax.servlet.*;
import javax.servlet.http.*;

import il.ac.hit.model.HibernateItemsDAO;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * RouterServlet is a router that send requests from the controller - using reflection 
 *
 */
public class RouterServlet extends HttpServlet {

    private String pkg;
    /*
    Each request's URL will include the controller name and the
    action name (in that specific controller) at which the request
    targets.


     */
/**
 * This static block load HibernateItemsDAO class when the router is loading
 * 
 */
    static {
        HibernateItemsDAO.getInstance();
    }
    
    @Override
    public void init() {
        pkg = getServletConfig().getInitParameter("package");
    }
    /**
     * This method get request URI ,extract from it the controller and the action,and send the request to the correct jsp.
     * 
     * 
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//get the URI request from the user
        String text = request.getRequestURI();
        PrintWriter writer = response.getWriter();
        //split the URI to controller and the action we want to do next - what page to go
        String[]  arr = text.split("/");
        String controller = "user";
        String action = "login";
        if(arr.length>3) {
            controller = arr[3];
            if(controller.equals("*")) {
                controller = "user";
            }
        }

        if(arr.length>4) {
            action = arr[4].toLowerCase();
        }


        try {
            // calling the right action on the right controller and fit to the context 
            String className = pkg + "." + controller.substring(0, 1).toUpperCase() + controller.substring(1).toLowerCase() + "Controller";
            
            // retrieve the class from the class loader
            Class clazz = Class.forName(className);
            //Returns a ICostItemsDAO constructor object 
            Constructor constructor = clazz.getConstructor(il.ac.hit.model.ICostItemsDAO.class);
            //create and initialize a new instance of the HibernateItemsDAO class
            Object object = constructor.newInstance(il.ac.hit.model.HibernateItemsDAO.getInstance());
            //get the method object with the specified name and parameter types
            Method method = clazz.getMethod(action, HttpServletRequest.class, HttpServletResponse.class );
            //Invokes the underlying method represented by this method object
            method.invoke(object,request,response);
            

            //forwarding the execution to the view (identical with the name to the action)
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/"+controller +"/"+action+".jsp");
            dispatcher.forward(request,response);
            
          // all the exceptions catch
        } catch(ClassNotFoundException e) {
            showErrorMessage(request,response,"The requested controler doesnot exist");
        } catch(NoSuchMethodException e) {
            showErrorMessage(request,response,"Problem with instantiating the Model class");
        } catch (InvocationTargetException e) {
            showErrorMessage(request,response,"Problem with instantiating the Model class or invoking the action");
        } catch (InstantiationException e) {
            showErrorMessage(request,response,"Problem with instantiating the Model class");
        } catch (IllegalAccessException e) {
            showErrorMessage(request,response,"Problem with instantiating the Model class");
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    /**
     * The showErrorMessage will invoke when an error has occurred.
     * @param request
     * @param response
     * @param text
     * @throws ServletException
     * @throws IOException
     */
    protected void showErrorMessage(HttpServletRequest request, HttpServletResponse response,String text) throws ServletException, IOException {
       // the error message
    	request.setAttribute("errormessage",text);
    	// sent a error page to user with the error message
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/error.jsp");
        dispatcher.forward(request,response);
    }
}

