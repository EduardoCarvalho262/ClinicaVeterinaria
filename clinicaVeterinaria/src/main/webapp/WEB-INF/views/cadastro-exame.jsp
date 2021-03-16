<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Exame</title>

<link href="/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>

	<spring:url value="/exame/cadastra" var="cadastra"></spring:url>
	<spring:url value="/exame/deleta" var="deleta"></spring:url>
	<spring:url value="/exame/showSelecionaVeterinario" var="adicionaVeterinario"></spring:url>
	
	<jsp:include page="comum/header-veterinario.jsp"></jsp:include>

	<div class="container">

		<h1>Cadastro de Exame</h1>
		
		<c:if test="${not empty erro}">
			<div id="divMensagemErro" class="alert alert-danger" role="alert">
				${erro}
			</div>
		</c:if>
		
		<c:if test="${not empty sucesso}">
			<div id="divMensagemSucesso" class="alert alert-success" role="alert">
				${sucesso}
			</div>
		</c:if>
		
		
		<form:form action="cadastra" modelAttribute="exame">
		
			<input type="hidden" name="id" id="id" value="${exame.id}" />
		
			<div class="form-group">
				<label for="nome">Nome:</label>
				<input type="text" name="nome" id="nome" value="${exame.nome}" class="form-control" />
			</div>
			
			<br>
			
			<c:if test="${exame.id == '0'}">
				<button type="submit" class="btn btn-primary">Cadastrar</button>
			</c:if>
			
			<c:if test="${exame.id != '0'}">
				<button type="submit" class="btn btn-primary">Editar</button>
			</c:if>
			
			
			<a href="/veterinario/area" class="btn btn-success">Voltar</a>
			
		</form:form>
		
		<c:if test="${not empty exames}">
			<table class="table">
				<tr>
					<th width="40%">Nome</th>
					<th colspan="3" width="20%">Ações</th>
				</tr>

				<c:forEach var="exame" items="${exames}">
					<tr>
						<td>${exame.nome}</td>
						<td><a href="#" class="btn btn-warning">Editar</a></td>
						<td><a href="${deleta}/${exame.id}" class="btn btn-danger">Deletar</a></td>
						<td><a href="${adicionaVeterinario}/${exame.id}" class="btn btn-dark">Veterinario</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>

	</div>





	<script type="text/javascript"  src="/js/jquery-3.5.1.min.js"></script>
	<script type="text/javascript"  src="/js/bootstrap.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			$('#divMensagemErro').delay(5000).fadeOut('slow');
			$('#divMensagemSucesso').delay(5000).fadeOut('slow');
		});
	</script>
</body>
</html>