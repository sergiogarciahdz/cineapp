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
      
      <a href="${ urlRoot }/create" class="btn btn-success" role="button" title="Nueva Horario" >Nuevo</a><br><br>
	
      <div class="table-responsive">
        <table class="table table-hover table-striped table-bordered">
            <tr>
                <th>Pelicula</th>
                <th>Opción</th>
            </tr>
           
           <c:forEach items="${ peliculas }" var="pelicula">
           		<tr>
                	<td>${ pelicula.titulo }</td> 			
	                <td>
						<a href="${ urlRoot }/horary?id=${ pelicula.id }" class="btn btn-info btn-sm" role="button" > Mostrar horarios</a>
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
