<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tratamentos - Cadastro</title>

<link href="/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>

	<spring:url value="/tratamento/cadastra" var="cadastra"></spring:url>
	<spring:url value="/tratamento/deleta" var="deleta"></spring:url>
	<spring:url value="/tratamento/showSelecionaVeterinarios" var="adiciona"></spring:url>
	<spring:url value="/tratamento/showSelecionaMedicamentos" var="adicionaMedicamentos"></spring:url>
	
	<jsp:include page="comum/header-veterinario.jsp"></jsp:include>

	<div class="container">

		<h1>Cadastro de Tratamento</h1>
		
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
		
		
		<form:form action="cadastra" modelAttribute="tratamento">
		
			<input type="hidden" name="id" id="id" value="${tratamento.id}" />
		
			<div class="form-group">
				<label for="horarioAplicacao">Horario Aplicação:</label>
				<input type="text" name="horarioAplicacao" id="horarioAplicacao" value="${tratamento.horarioAplicacao}" class="form-control" />
			</div>
			
			<div class="form-group">
				<label for="quantidade">Quantidade:</label>
				<input type="number" name="quantidade" id="quantidade" value="${tratamento.quantidade}" class="form-control" />
			</div>
			
			<div class="form-group">
				<label for="diagnostico">Diagnostico:</label>
				<input type="text" name="diagnostico" id="diagnostico" value="${tratamento.diagnostico}" class="form-control" />
			</div>
			
			<br>
			
			<c:if test="${tratamento.id == '0'}">
				<button type="submit" class="btn btn-primary">Cadastrar</button>
			</c:if>
			
			<c:if test="${tratamento.id != '0'}">
				<button type="submit" class="btn btn-primary">Editar</button>
			</c:if>
			
			
			<a href="/veterinario/area" class="btn btn-success">Voltar</a>
			
		</form:form>
		
		<c:if test="${not empty tratamentos}">
			<table class="table">
				<tr>
					<th width="40%">Horario Aplicação</th>
					<th width="20%">Quantidade</th>
					<th width="20%">Diagnostico</th>
					<th colspan="4" width="20%">Ações</th>
				</tr>

				<c:forEach var="tratamento" items="${tratamentos}">
					<tr>
						<td>${tratamento.horarioAplicacao}</td>
						<td>${tratamento.quantidade}</td>
						<td>${tratamento.diagnostico}</td>
						<td><a href="#" class="btn btn-warning">Editar</a></td>
						<td><a href="${deleta}/${tratamento.id}" class="btn btn-danger">Deletar</a></td>
						<td><a href="${adiciona}/${tratamento.id}" class="btn btn-dark">Veterinario</a></td>
						<td><a href="${adicionaMedicamentos}/${tratamento.id}" class="btn btn-dark">Medicamentos</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
		
		<h2>Medicamentos do Tratamento</h2>
		<hr>
		
		<c:if test="${not empty medicamentos}">
			<table class="table">
				<tr>
					<th width="40%">Nome</th>
					<th width="20%">Descricao</th>
				</tr>

				<c:forEach var="medicamento" items="${medicamentos}">
					<tr>
						<td>${medicamento.nome}</td>
						<td>${medicamento.descricao}</td>
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