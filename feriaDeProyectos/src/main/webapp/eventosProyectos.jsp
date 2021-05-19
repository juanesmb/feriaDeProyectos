<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listado de eventos y proyectos</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-p34f1UUtsS3wqzfto5wAAmdvj+osOnFyQFpp4Ua3gs/ZVWx6oOypYoCJhGGScy+8"
	crossorigin="anonymous"></script>
</head>
<body>

	<div class="container">
		<header>
			<nav class="navbar navbar-expand-md navbar-dark"
				style="background-color: tomato">
				<div>
					<a href="#" class="navbar-brand">Listado de eventos</a>
				</div>
				<ul class="navbar-nav">
					<li><a href="<%=request.getContextPath()%>/listEventos"
						class="nav-link">eventos</a></li>
				</ul>
			</nav>
		</header>
	</div>

	<br>
	<div class="container">
		<div class="row">
			<h3 class="text-center">Listado</h3>
			<hr>
			<form action="listProyectos" method="post">
				<select class="form-select" aria-label="Default select example"
					name="eventId">
					<option selected>seleccione un evento</option>
					<c:forEach var="i" items="${eventos}">
						<option value="${i.id}">"${i.nombre}"</option>
					</c:forEach>
				</select>
				<button type="submit" class="btn btn-success">Buscar</button>
			</form>

		</div>
	</div>

	<div class="container">
		<div class="row">
				<c:forEach var="i" items="${proyectos}">
					<div class="card" style="width: 18rem;">
						<div class="card-body">
							<h5 class="card-title">"${i.nombre}"</h5>
							<h6 class="card-subtitle mb-2 text-muted">
								<a href="${i.video}" target="_blank">Video</a>
							</h6>
							<p class="card-text">"${i.resumen}"</p>
							<p class="card-text">"${i.getTipo().getDescripcion()}"</p>
							<p class="card-text">"${i.getCat().getDescripcion()}"</p>
							<p class="card-text">"${i.getAsig().getNombre()}"</p>
						</div>
					</div>
				</c:forEach>
		</div>
</body>
</html>