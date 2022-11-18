package servlets;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import mantenimientos.GestionProductos;
import mantenimientos.GestionRegistroLlegadaProducto;
import model.Producto;
import model.RegistroProductoLlegada;


/**
 * Servlet implementation class ProductoServlet
 */
@WebServlet(name = "crudprod", urlPatterns = { "/crudprod" })
public class RastreoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RastreoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        System.out.println("Ingreso al Servlet de Productos");
		
		String accion = request.getParameter("btnAccion");

		System.out.println(accion);
		
		switch(accion) {
		case "lst": listar(request, response); break;
		case "act": actualizar(request, response); break;
		case "q" : buscar(request, response); break;
		case "b" : borrar(request, response); break;
		case "reg": registrarLlegada(request, response); break;
		case "his": listarHistorial(request,response); break;
		case "env": enviarProductoInforme(request, response);break;

		default:
		}
	}
	
	
	
	private void borrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String codigo=request.getParameter("cod"); // form  o del ref del listado.jsp
		
		Producto p = new GestionProductos().borrar(codigo);  //obtener un objeto de Producto
		
		//validar
		
		request.setAttribute("p", p); //envía el obj producto como atributo a la página
		request.getRequestDispatcher("crudprod?btnAccion=lst").forward(request,response);
		
	}

	private void enviarProductoInforme(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String codigo=request.getParameter("c"); // form  o del ref del listado.jsp
		
		RegistroProductoLlegada r = new GestionRegistroLlegadaProducto().buscar(codigo); //obtener un objeto de Producto
		
		//validar
		
		request.setAttribute("r", r); //envía el obj producto como atributo a la página
		request.getRequestDispatcher("InformeCarro.jsp").forward(request,response);
		
	}

	private void listarHistorial(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GestionRegistroLlegadaProducto gp = new GestionRegistroLlegadaProducto();
		List<RegistroProductoLlegada> lstRegistro = gp.listado();
		
		request.setAttribute("lstRegistro", lstRegistro);
		
		request.getRequestDispatcher("listaHistorial.jsp").forward(request, response);
		
	}

	private void registrarLlegada(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int codreg = Integer.parseInt(request.getParameter("txtCodReg"));
		String codprod = request.getParameter("txtCodigo");
		String descripcion = request.getParameter("txtDescripcion");
		int codestacion = Integer.parseInt(request.getParameter("cboEstacion"));
		String hllegada = request.getParameter("txtHllegada");
		String descripcionActualProd = request.getParameter("txtDescripcionActual");
		
		RegistroProductoLlegada r = new RegistroProductoLlegada(codreg, codprod, descripcion, codestacion, hllegada, descripcionActualProd);
		
		GestionRegistroLlegadaProducto gp = new GestionRegistroLlegadaProducto();
		
		int ok = gp.registrar(r);
		if (ok == 0) {
			 request.setAttribute("mensaje", 
				    "<div class='alert alert-danger' role='alert'> Error al Registrar" + "</div>");
			 request.setAttribute("r", r);
		}else {
			request.setAttribute("mensaje", 
				    "<div class='alert alert-success' role='alert'> Registrar Actualizado" + "</div>");
		}
		request.getRequestDispatcher("registrarLlegadaProducto.jsp").forward(request, response);
		
	}

	private void actualizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String codprod = request.getParameter("txtCodigo");
		String descripcion = request.getParameter("txtDescripcion");
		int cantidad = Integer.parseInt(request.getParameter("txtCantidad"));
		String fllegada = request.getParameter("txtFllegada");
		String fentrega = request.getParameter("txtFentrega");
		String direccion = request.getParameter("txtDireccion");
		int codmod = Integer.parseInt(request.getParameter("cboEntrega"));
		int codestacion = Integer.parseInt(request.getParameter("cboEstacion"));
		
		Producto p = new Producto(codprod, descripcion, cantidad, fllegada, fentrega, direccion, codmod, codestacion);
		
		GestionProductos gp = new GestionProductos();
		
		int ok = gp.actualizar(p);
		
		if (ok == 0) {
			 request.setAttribute("mensaje", 
				    "<div class='alert alert-danger' role='alert'> Error al Actualizar" + "</div>");
			 request.setAttribute("p", p);
		}else {
			request.setAttribute("mensaje", 
				    "<div class='alert alert-success' role='alert'> ProductoActualizado" + "</div>");
		}
		request.getRequestDispatcher("ActualizarProducto.jsp").forward(request, response);
		
	}

	private void buscar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String codigo=request.getParameter("cod"); // form  o del ref del listado.jsp
		
		Producto p = new GestionProductos().buscar(codigo);  //obtener un objeto de Producto
		
		//validar
		
		request.setAttribute("p", p); //envía el obj producto como atributo a la página
		request.getRequestDispatcher("ActualizarProducto.jsp").forward(request,response);
		
	}

	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		GestionProductos gp = new GestionProductos();
		List<Producto> lstProducto = gp.listar();
		
		request.setAttribute("lstProducto", lstProducto);
		
		request.getRequestDispatcher("listado.jsp").forward(request, response);
		
	}


}
