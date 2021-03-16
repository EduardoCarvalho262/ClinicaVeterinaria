<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Secretária - Home</title>
<link href="/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
	<spring:url value="/secretaria/showForm" var="formAnimal"></spring:url>
	<spring:url value="/secretariaDono/showFormDono" var="formDono"></spring:url>
	<spring:url value="/atendimento/showFormCadastro" var="formAtendimento"></spring:url>

	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<div class="container-fluid">
			<a class="navbar-brand" href="/"> <img
				src="/img/suporte-tecnico.svg" alt="" width="30" height="24"
				class="d-inline-block align-top"> Área Secretaria
			</a>
			<form class="d-flex">
				<a href="/" class="btn btn-outline-success" type="submit">Voltar</a>
			</form>
		</div>
	</nav>
	


	<main class="container">
	
		<div class="starter-template text-center py-5 px-3">
			<h1>Serviços Disponíveis</h1>
		</div>




		<div class="row">
			<div class='col-4'>

				<div class="card" style="width: 18rem;">
					<img src="/img/animaisSecretaria.jpg" class="card-img-top" alt="..." style="height: 189px">
					<div class="card-body">
						<h5 class="card-title">Animais</h5>
						<p class="card-text">Realização de cadastro, atualização de informações.</p>
						<a href="${formAnimal}" class="btn btn-primary">Cadastrar</a>
					</div>
				</div>

			</div>

			<div class='col-4'>

				<div class="card" style="width: 18rem;">
					<img src="/img/clientesSecretaria.jpg" class="card-img-top" alt="...">
					<div class="card-body">
						<h5 class="card-title">Clientes</h5>
						<p class="card-text">Realização de cadastro, atualização de informações e adição do animal.</p>
						<a href="${formDono}" class="btn btn-primary">Cadastrar</a>
					</div>
				</div>

			</div>

			<div class='col-4'>

				<div class="card" style="width: 18rem;">
					<img src="/img/consultaSecretaria.jpg" class="card-img-top" alt="..." style="height: 189px">
					<div class="card-body">
						<h5 class="card-title">Consulta</h5>
						<p class="card-text">Marcar Consulta e informações sobre a consulta</p>
						<a href="${formAtendimento}" class="btn btn-primary">Marcar</a>
					</div>
				</div>

			</div>
		</div>
	</main>






	<script type="text/javascript" src="/js/jquery-3.5.1.min.js"></script>
	<script type="text/javascript" src="/js/bootstrap.min.js"></script>
</body>
</html>