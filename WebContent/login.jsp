<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
<link href="css/estilo.css" rel="stylesheet" type="text/css">
</head>
<body>
	<c:import url="/componentes/header.jsp"></c:import>
	<div class="login">
		<form action="ServletPrincipal" method="post">
		<h1 class="user">Usuarios Registrados</h1>
		<table>
			<tr>
				<th><label>Introduce nombre de usuario</label> <input
					type="text" name="username" value="tu nombre"></th>

			</tr>
			<tr>
				<th><label>Introduce tu contraseña</label> <input type="text"
					name="password" value="tu nif"></th>
			</tr>

			<tr>
				<th><input type="submit"
					name="enviar" value="enviar">
					<input type="hidden" name="opcion" value="3">
					<input type="reset"
					name="reset" value="borrar">
					</th>
			</tr>
		</table>

		</form>
		<h1 class="user">Registrarse</h1>
		<p class="bot"><a href="ServletPrincipal?opcion=9">Registro</a></p>

	</div>

</body>
</html>