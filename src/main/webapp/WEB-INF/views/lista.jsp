<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de coches</title>
</head>
<body>

<table>
	<tr>
		<th>Marca</th>
		<th>Modelo</th>
		<th>Potencia</th>
	</tr>
	<c:forEach var="c" items="${coches}">
		<tr>
			<td>${c.marca}</td>
			<td>${c.modelo}</td>
			<td>${c.potencia} CV</td>
		</tr>
	</c:forEach>
		
</table>

</body>
</html>