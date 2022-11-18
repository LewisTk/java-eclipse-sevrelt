package servlets;


import java.util.ArrayList;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class ComprarListener
 *
 */
@WebListener
public class ProductoListener implements HttpSessionListener {

    /**
     * Default constructor. 
     */
    public ProductoListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent arg0)  { 
         
    	System.out.println("Empezó a escuchar.......");
    	
    	ArrayList<RastreoServlet> carroRastreo = new ArrayList<RastreoServlet>();
    	int cantProductos = 0;
    	
    	arg0.getSession().setAttribute("carroRastreo", carroRastreo);
    	arg0.getSession().setAttribute("cantProductos", cantProductos);
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent arg0)  { 
         // TODO Auto-generated method stub
    }
	
}
