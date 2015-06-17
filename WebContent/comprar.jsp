<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Pizza3 Comprar</title>
<link href="css/estilo.css" rel="stylesheet" type="text/css">
</head>
<body>

<c:import url="/componentes/header.jsp"></c:import>
	<h1>Pagina de compra</h1>
	
	<h1 class="client"> Hola 
	<c:out value= "${sessionScope.cliente.nombre}"/>
	</h1>

	<form method="post" action="ServletPrincipal">
		<table border="1">
			<tr>
				<th>Codigo</th>
				<th>Descripcion</th>
				<th>Precio</th>
				<th>Seleccionar
			</tr>
			<c:forEach items="${lista}" var="i">
		  <tr>
		     <td><c:out value="${i.getValue().getProductoid()}"></c:out></td>
		     <td><c:out value="${i.getValue().getNompro()}"></c:out></td>
		     <td><c:out value="${i.getValue().getPrecio()}"></c:out></td>
		     <td><input type="checkbox" name="articulo" value="${i.getValue().getNompro()}"></td>
		  </tr>
		</c:forEach>
	
			<tr>
				<td colspan=2><input type="submit" name="enviar" value="Enviar pedido">
					<input type="hidden" name="opcion" value="4"></td>
				<td colspan=2><input type="reset" name="borrar" value="Borrar articulos"></td>
			</tr>

		</table>

	</form>

	<ul id="nav2">
	    <li><a href="ServletPrincipal?opcion=5">Finalizar Pedido</a></li>
		<li><a href="ServletPrincipal?opcion=6">Borrar pedido</a></li>
		<li><a href="ServletPrincipal?opcion=7">Cerrar sesion</a></li>
		<li><a href="ServletPrincipal?opcion=8">Ver pedido</a></li>
	</ul>
</body>
</html>