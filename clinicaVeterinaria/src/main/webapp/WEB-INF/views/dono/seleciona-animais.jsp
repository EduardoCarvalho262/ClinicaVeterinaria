<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Seleciona Animais</title>
<link href="/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	
	<jsp:include page="../comum/header-secretaria.jsp"></jsp:include>
	<spring:url value="/secretariaDono/search" var="search"></spring:url>
	<spring:url value="/secretariaDono/adicionaAnimal" var="adiciona"></spring:url>
	
	<div class="container">

		<c:if test="${not empty sucesso}">
			<div id="divMensagemSucesso" class="alert alert-success" role="alert">
				${sucesso}</div>
		</c:if>

		<br>
		<form:form action="${search}">
			<div class="input-group mb-3">
				<input type="text" class="form-control"
					placeholder="Pesquisar"
					aria-label="Pesquisar" aria-describedby="button-addon2" name="PesquisaAnimal">
				<button class="btn btn-outline-secondary" type="submit"
					id="button-addon2">Pesquisar</button>
			</div>
		</form:form>

		<br>
		<table class="table">
				<tr>
					<th width="20%">Nome</th>
					<th width="20%">Especie</th>
					<th width="40%">Raça</th>
					<th width="20%">Data Nascimento</th>
					<th colspan="2" width="20%">Ação</th>
				</tr>
				
			<c:forEach var="animal" items="${listaAnimais}">
				<c:if test="${animal.dono == null}">
					<tr>
						<td>${animal.nome}</td>
						<td>${animal.especie.nome}</td>
						<td>${animal.raca.nome}</td>
						<td>${animal.dataNascimento}</td>
						<td><a href="${adiciona}/${animal.id}" class="btn btn-warning">Adicionar</a></td>
					</tr>
				</c:if>
			</c:forEach>
			</table>
			
			
			<a href="/secretariaDono/showFormDono" class="btn btn-success">Voltar</a>
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