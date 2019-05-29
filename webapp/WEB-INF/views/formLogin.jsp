<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="author" content="">
<title>Login</title>

<spring:url value="/resources" var="urlPublic" />
<spring:url value="/" var="urlRoot"></spring:url>

<link rel="stylesheet"
	href="${urlPublic}/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="${urlPublic}/bootstrap/css/theme.css">
</head>
<body>
	
	<jsp:include page="includes/navbar.jsp"></jsp:include>

	<div class="container">
		<form action="${ urlRoot }login" method="POST">

			<c:if test="${param. error != null}">
				<img src="${urlPublic}/img/error.png" width="48" height="48" class="center">
				<h4 class="form-signin-heading" style="color: red">Acceso denegado</h4>
			</c:if>

			<div class="form-group">
				<label>UserName</label> <input type="text" class="form-control"
					name="username" />
			</div>
			<div class="form-group">
				<label>Password</label> <input type="password" class="form-control"
					name="password" />
			</div>
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
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


	<!-- Bootstrap core JavaScript
      ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
