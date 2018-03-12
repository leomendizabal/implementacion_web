<jsp:useBean id='msgError' scope='request' class='java.lang.String' />  
<c:set var="context" value="${pageContext.request.contextPath}" />

<html>
  <head>
    <title>Mensaje de error</title>
  </head>
  <body>
  	<div class="error-container">
  		<img alt="error" src="resources/chef_error.png">
  		<span class="error">Ha ocurrido un error</span>
  		<a href="${context}/">Volver al inicio</a>
  	</div>
  </body>
</html>