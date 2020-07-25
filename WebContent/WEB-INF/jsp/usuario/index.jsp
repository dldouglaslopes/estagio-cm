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
	
	<h3> <span style="color: red;"> ${mensagem} </span></h3>
	
	<form action="<c:url value="/" />" method="get">
		<input type="submit" value="Logout" />
	</form>
	
	<h1> Cadastro de Usuários </h1>
	<form action="<c:url value="/salvar" />" method="post">
		Nome: <input id="nome" type="text" name="usuario.nome"/>
		<br>
		<br>
		CPF: <input id="cpf" type="text" name="usuario.cpf"/>
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
	
	<h1> Pesquisa de Usuários </h1>
	<form action="<c:url value="/pesquisar" />" method="get">
		Nome: <input type="text" name="usuario.nome"/>
		CPF: <input id="cpfp" type="text" name="usuario.cpf"/>
		<input id="pesquisar" type="submit" value="Pesquisar" />
	</form>
	
	<br>
	<br>
	<h1> Lista de Usuários </h1>
	<table border="1" style="width: 60%">
		<thead> 
			<tr>
				<th>ID</th>
				<th>Nome</th>
				<th>CPF</th>
				<th>Data</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${usuarioList}" var="usuario">
				<tr>
					<td>${usuario.id}</td>
					<td>${usuario.nome}</td>
					<td>${usuario.cpf}</td>
					<td><fmt:formatDate pattern="dd/MM/yyyy" value="${usuario.data}"/></td>
					<td><a href="<c:url value="/editar/${fn:trim(usuario.id)}"/>">Editar</a></td>
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
<script src="/estagio-cm/js/jquery.mask.min.js" type="text/javascript"></script>
<script>
jQuery("#data").mask("99/99/9999");
</script>
<script>
jQuery("#cpf").mask("999.999.999-99");
jQuery("#cpfp").mask("999.999.999-99");
</script>
</html>