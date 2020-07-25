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
	
	<h1>Usuário Selecionado</h1>
	Nome do usuário selecionado: ${usuario.nome}
	<form action="<c:url value="/editar" />" method="post">
		Nome: <input type="text" name="usuario.nome" value="${usuario.nome}"/>
		<br>
		<br>
		<fmt:formatDate var="fmtDate" value="${usuario.data}" pattern="dd/MM/yyyy"/>
		Data: <input id="data" type="text" name="usuario.data" value="${fmtDate}"/>
		<br>
		<br>
		Senha: <input type="password" name="usuario.senha" value="${usuario.senha}"/>
		<br>
		<br>
		<input type="hidden" name="usuario.id" value="${usuario.id}" />
		<input type="hidden" name="_method" value="put" />
		<input type="submit" value="Alterar" />
		
	</form>
	
</body>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.9.0/themes/base/jquery-ui.css" />
<script src="http://code.jquery.com/jquery-1.8.2.js"></script>
<script src="http://code.jquery.com/ui/1.9.0/jquery-ui.js"></script>
<script type="text/javascript" src="/estagio-cm/js/index/index.js"></script>
<script src="/estagio-cm/js/jquery.mask.min.js" type="text/javascript"></script>
<script>
jQuery("#data").mask("99/99/9999");
</script>
</html>