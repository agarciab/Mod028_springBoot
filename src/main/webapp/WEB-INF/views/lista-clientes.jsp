<!-- Declaración del fichero como JSP -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!-- Importación de taglibs para la composición de la página -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- Importación de ficheros estáticos -->
<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
<%@ page isELIgnored="false"%>
<script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</head>
<body>
 <div class="container">
  <div class="col-md-offset-1 col-md-10">
   <h3 class="text-center">Spring Boot 2 + Spring Data JPA 2 + JSP +
    H2 embedida Ejemplo - Gestión de clientes</h3>
   <hr />

   <input type="button" value="Añadir Cliente"
    onclick="window.location.href='showForm'; return false;"
    class="btn btn-primary" /> <br />
   <br />
   <div class="panel panel-info">
    <div class="panel-heading">
     <div class="panel-title">Lista de Clientes</div>
    </div>
    <div class="panel-body">
     <table class="table table-striped table-bordered">
      <tr>
       <th>Nombre</th>
       <th>Apellido</th>
       <th>Email</th>
       <th>Accion</th>
      </tr>
		<!-- Mediante la etiqueta c podemos definir estructuras de control -->
       <c:forEach var="tempCliente" items="${clientes}">
       <c:url var="updateLink" value="/cliente/updateForm">
       <!-- Accedemos a los atributos usando Expression Languaje (EL) ${objeto.atributo} -->
        <c:param name="clienteId" value="${tempCliente.id}" />
       </c:url>

       <c:url var="deleteLink" value="/cliente/delete">
        <c:param name="clienteId" value="${tempCliente.id}" />
       </c:url>

       <tr>
        <td>${tempCliente.firstName}</td>
        <td>${tempCliente.lastName}</td>
        <td>${tempCliente.email}</td>

        <td>
           <a href="${updateLink}">Update</a>
         | <a href="${deleteLink}"
         onclick="if (!(confirm('Estás seguro de borrar este cliente?'))) return false">Delete</a>
        </td>

       </tr>

      </c:forEach>

     </table>

    </div>
   </div>
  </div>

 </div>
 
</body>

</html>