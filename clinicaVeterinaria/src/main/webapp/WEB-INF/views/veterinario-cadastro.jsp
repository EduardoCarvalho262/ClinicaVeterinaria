<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Veterinarios - Cadastro</title>

<link href="/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>

	<spring:url value="/veterinario/cadastra" var="cadastra"></spring:url>
	<spring:url value="/veterinario/deleta" var="deleta"></spring:url>
	<spring:url value="/veterinario/showSelecionaEspecialidades" var="seleciona"></spring:url>
	
	<jsp:include page="comum/header-admin.jsp"></jsp:include>

	<div class="container">

		<h1>Cadastro de Veterinario</h1>
		
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
		
		
		<form:form action="cadastra" modelAttribute="veterinario">
		
			
			<div class="form-group">
				<label for="crmv">CRMV:</label>
				<form:input path="crmv" id="crmv" class="form-control" />
			</div>
			
			<div class="form-group">
				<label for="nome">Nome:</label>
				<input type="text" name="nome" id="nome" value="${veterinario.nome}" class="form-control" />
			</div>
			
			<div class="form-group">
				<label for="endereco">Endereço:</label>
				<input type="text" name="endereco" id="endereco" value="${veterinario.endereco}" class="form-control" />
			</div>
			
			<br>
			
			<div class="form-group">
				<label for="telefone">Telefone:</label>
				<input type="number" name="telefone" id="telefone" value="${veterinario.telefone}" class="form-control" />
			</div>
			
			<br>
			
			<div class="form-group">
				<label for="plantao">Plantão:</label>
				<input type="text" name="plantao" id="plantao" value="${veterinario.plantao}" class="form-control" />
			</div>
			
			<br>


			<button type="submit" class="btn btn-primary">Cadastrar</button>



			<a href="/admin/area" class="btn btn-success">Voltar</a>
			
		</form:form>
		
		<c:if test="${not empty veterinarios}">
			<table class="table">
				<tr>
					<th width="20%">CRMV</th>
					<th width="20%">Nome</th>
					<th width="20%">Endereço</th>
					<th width="20%">Telefone</th>
					<th width="20%">Plantão</th>
					<th width="20%">Especialidades</th>
					<th colspan="3" width="20%">Ações</th>
				</tr>

				<c:forEach var="veterinario" items="${veterinarios}">
					<tr>
						<td>${veterinario.crmv}</td>
						<td>${veterinario.nome}</td>
						<td>${veterinario.endereco}</td>
						<td>${veterinario.telefone}</td>
						<td>${veterinario.plantao}</td>
						<td>${veterinario.especialidades}</td>
						<td><a href="#" class="btn btn-warning">Editar</a></td>
						<td><a href="${deleta}/${veterinario.crmv}" class="btn btn-danger">Deletar</a></td>
						<td><a href="${seleciona}/${veterinario.crmv}" class="btn btn-info">Especialidades</a></td>
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