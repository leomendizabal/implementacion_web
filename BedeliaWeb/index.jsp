<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="context" value="${pageContext.request.contextPath}" />

<html>
  <head>
    <title>Bedelia</title>
    <link rel="stylesheet" type="text/css" href="styles/reset.css">
    <link rel="stylesheet" type="text/css" href="styles/style.css">
  </head>

  <body>
  	<header>
  		<span class="header-title">Sistema de bedelias</span>  			
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
  		<img alt="background" src="resources/cheff.jpg" />
  	</div>
  	<footer></footer>
  </body>
</html>