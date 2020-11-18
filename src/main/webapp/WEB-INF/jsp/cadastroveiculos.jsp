<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>MJV Oficina</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
		<link rel="stylesheet" href="./css/cadastropecas.css"/>
	</head>
	<body class="container bg-secondary">
	
		<div class="d-flex mx-auto col-12 col-md-6 card bg-white shadow" style="margin-top: 3%; height: 550px; border-radius: 15px;">
 			<h3 class="font-weight-bold ml-2 mt-4">Cadastro de veiculos</h3>
 			<form class="" action="/cadastrarveiculos/cadastrar" method="post">
				<div class="input-group mb-3 mx-auto mt-4" style="width: 80%;">
					<div class="input-group-prepend">
						<span class="input-group-text bg-white" id="basic-addon1"><img src="./images/Editar.svg" /></span>
					</div>  
					<input name="nomeVeiculo" id="inputText" type="text" class="form-control" placeholder="Digite aqui o nome do veículo" aria-describedby="basic-addon1" style="border-left: none; height: 55px;">
				</div>
				
					<table class="table table-hover table-borderless ml-auto mr-auto mt-4 table-wrapper-scroll-y my-custom-scrollbar" style="width: 80%; background-color: #F0F0F0">
						<thead>
					    	<tr>
						    	<th style="width: 15px">
					              <div class="custom-control border-top-0" >
					                  <input type="checkbox" class="custom-control-input" id="checkAll">
					                  <label class="custom-control-label" for="checkAll"></label>
					              </div>
					            </th>
					        	<th class="ml-n4">PEÇAS</th>
					    	</tr>
					  	</thead>
					  	<tbody>
					  		<c:forEach items="${ pecas }" var="peca">
							    <tr>
							    	<td>
						              <div class="custom-control">
						                  <input name="peca" value="${ peca.nomePeca }" type="checkbox" class="custom-control-input" id="${ peca.nomePeca }">
						                  <label class="custom-control-label" for="${ peca.nomePeca }"></label>
						              </div>
						            </td>
							    	<td><c:out value="${ peca.nomePeca }"></c:out></td>
							    </tr>
					  		</c:forEach>
						</tbody>
					</table>
				
				<div class="row mt-5" style="margin-top: 100px">
					<a href="/" class="ml-5 font-weight-bold mt-1" style="color: #7B0B9A; font-size: 20px;"><img src="./images/Caminho.svg" class="mr-2" />Voltar ao menu</a>
					<button id="btn-submit" class="btn btn-secondary ml-auto mr-5 rounded-pill " style="width: 150px; background-color: #7B0B9A">Salvar</button>
				</div>   
			</form>
		</div>
		
		<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
		<script type="text/javascript" src="./js/index.js"></script>
	</body>
</html>