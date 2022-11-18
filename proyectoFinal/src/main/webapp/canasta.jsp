<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>

<html lang="esS">
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>RastreoCiber</title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">

<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
<
	<div class="container">
		<header>
			<%--<img alt="" src="img/bannercib.jpg" width="100%" height=150px> --%>
			<h1>Reporte</h1>
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
			
			<div >
				<h1>Resumen de Informe</h1>
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
						<c:forEach items="${carroRastreo }" var="r">
							<tr class="grilla_campo">
								<td>${r.getCodreg() }</td>
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
				<br> <a href="" class="btn btn-primary">Agregar más productos
					<span class="glyphicon glyphicon-repeat"></span>
				</a>
			</div>
			<br><br><br><br><br><br>
			<div>
				<h1>Cantidad de Productos en el Informe</h1>
				<hr>
				<%-- muestra la variable global enviada desde el Listener --%>
				<label>Cantidad de Productos de Informe: (${cantProductos })</label>
				<hr>
				<form action="">
					<button class="btn btn-primary">
						Procesar compra <span class="glyphicon glyphicon-ok"></span>
					</button>
				</form>


			</div>

		</main>
	</div>


</body>
</html>

