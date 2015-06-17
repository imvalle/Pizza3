<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Su compra</title>
<link href="css/estilo.css" rel="stylesheet" type="text/css">
</head>
<body>
	<c:import url="/componentes/header.jsp"></c:import>
	<h1 class="client">
		Su factura
		<c:out value="${sessionScope.cliente.nombre}" />
	</h1>

	<table border="1">
		<tr>
			<th>Codigo Cliente</th>
			<th>Fecha</th>
			<th>Nº Factura</th>
		</tr>

		<tr>
			<td><c:out value="${sessionScope.factura.getClienteid()}"></c:out></td>
			<td>
			<fmt:setLocale value="es_ES" />
            <fmt:formatDate pattern="EEEE dd-MMMM-yyyy" value="${sessionScope.factura.getFecha()}" />
			</td>
			<td><c:out value="${sessionScope.factura.getFacturaid()}"></c:out></td>
		</tr>

		<tr>
			<th>Nombre</th>
			<th>Nif</th>
			<th>Total</th>
		</tr>

		<tr>
			<td><c:out value="${sessionScope.cliente.getNombre()}"></c:out></td>
			<td><c:out value="${sessionScope.cliente.getNif()}"></c:out></td>
			<td>
			<fmt:setLocale value="es_ES" />
			<c:set var="total" value="${sessionScope.factura.getTotal()}" />
		    <fmt:formatNumber value="${total}" type="currency" />
			</td>

		</tr>

	</table>

</body>
</html>