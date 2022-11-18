package servlets;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import mantenimientos.GestionUsuario;
import model.Usuario;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet(name = "cruduser", description = "Controlador del Usuario", urlPatterns = { "/cruduser" })
public class UsuarioClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UsuarioClienteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Ingreso al servlet de productos....");

		String accion = request.getParameter("btnAccion");
		System.out.println(accion);

		accion = (accion == null) ? "cerrar" : accion;

		switch (accion) {
		case "reg":
			registrar(request, response);
			break;
		case "log":
			login(request, response);
			break;
		default:
			// cerrar sesión y reenviar al login.jsp
			System.out.println("Cerrando la sesión : " + request.getSession().getId());
			request.getSession().invalidate();
			response.sendRedirect("login.jsp");
		}

	}

	private void login(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		System.out.println("Entró al service del Servlet Login");

		String usuario, clave;

		usuario = request.getParameter("txtUsuario");
		clave = request.getParameter("txtPassword");

		System.out.println(usuario + "/" + clave);

		Usuario u = new GestionUsuario().validar(usuario, clave);

		if (u != null) {
			request.getSession().setAttribute("u", u);
			response.sendRedirect("principalCliente.jsp");
		}

		else {
			request.setAttribute("mensaje",
					"<div class='alert alert-danger' role='alert'> Usuario incorrecto" + "</div>");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}

	}

	private void registrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nombre = request.getParameter("txtNombre");
		String apellido = request.getParameter("txtApellido");
		String usuario = request.getParameter("txtUsuario");
		String password = request.getParameter("txtPassword");
		String fnac = request.getParameter("txtFechaNacimiento");
		int ecivil = Integer.parseInt(request.getParameter("cboEstado"));
	
		
		Usuario u = new Usuario(nombre, apellido, usuario, password, fnac, ecivil);
		
		GestionUsuario gp = new GestionUsuario();
		int ok = gp.registrar(u);
		
		if (ok == 0) {
			 request.setAttribute("mensaje", 
				    "<div class='alert alert-danger' role='alert'> Error al Registrar" + "</div>");
			 request.setAttribute("u", u);
		}else {
			request.setAttribute("mensaje", 
				    "<div class='alert alert-success' role='alert'> Usuario Registrado" + "</div>");
		}
		request.getRequestDispatcher("registro.jsp").forward(request, response);

	}

}
