<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bienvenido a Cineapp</title>
<spring:url value="/resources" var="urlPublic" />
<link rel="stylesheet" href="${urlPublic}/bootstrap/css/bootstrap.min.css">


</head>
<body>
	<%-- <h1>Lista de peliculas</h1>
	<ul>
		<c:forEach items="${peliculas}" var="pelicula">
			<li>${pelicula}</li>
		</c:forEach>
	</ul> --%>

	<div class="card">
		<h5 class="card-header">Lista de Peliculas</h5>
		<div class="card-body">
			<table class="table table-hover">
				<thead class="thead-dark">
					<tr>
						<th>Id</th>
						<th>Titulo</th>
						<th>Duración</th>
						<th>Clasificación</th>
						<th>Genero</th>
						<th>Imagen</th>
						<th>Fecha Estreno</th>
						<th>Estatus</th>

					</tr>
				</thead>
				<tbody>
					<c:forEach items="${peliculas}" var="pelicula">
						<tr>
							<td>${pelicula.id}</td>
							<td>${pelicula.titulo}</td>
							<td>${pelicula.duracion}min.</td>
							<td>${pelicula.clasificacion}</td>
							<td>${pelicula.genero}</td>
							<td><img alt="" src="${urlPublic}/images/${pelicula.imagen}"
								width="80px" height="100px"></td>
							<td><fmt:formatDate value="${pelicula.fechaEstreno}"
									pattern="dd-MM-yyyy" /></td>
							<td><c:choose>
									<c:when test="${pelicula.estatus=='Activa'}">
										<span class="badge badge-success">ACTIVA</span>
									</c:when>
									<c:otherwise>
										<span class="badge badge-danger">INACTIVA</span>
									</c:otherwise>
								</c:choose></td>
						</tr>
					</c:forEach>

				</tbody>
			</table>
		</div>
	</div>



</body>
</html>