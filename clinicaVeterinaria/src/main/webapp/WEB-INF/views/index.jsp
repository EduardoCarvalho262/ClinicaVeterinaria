<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Clínica - Home</title>
<link href="/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

	<spring:url value="/secretaria/area" var="secretaria"></spring:url>
	<spring:url value="/admin/area" var="admin"></spring:url>
	<spring:url value="/veterinario/area" var="veterinario"></spring:url>

	<nav class="navbar navbar-dark bg-dark">
		<div class="container-fluid">
			<a class="navbar-brand">Clínica Veterinária - Arca de Nóe</a>
		</div>
	</nav>

	<main class="container">

		<div class="starter-template text-center py-5 px-3">
			<h1>Bem vindo ao Sistema!!!</h1>
			<p class="lead">
				Sistema feito para uso interno da clínica.<br> Se você é uma
				secretária acesse sua aba, se for um veterinário acesse sua aba.
			</p>
		</div>

		<div class="row  justify-content-around">
			<div class='col-4'>

				<div class="card" style="width: 18rem;">
					<img src="/img/fototemporaria.jpg" class="card-img-top" alt="..." style="height: 170px">
					<div class="card-body">
						<h5 class="card-title">Secretária</h5>
						<p class="card-text">Cadastro de animais, consultas e clientes</p>
						<a href="${secretaria}" class="btn btn-primary">Área Secretária</a>
					</div>
				</div>

			</div>

			<div class='col-4'>

				<div class="card" style="width: 18rem;">
					<img src="/img/veterinarioArea.jpg" class="card-img-top" alt="..." style="height: 170px">
					<div class="card-body">
						<h5 class="card-title">Veterinários</h5>
						<p class="card-text">Cadastro de Exames e Tratamentos e mostrar informações de ambos</p>
						<a href="${veterinario}" class="btn btn-primary">Área
							Veterinário</a>
					</div>
				</div>

			</div>

			<div class='col-4'>

				<div class="card" style="width: 18rem;">
					<img src="/img/adminArea.jpg" class="card-img-top" alt="..." style="height: 170px">
					<div class="card-body">
						<h5 class="card-title">Administrador</h5>
						<p class="card-text">Cadastro de Funcionários e medicamentos</p>
						<a href="${admin}" class="btn btn-primary"> Área Admistrador</a>
					</div>
				</div>

			</div>
		</div>
	</main>


	<script type="text/javascript" src="/js/jquery-3.5.1.min.js"></script>
	<script type="text/javascript" src="/js/bootstrap.min.js"></script>
</body>
</html>