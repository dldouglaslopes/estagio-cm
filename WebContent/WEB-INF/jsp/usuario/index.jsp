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
	<!--<form action="/greeting" >
		It works!! Se apresente ${variable}
		<input type="text" id="nome" name="estagiario.nome" />
		<input id="btn_vai" type="button" value="Vai!" />
		<br/>
		<div id="resposta"></div>

	</form>-->
	<form action="<c:url value="/salvar" />" method="post">
		Nome: <input type="text" name="usuario.nome"/>
		<br>
		<br>
		Data: <input id="data" type="text" name="usuario.data"/>
		<br>
		<br>
		Senha: <input type="password" name="usuario.senha"/>
		<br>
		<br>
		<input type="submit" value="Salvar" />
		
	</form>
	<br>
	<br>
	<input id="pesquisar" type="button" value="Pesquisar" />
	<br>
	<br>
	<table border="1" style="width: 60%">
		<thead> 
			<tr>
				<th>ID</th>
				<th>Nome</th>
				<th>Data</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${usuarioList}" var="usuario">
				<tr>
					<td>${usuario.id}</td>
					<td>${usuario.nome}</td>
					<td>${usuario.data}</td>
					<td><a href="<c:url value="/usuarios/${usuario.id}"/>}">Editar</a></td>
					<td><a href="<c:url value="/delete/${fn:trim(usuario.id)}"/>">Excluir</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.9.0/themes/base/jquery-ui.css" />
<script src="http://code.jquery.com/jquery-1.8.2.js"></script>
<script src="http://code.jquery.com/ui/1.9.0/jquery-ui.js"></script>
<script type="text/javascript" src="/estagio-cm/js/index/index.js"></script>
<script>
$(function() {
    $( "#data" ).datepicker();
});
</script>
</html>