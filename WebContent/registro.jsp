<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registro</title>
<link href="css/estilo.css" rel="stylesheet" type="text/css">
</head>
<body>
<c:import url="/componentes/header.jsp"></c:import>
<div class="login">
		<form action="ServletPrincipal" method="post">
		<h1 class="user">Registro</h1>
		<table>
			<tr>
				<th><label>Introduce nombre de usuario</label> <input
					type="text" name="newuser" value="tu nombre"></th>

			</tr>
			<tr>
				<th><label>Introduce tu domicilio</label> <input type="text"
					name="newdom" value="tu domicilio"></th>
			</tr>
			
			<tr>
				<th><label>Introduce tu nif</label> <input type="text"
					name="newnif" value="tu nif"></th>
			</tr>

			<tr>
				<th><input type="submit"
					name="enviar" value="enviar">
					<input type="hidden" name="opcion" value="10">
					<input type="reset"
					name="reset" value="borrar">
					</th>
			</tr>
		</table>
		</form>
		
	</div>
</body>
</html>