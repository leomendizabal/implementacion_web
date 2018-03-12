<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="context" value="${pageContext.request.contextPath}" />
<jsp:useBean id="escolaridad" scope="request" class="java.util.ArrayList" />
<jsp:useBean id="cedula" scope="request" class="java.lang.String"/>
<jsp:useBean id="error" scope="request" class="java.lang.String"/>

<html>
  <head>
    <title>Escolaridad</title>
    <link rel="stylesheet" type="text/css" href="styles/reset.css">
    <link rel="stylesheet" type="text/css" href="styles/style.css">
  </head>

  <body>
  	<header>
  		<span class="header-title">Escolaridad</span>  			
  	</header>
	<div class="menu">
		<div class="content-wrapper">
			<ul class="links-container">
				<li class="link-item"><a href="${context}/escolaridad">Escolaridad</a></li>
				<li class="link-item"><a href="${context}/egresados">Egresados</a></li>
			</ul>
			<div class="menu-title">
				<span class="letter">M</span>
				<span class="letter">E</span>
				<span class="letter">N</span>
				<span class="letter">U</span>
			</div>
		</div>
	</div>
	<div class="main-content-wrapper">
		<form method="GET" action="escolaridad">
			<input type="text" id="cedula" name="cedula" class="search-input" value="" placeholder="Cedula" required/>
  			<button type="submit" class="search-button">Buscar</button>
		</form>  		
		
		<c:choose>
			<c:when test = "${fn:length(escolaridad) > 0}">
				<table>
					<tr>
						<th>Numero</th>
						<th>Asignatura</th>
						<th>Año</th>
						<th>Calificacion</th>
					</tr>
					<c:forEach items="${escolaridad}" var="inscripcion">
						<tr>
						    <td>${inscripcion.numero}</td>
						    <td>${inscripcion.asignatura.nombre}</td>
						    <td>${inscripcion.anio}</td>
						    <td>${inscripcion.calificacion}</td>
					  	<tr>
					</c:forEach>
				</table>			
			</c:when>
			<c:when test = "${not empty error}">
				<span class="msg">${error}</span>
			</c:when>
			<c:when test = "${fn:length(escolaridad) == 0 && cedula}">
				<span class="msg">El alumno no cuenta con materias calificadas</span>
			</c:when>
		</c:choose>
  	</div>
  	<footer>
  		footer
  	</footer>
  </body>
</html>
