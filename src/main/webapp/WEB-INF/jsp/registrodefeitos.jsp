<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>MJV Oficina</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
		<link href="https://unpkg.com/material-components-web@latest/dist/material-components-web.min.css" rel="stylesheet">
		<link rel="stylesheet" href="/css/registrodefeitos.css"/>
	</head>
	<body class="container bg-secondary">
	
		<div class="d-flex mx-auto col-12 col-md-8 card bg-white shadow" style="margin-top: 3%; height: 600px; border-radius: 15px;">
 			<h3 class="font-weight-bold ml-2 mt-4">Registrar defeitos veiculares</h3>
 			<form class="" action="/registrodefeitos/salvarregistro" method="post">
 			
				<label class="mdc-text-field mdc-text-field--outlined mt-3 ml-2" style="height: 50px; width: 60%">
				  <span class="mdc-notched-outline">
				    <span class="mdc-notched-outline__leading"></span>
				    <span class="mdc-notched-outline__notch">
				      <span class="mdc-floating-label" id="my-label-id">Nome do cliente</span>
				    </span>
				    <span class="mdc-notched-outline__trailing"></span>
				  </span>
				  <input type="text" class="mdc-text-field__input" aria-labelledby="my-label-id">
				</label>
				
				 <div class="form-group ml-2">
				    <label for="veiculos">Tipo de veículo:</label> 
				    <select class="form-control" id="veiculos" style="height: 50px; width: 40%">
				      <option value="">Selecione o veículo</option>
				      <c:forEach items="${veiculos}" var="veiculo">
					      <option value="${ veiculo }">${ veiculo }</option>
				      </c:forEach>
				    </select>
				  </div> 
				
				<table class="table table-hover table-borderless ml-auto mr-auto mt-4 table-wrapper-scroll-y my-custom-scrollbar" style="width: 80%; background-color: #F0F0F0">
					<thead>
				    	<tr>
					    	<th class="pr-2">ITENS</th>
				        	<th style="padding-right: 70px;">DEFEITO</th>
				        	<th>PEÇA</th>
				    	</tr>
				  	</thead>
				  	<tbody id="tabela">
					   
					</tbody>
				</table>
				
				<div class="row mt-5" style="margin-top: 100px">
					<a href="/" class="ml-5 font-weight-bold mt-1" style="color: #7B0B9A; font-size: 20px;"><img src="/images/Caminho.svg" class="mr-2" />Voltar ao menu</a>
					<button id="btn-submit" class="btn btn-secondary ml-auto mr-5 rounded-pill " style="width: 150px; background-color: #7B0B9A">Salvar</button>
				</div>   
			</form>
		</div>
		 
		<script src="webjars/material-design-lite/1.3.0/material.min.js"></script> 
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
		<script src="https://unpkg.com/material-components-web@latest/dist/material-components-web.min.js"></script>
		<script type="text/javascript" src="/js/registrodefeitos.js"></script>
		<script>
		  mdc.textField.MDCTextField.attachTo(document.querySelector('.mdc-text-field'));
		</script>
	</body>
</html>