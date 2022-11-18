<%@ taglib uri="/WEB-INF/libreria.tld" prefix="tools" %>
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
		<h1>Actualizar Método de Envío</h1>

		<form action="crudprod" method="post">
			<div class="form-group">
				<label for="inputCodigo">Código de Producto</label> 
				<input name="txtCodigo" value="${p.codprod }" readonly type="text" class="form-control" id="inputCodigo">
			</div>
			<div class="form-group">
				<label for="inputDescripcion">Descripción</label> <input
					name="txtDescripcion" value="${p.descripcion }" readonly type="text" class="form-control" id="inputDescripcion">
			</div>
			<div class="form-group">
				<label for="inputDescripcion">Cantidad</label> <input
					name="txtCantidad" value="${p.cantidad }" readonly type="text" class="form-control" id="inputDescripcion">
			</div>
			<div class="form-group">
				<label for="inputDescripcion">Fecha de Llegada</label> <input
					name="txtFllegada" value="${p.fllegada }" readonly type="text" class="form-control" id="inputDescripcion">
			</div>
			<div class="form-group">
				<label for="inputDescripcion">Fecha de Entrega</label> <input
					name="txtFentrega" value="${p.fentrega }" readonly type="text" class="form-control" id="inputDescripcion">
			</div>
			<div class="form-group">
				<label for="inputDescripcion">Dirección (En caso de ser Recojo en tienda, dejar vacío)</label> <input
					name="txtDireccion" value="${p.direccion }" type="text" class="form-control" id="inputDescripcion">
			</div>
			<div class="form-group">
							<label for="inputEstacion">Modalidad de Entrega</label> <select
								name="cboEntrega" class="form-control"
								id="exampleFormControlSelect1">
								<option value="-1">Seleccione........</option>
								<tools:cboModCompra/>
								
							</select>
						</div>
			<div class="form-group">
							<label for="inputEstacion">Estacion</label> <select
								name="cboEstacion" class="form-control"
								id="exampleFormControlSelect1">
								<option value="-1">Seleccione........</option>
								<option value="1">Abancay</option>
								<option value="2">Arequipa</option>
								<option value="3">Cusco</option>
								<option value="4">Lima</option>
								<option value="5">Trujillo</option>
								<option value="6">Ica</option>
								
							</select>
						</div>
						
			<button type="submit" class="btn btn-primary" name="btnAccion" value="act">Actualizar</button>
		</form>
		${mensaje }
	</section>
			
		</main>
	</div>
</body>
</html>