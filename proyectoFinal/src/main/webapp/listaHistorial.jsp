<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@page import="model.RegistroProductoLlegada"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Historial</title>
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
					<li><a href="crudprod?btnAccion=his">Historial de puntos
							de llegada</a></li>
					<br>
					<li><a href="login.jsp">Cerrar sesion</a></li>
				</ul>
			</nav>
			<br> <br> <br>
			<section style="width: 70%; float: right;">

				<h1>Historial de Llegada de llegada de Productos</h1>

				<div class="container">
					<table class="table">
						<tr>
							<th>Código de Registro</th>
							<th>Código de Producto</th>
							<th>Descripción</th>
							<th>Estación</th>
							<th>Hora de Llegada</th>
							<th>Descripción del Estado Actual</th>
							<th></th>

						</tr>
						<c:forEach items="${lstRegistro }" var="r">
							<tr class="grilla_campo">
								<td>${r.codreg }</td>
								<td>${r.getCodprod() }</td>
								<td>${r.getDescripcion() }</td>
								<td>${r.getCodestacion() }</td>
								<td>${r.getHllegada() }</td>
								<td>${r.descripcionActualProd }</td>

								<td><form action="crudprod" method="post">
										<input type="hidden" name="c" value="${r.codreg }">
										<button type="submit" name="btnAccion" value="env"
											class="btn btn-link">
											<img alt="actualizar producto" src="img/report.png">
										</button>
									</form></td>
							</tr>
						</c:forEach>


					</table>
				</div>
			</section>
		</main>
	</div>
</body>
</html>