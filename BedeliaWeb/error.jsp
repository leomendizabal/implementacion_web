<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:useBean id='error' scope='request' class='java.lang.String' /> 
<c:set var="context" value="${pageContext.request.contextPath}" />

<html>
  <head>
  	<link rel="stylesheet" type="text/css" href="styles/reset.css">
    <link rel="stylesheet" type="text/css" href="styles/style.css">
    <title>Mensaje de error</title>
  </head>
  <body>
  	<div class="error-container">
  		<img alt="error" src="resources/chef_error.png">
  		<span class="error">Ha ocurrido un error</span>
  		<span class="exception">${error}</span>
  		<a href="${context}/">Volver al inicio</a>
  	</div>
  </body>
</html>