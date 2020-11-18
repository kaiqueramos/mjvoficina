<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>MJV Oficina</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
		
		<style type="text/css">
			.btn-roxo{
				background-color: "#7B0B9A" !important;
			}
			.btn-cinza{ 
				background-color: lightgrey; 
			}
			
		</style>
	</head>
	<body class="container bg-secondary">
	
		<div class="d-flex mx-auto col-12 col-md-6 card bg-white shadow" style="margin-top: 10%; height: 400px; border-radius: 15px;">
 			<h3 class="font-weight-bold mt-5 ml-2">Cadastro de defeito</h3>
			<form class="" action="/cadastrardefeitos/cadastrar" method="post">
				<p class="ml-2">Cadastre todo tipo de defeito relacionado ao veículo:</p>
				<div class="input-group mb-3 mx-auto mt-4" style="width: 80%;">
					<div class="input-group-prepend">
						<span class="input-group-text bg-white" id="basic-addon1"><img src="./images/Editar.svg" /></span>
					</div>
					<input id="inputText" type="text" name="nomeDefeito" class="form-control" placeholder="Digite aqui o nome do defeito" aria-label="Username" aria-describedby="basic-addon1" style="border-left: none; height: 55px;">
					<div id="feedback"></div> 
				</div>   
				<div class="row mt-5" style="margin-top: 100px">
					<a href="/" class="ml-5 font-weight-bold mt-1" style="color: #7B0B9A; font-size: 20px;"><img src="./images/Caminho.svg" class="mr-2" />Voltar ao menu</a>
					<button id="btn-submit" class="btn btn-secondary ml-auto mr-5 rounded-pill " style="width: 150px;" disabled="disabled">Salvar</button>
				</div>   
			</form>
		</div>
		
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
		<script type="text/javascript" src="./js/cadastrodefeitos.js"></script>
	</body>
</html>