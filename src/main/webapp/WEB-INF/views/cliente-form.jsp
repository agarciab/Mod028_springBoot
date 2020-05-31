<!-- Declaración del fichero como JSP -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!-- Importación de taglibs para la composición de la página -->
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- Importación de ficheros estáticos -->
<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
<script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>

</head>
<body>

 <div class="container">
  <div class="col-md-offset-2 col-md-10">
   <h3 class="text-center">Spring Boot 2 + Spring Data JPA 2 + JSP + H2 embedida
    Ejemplo - Gestión de clientes</h3>
   <div class="panel panel-info">
    <div class="panel-heading">
     <div class="panel-title">Añadir cliente</div>
    </div>
    <div class="panel-body">
    <!-- El uso de la etiqueta form generará un formulario WEb e identificará los campos que viajan al controlador -->
     <form:form action="saveCliente" cssClass="form-horizontal" method="post" modelAttribute="cliente">

      <form:hidden path="id" />

      <div class="form-group">
       <label for="firstname" class="col-md-3 control-label">Nombre</label>
       <div class="col-md-9">
       <!-- path debe coincidir con el atributo del objeto -->
        <form:input path="firstName" cssClass="form-control" />
       </div>
      </div>
      <div class="form-group">
       <label for="lastname" class="col-md-3 control-label">Apellidos</label>
       <div class="col-md-9">
        <form:input path="lastName" cssClass="form-control" />
       </div>
      </div>

      <div class="form-group">
       <label for="email" class="col-md-3 control-label">Email</label>
       <div class="col-md-9">
        <form:input path="email" cssClass="form-control" />
       </div>
      </div>

      <div class="form-group">
       <!-- Button -->
       <div class="col-md-offset-3 col-md-9">
        <form:button cssClass="btn btn-primary">Submit</form:button>
       </div>
      </div>

     </form:form>
    </div>
   </div>
  </div>
 </div>
</body>
</html>