
<%@page import="model.Producto"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>RastreoCiber</title>
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
			<%--<img alt="" src="img/bannercib.jpg" width="100%" height=150px> --%>
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
			<br>
			<br>
			<br>
			
		</main>
	</div>
</body>
</html>