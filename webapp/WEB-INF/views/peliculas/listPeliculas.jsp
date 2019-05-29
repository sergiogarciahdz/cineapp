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
<title>Listado de Peliculas</title>

<spring:url value="/resources" var="urlPublic" />
<spring:url value="/peliculas" var="urlRoot"></spring:url>

<link href="${ urlPublic }/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${ urlPublic }/bootstrap/css/theme.css" rel="stylesheet">

</head>

<body>

	<jsp:include page="../includes/navbar.jsp"></jsp:include>

	<div class="container theme-showcase" role="main">

		<h3>Listado de Peliculas</h3>
		
		<c:if test="${ msj != null }">
			<div class="alert alert-success" role="alert">
				<strong> ${ msj } </strong> 
				<button type="button" class="close" data-dismiss="alert" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
		</c:if>

		<a href="${ urlRoot }/create" class="btn btn-success" role="button"
			title="Nueva Pelicula">Nueva</a><br> <br>

		<div class="table-responsive">
			<table class="table table-hover table-striped table-bordered">
				<tr>
					<th>Titulo</th>
					<th>Genero</th>
					<th>Clasificacion</th>
					<th>Duracion</th>
					<th>Fecha Estreno</th>
					<th>Estatus</th>
					<th>Opciones</th>
				</tr>
				<c:forEach items="${ peliculas }" var="pelicula">
					<tr>
						<td>${ pelicula.titulo }</td>
						<td>${ pelicula.genero }</td>
						<td>${ pelicula.clasificacion }</td>
						<td>${ pelicula.duracion } min.</td>
						<td> <fmt:formatDate value="${ pelicula.fechaEstreno }" pattern="dd-MM-yyyy" /> </td>
						<td>
							<c:choose>
								<c:when test="${ pelicula.status=='Activa' }">
									<span class="label label-success">ACTIVA</span>
								</c:when>
								<c:otherwise>
									<span class="label label-danger">INACTIVA</span>
								</c:otherwise>
							</c:choose>
							
						</td>
						<td>
							<a href="${ urlRoot }/edit?id=${ pelicula.id }" class="btn btn-success btn-sm" role="button" title="Edit"><span class="glyphicon glyphicon-pencil"></span></a>
							<a href="${ urlRoot }/delete?id=${ pelicula.id }" onclick="return confirm('¿Estas seguro?')" class="btn btn-danger btn-sm" role="button" title="Eliminar"><span class="glyphicon glyphicon-trash"></span></a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>

		<hr class="featurette-divider">

		<!-- FOOTER -->
		<footer>
			<p class="pull-right">
				<a href="#">Back to top</a>
			</p>
			<p>
				&copy; 2017 My CineSite, Inc. &middot; <a href="#">Privacy</a>
				&middot; <a href="#">Terms</a>
			</p>
		</footer>

	</div>
	<!-- /container -->

	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
