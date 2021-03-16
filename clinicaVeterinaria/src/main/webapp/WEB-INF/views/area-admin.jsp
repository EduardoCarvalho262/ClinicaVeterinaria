<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin - Home</title>
<link href="/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
	<spring:url value="/admin/showFormCadastro" var="formSecretaria"></spring:url>
	<spring:url value="/medicamento/showFormMedicamento" var="formMedicamento"></spring:url>
	<spring:url value="/especialidade/showFormCadastro" var="formEspecialidade"></spring:url>
	<spring:url value="/veterinario/showFormCadastro" var="formVeterinario"></spring:url>


	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<div class="container-fluid">
			<a class="navbar-brand" href="/"> <img src="/img/admin.svg"
				alt="" width="30" height="24" class="d-inline-block align-top">
				Área Admin
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




		<div class="row justify-content-around">
			<div class='col-4'>

				<div class="card" style="width: 18rem;">
					<img src="/img/secretariasAdmin.jpg" class="card-img-top" alt="...">
					<div class="card-body">
						<h5 class="card-title">Cadastrar Secretárias</h5>
						<p class="card-text">Realização de cadastro, atualização de informações.</p>
						<a href="${formSecretaria}" class="btn btn-primary">Cadastrar</a>
					</div>
				</div>

			</div>
			
				<div class='col-4'>

				<div class="card" style="width: 18rem;">
					<img src="/img/especialidadeAdmin.jpg" class="card-img-top" alt="...">
					<div class="card-body">
						<h5 class="card-title">Cadastrar Especialidades</h5>
						<p class="card-text">Realização de cadastro, atualização de informações.</p>
						<a href="${formEspecialidade}" class="btn btn-primary">Cadastrar</a>
					</div>
				</div>

			</div>

			<div class='col-4'>

				<div class="card" style="width: 18rem;">
					<img src="/img/veterinarioAdmin.jpg" class="card-img-top" alt="...">
					<div class="card-body">
						<h5 class="card-title">Cadastrar Veterinários</h5>
						<p class="card-text">Realização de cadastro, atualização de informações e adição do animal.</p>
						<a href="${formVeterinario}" class="btn btn-primary">Cadastrar</a>
					</div>
				</div>

			</div>
		</div>
		<br>
		<div class="row align-items-center">
			<div class='col-4'>

				<div class="card" style="width: 18rem;">
					<img src="/img/medicamentosAdmin.jpg" class="card-img-top" alt="...">
					<div class="card-body">
						<h5 class="card-title">Cadastrar Medicamentos</h5>
						<p class="card-text">Realização de cadastro, atualização de
							informações e adição de medicamentos.</p>
						<a href="${formMedicamento}" class="btn btn-primary">Cadastrar</a>
					</div>
				</div>

			</div>
		</div>
	</main>






	<script type="text/javascript" src="/js/jquery-3.5.1.min.js"></script>
	<script type="text/javascript" src="/js/bootstrap.min.js"></script>
</body>
</html>