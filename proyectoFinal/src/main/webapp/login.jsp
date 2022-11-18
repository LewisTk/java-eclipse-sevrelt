<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html> 
<head>
<meta charset="ISO-8859-1">
<title>RastreoCiber</title>
<link href="css/estilo.css" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div id="formulario">
		<h1>Ingreso a RastreoCiber</h1>

		<form action="cruduser" method="post">
			<div class="form-group">
				<label for="inputUsuario">Usuario</label> 
				<input name="txtUsuario" type="email" class="form-control" id="inputUsuario"
					 placeholder="Ingrese correo">
			</div>
			<div class="form-group">
				<label for="inputPassword">Contraseña</label> <input
					name="txtPassword" type="password" class="form-control" id="inputPassword"
					placeholder="Password">
			</div>
	
			<button type="submit" class="btn btn-primary" name="btnAccion" value="log">Ingresar</button>
		</form>
		<br>
		<p>Para registrar su cuenta, pulse <a href="registro.jsp">aquí</a></p>

	</div>
	
	${mensaje }
</body>
</html>