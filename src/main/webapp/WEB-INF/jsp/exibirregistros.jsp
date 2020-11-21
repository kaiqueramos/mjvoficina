<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>MJV Oficina</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
		<link rel="stylesheet" href="/css/registrodefeitos.css"/>
	</head>
	<body class="container bg-secondary">
	
		<div class="d-flex mx-auto col-12 col-md-8 card bg-white shadow" style="margin-top: 3%; height: 600px; border-radius: 15px;">
 			<h3 class="font-weight-bold ml-2 mt-4">Registro de defeitos veiculares</h3>
 			<form class="" action="/registrodefeitos/salvarregistro" method="post">
				 
				 <div class="form-group ml-2">
				    <label for="veiculos">VEÍCULOS</label>
				    <select class="form-control" id="veiculos" style="height: 50px; width: 40%">
				      <option value="">Escolha um veículo:</option>
				      <c:forEach items="${ veiculos }" var="veiculo">
					      <option value="${ veiculo.tipoVeiculo }"><c:out value="${ veiculo.tipoVeiculo }"></c:out></option>
				      </c:forEach>
				    </select>
				  </div>
				    
				<div class="input-group mb-3 mt-4 ml-2" style="width: 90%;">
					<div class="input-group-prepend">
						<span class="input-group-text bg-white" id="basic-addon1"><img src="/images/Calendario.svg" width="20px"/></span>
					</div>  
					<input type="text" id="dataInicio" class="form-control rounded-right" placeholder="Data inicial" style="border-left: none; height: 55px;">
					<div class="input-group-prepend ml-5">
						<span class="input-group-text bg-white rounded-left" id="basic-addon1"><img src="/images/Calendario.svg" width="20px"/></span>
					</div>  
					<input type="text" id="dataFim" class="form-control" placeholder="Data final" style="border-left: none; height: 55px;">
				</div> 
				 
				<table class="table table-hover table-borderless ml-auto mr-auto mt-4 table-wrapper-scroll-y my-custom-scrollbar" style="width: 80%; background-color: #F0F0F0">
					<thead> 
				    	<tr>
					    	<th class="pr-5">CLIENTE</th>
				        	<th class="pr-5">DATA</th>
				        	<th style="width: 40%">VEÍCULO</th>
				    	</tr>
				  	</thead>
				  	<tbody id="tabela">
					    <tr>
					    	<td>Cliente</td>
					      	<td>DEFEITO</td>
					    	<td>DEFEITO</td>
					    	<td><a href="">Ler mais</a></td> 
					    </tr> 
					</tbody>
				</table>
				
				<div class="row mt-5" style="margin-top: 100px">
					<a href="/" class="ml-5 font-weight-bold mt-1" style="color: #7B0B9A; font-size: 20px;"><img src="/images/Caminho.svg" class="mr-2" />Voltar ao menu</a>
					<button type="button" id="btn-submit" class="btn btn-secondary ml-auto mr-5 rounded-pill " style="width: 150px; background-color: #7B0B9A">Filtrar</button> 
				</div>   
			</form>
		</div>     
		
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
		<script type="text/javascript" src="/js/exibirregistros.js"></script>
	</body>
</html>