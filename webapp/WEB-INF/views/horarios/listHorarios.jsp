<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">   
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Listado de Horarios</title>
  
<spring:url value="/resources" var="urlPublic" />
<spring:url value="/horario" var="urlRoot"></spring:url>

<link href="${ urlPublic }/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${ urlPublic }/bootstrap/css/theme.css" rel="stylesheet">
    
  </head>

  <body>

    <jsp:include page="../includes/navbar.jsp"></jsp:include>

    <div class="container theme-showcase" role="main">

      <h3>Listado de Horarios</h3>
    
      <div class="table-responsive">
        <table class="table table-hover table-striped table-bordered">
            <tr>
                <th>Fecha</th>
                <th>Hora</th>
                <th>Sala</th>
                <th>Precio</th>
                <th>Opciones</th>
            </tr>
            
            <c:forEach items="${ horarios }" var="horario">
	            <tr>
	                <td><fmt:formatDate value="${ horario.fecha }" pattern="dd-MM-yyyy" /></td>
	                <td>${ horario.hora } hrs</td> 
	                <td>${ horario.sala }</td>    
	                <td>$ ${ horario.precio }</td>        
	                <td>
						<a href="${ urlRoot }/edit?id=${ horario.id }" class="btn btn-success btn-sm" role="button" title="Edit" ><span class="glyphicon glyphicon-pencil"></span></a>
						<a href="${ urlRoot }/delete?id=${ horario.id }" onclick="return confirm('¿Estas seguro?')" class="btn btn-danger btn-sm" role="button" title="Delete" ><span class="glyphicon glyphicon-trash"></span></a>
					</td>
	            </tr>
            </c:forEach>
            
        </table>
      </div>
      <hr class="featurette-divider">

      <!-- FOOTER -->
      <footer>        
        <p class="pull-right"><a href="#">Back to top</a></p>
        <p>&copy; 2017 My CineSite, Inc. &middot; <a href="#">Privacy</a> &middot; <a href="#">Terms</a></p>
      </footer>

    </div> <!-- /container -->

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script> 
    <script src="bootstrap/js/bootstrap.min.js"></script> 

  </body>
</html>
