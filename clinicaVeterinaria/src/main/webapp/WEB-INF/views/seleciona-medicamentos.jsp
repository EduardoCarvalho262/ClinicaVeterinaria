<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Seleciona  Medicamentos</title>
<link href="/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	
	
	<spring:url value="/tratamento/searchMed" var="search"></spring:url>
	<spring:url value="/secretariaDono/voltaCadastro" var="voltaCadastro"></spring:url>
	<spring:url value="/tratamento/adicionaMedicamento" var="adiciona"></spring:url>
	
	<jsp:include page="comum/header-admin.jsp"></jsp:include>

	
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
					aria-label="Pesquisar" aria-describedby="button-addon2" name="PesquisaMedicamento">
				<button class="btn btn-outline-secondary" type="submit"
					id="button-addon2">Pesquisar</button>
			</div>
		</form:form>

		<br>
		<table class="table">
				<tr>
					<th width="40%">Nome</th>
					<th width="20%">Descricao</th>
					<th width="20%">Ação</th>
				</tr>

				<c:forEach var="medicamento" items="${medicamentos}">
					<tr>
						<td>${medicamento.nome}</td>
						<td>${medicamento.descricao}</td>
						<td><a href="${adiciona}/${medicamento.id}" class="btn btn-warning">Adicionar</a></td>
				</tr>
				</c:forEach>
			</table>
			
			
			<a href="/tratamento/showFormTratamento" class="btn btn-success">Voltar</a>
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