<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/WEB-INF/libreria.tld" prefix="tools" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registro de Usuarios</title>
<link href="css/estilo.css" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
<div id="formulario">
		<h1>Registro de Cuenta</h1>

		<form action="cruduser" method="post">
			<div class="form-group">
				<label for="inputNombre">Nombre</label> 
				<input name="txtNombre" type="text" class="form-control" id="inputNombre"
					 placeholder="Ingrese nombre">
			</div>
			<div class="form-group">
				<label for="inputApellido">Apellido</label> <input
					name="txtApellido" type="text" class="form-control" id="inputApellido"
					placeholder="Ingrese apellido">
			</div>
			
			<div class="form-group">
				<label for="inputUsuario">Usuario</label> 
				<input name="txtUsuario" type="email" class="form-control" id="inputUsuario"
					 placeholder="Ingrese correo">
			</div>
			<div class="form-group">
				<label for="inputPassword">Contraseña</label> <input name="txtPassword"
					type="password" class="form-control" id="inputPassword"
					placeholder="Password">
			</div>
			
			<div class="form-group">
				<label for="inputFecha">Fecha de Nacimiento</label> 
				<input name="txtFechaNacimiento" type="date" class="form-control" id="inputFecha"
					 placeholder="Año/Mes/Día">
			</div>
			<div class="form-group">
							<label for="inputEstadoCivil">Estado Civil</label> <select
								name="cboEstado" class="form-control"
								id="exampleFormControlSelect1">
								<option value="-1">Seleccione........</option>
								<tools:cboEstado/>
								
							</select>
						</div>
	
			<button type="submit" class="btn btn-primary" name="btnAccion" value="reg">Registrar</button>
		</form>
		<br>
		<p>Si ya tiene cuenta, ingrese <a href="login.jsp">aquí</a></p>

	</div>
${mensaje }
</body>
</html>