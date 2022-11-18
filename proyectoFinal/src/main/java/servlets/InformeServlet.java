package servlets;

import java.io.IOException;
import java.util.ArrayList;

/*import javax.servlet.ServletException;*/
/*import javax.servlet.annotation.WebServlet;*/
/*import javax.servlet.http.HttpServlet;*/
/*import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;*/

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;




import model.RegistroProductoLlegada;

/**
 * Servlet implementation class InformeServlet
 */
@WebServlet(name = "Informe", urlPatterns = { "/Informe" })
public class InformeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InformeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accion = request.getParameter("accion");
		System.out.println(accion);
		
		switch(accion) {
		case "agregar":agregarProducto(request, response);break;
		
		default:break;
		
		}
	}

	private void agregarProducto(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		RegistroProductoLlegada r = (RegistroProductoLlegada) request.getSession().getAttribute("r");
		
		ArrayList<RegistroProductoLlegada> carroRastreo= (ArrayList<RegistroProductoLlegada>) request.getSession().getAttribute("carroRastreo");
		
		int cantProductos = (int) request.getSession().getAttribute("cantProductos");
		
		RegistroProductoLlegada p = new RegistroProductoLlegada();
		p.setCodreg(r.getCodreg());
		p.setCodprod(r.getCodprod());
		p.setDescripcion(r.getDescripcion());
		p.setCodestacion(r.getCodestacion());
		p.setHllegada(r.getHllegada());
		p.setDescripcionActualProd(r.getDescripcionActualProd());
	    
		carroRastreo.add(r);
		cantProductos += 1;
		
		request.getSession().setAttribute("carroRastreo", carroRastreo);
		request.getSession().setAttribute("cantProductos", cantProductos);
		System.out.println("Enviando Variables");
		
		response.sendRedirect("canasta.jsp");
 	}

}
