<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="context" value="${pageContext.request.contextPath}" />
<jsp:useBean id="egresados" scope="request" class="java.util.ArrayList" />

<html>
  <head>
    <title>Egresados</title>
    <link rel="stylesheet" type="text/css" href="styles/reset.css">
    <link rel="stylesheet" type="text/css" href="styles/style.css">
  </head>

  <body>
  	<header>
  		<span class="header-title">Egresados</span>  			
  	</header>
	<div class="menu">
		<div class="content-wrapper">
			<ul class="links-container">
				<li class="link-item"><a href="${context}/escolaridad">Escolaridad</a></li>
				<li class="link-item"><a href="${context}/egresados">Egresados</a></li>
				<li class="link-item inicio"><a href="${context}">Inicio</a></li>
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
		<c:choose>
			<c:when test = "${fn:length(egresados) > 0}">
		  		<table>
					<tr>
						<th>Cedula</th>
						<th>Nombre</th>
						<th>Apellido</th>
					</tr>
					<c:forEach items="${egresados}" var="alumno">
						<tr>
						    <td>${alumno.cedula}</td>
						    <td>${alumno.nombre}</td>
						    <td>${alumno.apellido}</td>
					  	<tr>
					</c:forEach>
				</table>
			</c:when>
			<c:otherwise>
				<span class="msg text-center no-egresado-msg">No existen egresados</span>
			</c:otherwise>	
		</c:choose>
  	</div>
  	<footer></footer>
  </body>
</html>