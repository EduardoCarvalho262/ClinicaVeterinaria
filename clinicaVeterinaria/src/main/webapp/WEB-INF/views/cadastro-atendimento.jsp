<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Consultas</title>

<link href="/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>

	<spring:url value="/atedimento/cadastra" var="cadastra"></spring:url>
	<spring:url value="/atendimento/deleta" var="deleta"></spring:url>
	<spring:url value="/atendimento/showSelecionaVeterinario" var="adicionaVeterinario"></spring:url>
	<spring:url value="/atendimento/showSelecionaAnimal" var="adicionaAnimal"></spring:url>
	
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<div class="container-fluid">
			<a class="navbar-brand" href="/"> <img
				src="/img/admin.svg" alt="" width="30" height="24"
				class="d-inline-block align-top"> Área Admin
			</a>
		</div>
	</nav>

	<div class="container">

		<h1>Consultas</h1>
		
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
		
		
		<form:form action="cadastra" modelAttribute="atendimento">
		
			<input type="hidden" name="id" id="id" value="${atendimento.id}" />
		
			<div class="form-group">
				<label for="horario">Horario Consulta:</label>
				<input type="text" name="hora" id="hora" value="${atendimento.hora}" class="form-control" />
			</div>
			
			<div class="form-group">
				<label for="dia">Dia:</label>
				<input type="date" name="dia" id="dia" value="${atendimento.dia}" class="form-control" />
			</div>
			
			<div class="form-group">
				<label for="quantidade">Tipo:</label>
				<input type="text" name="tipo" id="tipo" value="${atendimento.tipo}" class="form-control" />
			</div>
			
			<div class="form-group">
				<label for="custo">Custo:</label>
				<input type="number" name="custo" id="custo" value="${atendimento.custo}" class="form-control" />
			</div>
			
			<br>
			
			<c:if test="${atendimento.id == '0'}">
				<button type="submit" class="btn btn-primary">Cadastrar</button>
			</c:if>
			
			<c:if test="${atendimento.id != '0'}">
				<button type="submit" class="btn btn-primary">Editar</button>
			</c:if>
			
			
			<a href="/secretaria/area" class="btn btn-success">Voltar</a>
			
		</form:form>
		
		<c:if test="${not empty atendimentos}">
			<table class="table">
				<tr>
					<th width="40%">Horario Consulta</th>
					<th width="20%">dia</th>
					<th width="20%">Tipo</th>
					<th width="20%">Custo</th>
					<th width="20%">Veterinario</th>
					<th width="20%">Animal</th>
					<th colspan="4" width="20%">Ações</th>
				</tr>

				<c:forEach var="atendimento" items="${atendimentos}">
					<tr>
						<td>${atendimento.hora}</td>
						<td>${atendimento.dia}</td>
						<td>${atendimento.tipo}</td>
						<td>${atendimento.custo}</td>
						<td>${atendimento.veterinario.nome}</td>
						<td>${atendimento.animal.nome}</td>
						<td><a href="#" class="btn btn-warning">Editar</a></td>
						<td><a href="${deleta}/${atendimento.id}" class="btn btn-danger">Deletar</a></td>
						<td><a href="${adicionaVeterinario}/${atendimento.id}" class="btn btn-dark">Veterinario</a></td>
						<td><a href="${adicionaAnimal}/${atendimento.id}" class="btn btn-dark">Animal</a></td>
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