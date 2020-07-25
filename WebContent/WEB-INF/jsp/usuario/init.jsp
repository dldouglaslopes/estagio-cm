<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Casa Magalhães - Estagiários Project</title>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<c:set var="ctx">${pageContext.request.contextPath}</c:set>
<fmt:setLocale value="pt_BR" />
</head>
<body>
	<span id="ctx" style="display: none">${ctx}</span>
	
	<h1>Login</h1>
	
	<form action="<c:url value="/login" />" method="get">
		CPF: <input id="cpf" type="text" name="usuario.cpf"/>
		<br>
		<br>
		Senha: <input type="password" name="usuario.senha"/>
		<br>
		<br>
		<input type="submit" value="Login" />
	</form>
	<br>
	<br>
	<form action="<c:url value="/index" />" method="get">
		<input type="submit" value="Cadastro / Consulta" />
	</form>
	
</body>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.9.0/themes/base/jquery-ui.css" />
<script src="http://code.jquery.com/jquery-1.8.2.js"></script>
<script src="http://code.jquery.com/ui/1.9.0/jquery-ui.js"></script>
<script type="text/javascript" src="/estagio-cm/js/index/index.js"></script>
</html>