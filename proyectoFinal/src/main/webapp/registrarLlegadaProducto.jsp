
<%@page import="mantenimientos.GestionProductos"%>
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
<link href="css/estilo.css" rel="stylesheet">

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>
			<br>
			<br>
			<br>
			
			<div id="formulario">
		<h1>Registro de Producto</h1>

		<form action="crudprod" method="post">
			<div class="form-group">
				<label for="inputCodigo">Codigo de Registro</label> 
				<input name="txtCodReg" value="${r.codreg}" type="text" class="form-control" id="inputCodigo"
				placeholder="Ingrese Codigo de Registro">
			</div>
			<div class="form-group">
				<label for="inputCodigo">Codigo de Producto</label> 
				<input name="txtCodigo" value="${r.codprod}" type="text" class="form-control" id="inputCodigo"
				placeholder="Ingrese Codigo de Producto">
			</div>
			<div class="form-group">
				<label for="inputCodigo">Descripcion</label> 
				<input name="txtDescripcion" value="${r.descripcion}" type="text" class="form-control" id="inputCodigo"
				placeholder="Ingrese Descripcion">
			</div>	
			<div class="form-group">
							<label for="inputEstacion">Estación</label> <select
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
			<div class="form-group">
				<label for="inputFecha">Hora de Llegada</label> 
				<input name="txtHllegada" value="${r.hllegada}" type="text" class="form-control" id="inputFecha"
					 placeholder="Ingrese la Hora">
			</div>
			<div class="form-group">
				<label for="inputFecha">Descripción del Estado Actual</label> 
				<input name="txtDescripcionActual" value="${r.descripcionActualProd}" type="text" class="form-control" id="inputFecha"
					 placeholder="Ingrese Estado del Producto ">
			</div>
			<button type="submit" class="btn btn-info" name="btnAccion" value="reg">Registrar</button>
			<p>Si desea ir a la página principal pulsa <a href="principalCliente.jsp">aquí</a></p>
		</form>
		${mensaje }
		<br>		
	</div>
			
		</main>
	</div>
</body>
</html>