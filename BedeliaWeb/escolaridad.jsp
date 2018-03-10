<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="context" value="${pageContext.request.contextPath}" />
<jsp:useBean id="escolaridad" scope="request" class="java.util.ArrayList" />

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
			<input type="text" id="cedula" name="cedula" class="search-input" value="" placeholder="Cedula"/>
  			<button type="submit" class="search-button">Buscar</button>
		</form>  		

		<table>
			<tr>
				<th>Numero</th>
				<th>Asignatura</th>
				<th>Año</th>
				<th>Calificacion</th>
			</tr>
			<tr>
				<td>119</td>
				<td>Ingles</td>
				<td>2018</td>
				<td>10</td>
			</tr>
			<tr>
				<td>120</td>
				<td>Frances</td>
				<td>2018</td>
				<td>9</td>
			</tr>
		</table>
  	</div>
  	<footer>
  		footer
  	</footer>
  </body>
</html>