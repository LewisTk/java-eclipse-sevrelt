
<%@page import="model.Producto"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listado de productos</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>

	<div class="container">
		<header>
			<h1>RastreoCiber</h1>
		</header>

		<main>
			<nav style="width: 25%; float: left;">
				<ul>
					<li><a href="crudprod?btnAccion=lst">Lista de productos</a></li>
					<br>
					<li><a href="#">Buscar por Track ID</a></li>
					<br>
					<li><a href="crudprod?btnAccion=his">Historial de puntos de llegada</a></li>
					<br>
					<li><a href="login.jsp">Cerrar sesion</a></li>
				</ul>
			</nav>
			<br> <br> <br>
			<section style="width: 70%; float: right;">

				<h1>Lista de Productos</h1>

				<div class="container">
					<table class="table">
						<tr>
							<th>Codigo</th>
							<th>Descripcion</th>
							<th>Cantidad</th>
							<th>Fecha de compra</th>
							<th>Fecha de llegada</th>
							<th>Direccion de entrega</th>
							<th>Modalidad de Envío</th>
							<th>Estación Actual</th>
							<th>Editar</th>
							<th>Eliminar</th>
							
						</tr>
						<%
						//capturar el atributo del listado
						List<Producto> lstProducto = (List<Producto>) request.getAttribute("lstProducto");
						if (lstProducto != null) {
							//recorre y muestra los datos de productos
							for (Producto p : lstProducto) {
						%>
						<tr class="grilla_campo">
							<td><%=p.getCodprod()%></td>
							<td><%=p.getDescripcion()%></td>
							<td><%=p.getCantidad()%></td>
							<td><%=p.getFllegada()%></td>
							<td><%=p.getFentrega()%></td>
							<td><%=p.getDireccion()%></td>
							<td><%=p.getCodmod()%></td>
							<td><%=p.getCodestacion() %></td>
							<td><a href="crudprod?btnAccion=q&cod=<%=p.getCodprod()%>">
							<img alt="actualizar producto" src="img/actualiza.png">
							<td><a href="crudprod?btnAccion=b&cod=<%=p.getCodprod()%>">
							<img alt="borrar producto" src="img/elimina.png" width="70px">
							</a>
							</td>
						</tr>
						<%
						}
						}
						%>
					</table>
				</div>
			</section>
		</main>
	</div>
</body>
</html>