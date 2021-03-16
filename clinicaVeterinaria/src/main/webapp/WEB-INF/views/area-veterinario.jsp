<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Veterinario - Home</title>
<link href="/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
	<spring:url value="/tratamento/showFormTratamento" var="tratamento"></spring:url>
	<spring:url value="/exame/showFormExame" var="exame"></spring:url>


	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<div class="container-fluid">
			<a class="navbar-brand" href="/"> <img src="/img/veterinario.svg"
				alt="" width="30" height="24" class="d-inline-block align-top">
				Área Veterinario
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




		<div class="row row justify-content-around">
			<div class='col-4'>

				<div class="card" style="width: 18rem;">
					<img src="/img/examesVeterinario.jpg" class="card-img-top" alt="...">
					<div class="card-body">
						<h5 class="card-title">Exames</h5>
						<p class="card-text">Realização de cadastro, atualização de informações.</p>
						<a href="${exame}" class="btn btn-primary">Cadastrar</a>
					</div>
				</div>

			</div>

			<div class='col-4'>

				<div class="card" style="width: 18rem;">
					<img src="/img/tratamentoVeterinario.jpg" class="card-img-top" alt="...">
					<div class="card-body">
						<h5 class="card-title">Tratamentos</h5>
						<p class="card-text">Realização de cadastro, atualização de informações e adição do animal.</p>
						<a href="${tratamento}" class="btn btn-primary">Cadastrar</a>
					</div>
				</div>
			</div>
		</div>
	</main>






	<script type="text/javascript" src="/js/jquery-3.5.1.min.js"></script>
	<script type="text/javascript" src="/js/bootstrap.min.js"></script>
</body>
</html>