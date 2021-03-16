<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro - Home</title>

<link href="/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

	<jsp:include page="comum/header-secretaria.jsp"></jsp:include>

	<spring:url value="/secretaria/cadastra" var="cadastra"></spring:url>
	<spring:url value="/secretaria/edita" var="edita"></spring:url>
	<spring:url value="/secretaria/deleta" var="deleta"></spring:url>
	
	
	<div class="container">
		<h1>Cadastro do Animal</h1>
		
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

		<form:form action="${cadastra}" modelAttribute="animal">
		
			<input type="hidden" name="id" id="id" value="${animal.id}" />

			<div class="form-group">
				<label for="nome">Nome:</label> <input type="text" name="nome"
					id="nome" value="${animal.nome}" class="form-control" />
			</div>

			<div class="form-group">
				<label for="especie">Especie:</label> <input type="text"
					name="especie" id="especie" value="${animal.especie}"
					class="form-control" />
			</div>

			<div class="form-group">
				<label for="raca">Raça:</label> <input type="text"
					name="raca" id="raca" value="${animal.raca}"
					class="form-control" />
			</div>

			<br>
			
			<div class="form-group">
				<label for="dataAgendamento">Data Nascimento:</label>
				<input type="date" name="dataNascimento" id="dataNascimento" value="${animal.dataNascimento}" class="form-control" />
			</div>
			<br>


			<c:if test="${animal.id == '0'}">
				<button type="submit" class="btn btn-primary">Cadastrar</button>
			</c:if>
			
			<c:if test="${animal.id != '0'}">
				<button type="submit" class="btn btn-primary">Editar</button>
			</c:if>

			<a href="/secretaria/area" class="btn btn-success">Voltar</a>
			
			
		</form:form>

		<c:if test="${not empty animais}">
			<table class="table">
				<tr>
					<th width="20%">Nome</th>
					<th width="20%">Especie</th>
					<th width="40%">Raça</th>
					<th width="20%">Data Nascimento</th>
					<th colspan="2" width="20%">Ações</th>
				</tr>

				<c:forEach var="animalT" items="${animais}">
					<tr>
						<td>${animalT.nome}</td>
						<td>${animalT.especie.nome}</td>
						<td>${animalT.raca.nome}</td>
						<td>${animalT.dataNascimento}</td>
						<td><a href="#" class="btn btn-warning">Editar</a></td>
						<td><a href="${deleta}/${animalT.id}" class="btn btn-danger">Deletar</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</div>




	<script type="text/javascript" src="/js/jquery-3.5.1.min.js"></script>
	<script type="text/javascript" src="/js/bootstrap.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			$('#divMensagemErro').delay(5000).fadeOut('slow');
			$('#divMensagemSucesso').delay(5000).fadeOut('slow');
		});
	</script>
</body>
</html>