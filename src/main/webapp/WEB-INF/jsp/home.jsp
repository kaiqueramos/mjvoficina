<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>MJV Oficina</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
	</head>
	<body class="container bg-secondary">
	
		<div class="d-flex mx-auto col-12 col-md-6 card bg-white shadow" style="margin-top: 5%; height: 520px; border-radius: 15px;">
 			<h3 class="font-weight-bold text-center mt-5">Sistema da oficina da MJV!</h3>
 			<div class="col-12">
				<div class="row justify-content-center mt-5">
					<a href="/registrodefeitos" id="registroDefeitos" class="col-5 btn btn-primary mr-3 pt-4 font-weight-bold" style="height: 100px; border-color:#702094; background: #702094; border-radius: 15px;">Registro de defeitos veiculares</a>
					<a href="/cadastrarveiculos" id="cadastrarVeiculos" class="col-5 btn btn-primary ml-3 pt-4 font-weight-bold" style="height: 100px; border-color:#702094; background: #702094; border-radius: 15px;">Cadastrar tipos de veículos</a>
				</div>
				<div class="row justify-content-center mt-4">
					<a href="/cadastrarpecas" id="cadastrarPecas" class="col-5 btn btn-primary mr-3 pt-4 font-weight-bold" style="height: 100px; border-color:#702094; background: #702094; border-radius: 15px;">Cadastrar peças</a>
					<a href="/cadastrardefeitos" id="cadastrarDefeitos" class="col-5 btn btn-primary ml-3 pt-4 font-weight-bold" style="height: 100px; border-color:#702094; background: #702094; border-radius: 15px;">Cadastrar defeitos</a>
				</div>
				<div class="row justify-content-center mt-4">
					<a href="/registrosdefeitos/exibir" id="exibirRegistros" class="col-10 btn btn-primary pt-4 font-weight-bold" style="height: 100px; border-color:#702094; background: #702094; border-radius: 15px;">Exibir registros salvos</a>
				</div> 
 			</div>
		</div> 
		
		<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
	</body>
</html>