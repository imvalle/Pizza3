<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Carrito</title>
<link href="css/estilo.css" rel="stylesheet" type="text/css">
</head>
<body>
<c:import url="/componentes/header.jsp"></c:import>
	<h1 class="client">Su compra
	<c:out value="${sessionScope.cliente.nombre}" />
	</h1>
<h3 id="fecha">
		<fmt:setLocale value="es_ES" />
		<c:set var="now" value="<%=new java.util.Date()%>" />
		<fmt:formatDate pattern="EEEE dd-MMMM-yyyy" value="${now}" />
	</h3>

	<table border="1">
		<tr>
			<th>Articulo</th>
			<th>Cantidad</th>
		</tr>
		<c:forEach var="artic" items="${articulos}">
			<c:if test="${artic.value>0}">
			<tr>
				<td><c:out value="${artic.key}" /></td>
				<td><c:out value="${artic.value}" /></td>
			</tr>
			</c:if>		
		</c:forEach>

	</table>

</body>
</html>