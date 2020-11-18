<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
 			<h3 class="font-weight-bold ml-2 mt-4">Registro de defeitos veiculares</h3>
 			<form class="" action="/registrodefeitos/salvarregistro" method="post">
				
				 <div class="form-group ml-2">
				    <label for="exampleFormControlSelect1">Example select</label>
				    <select class="form-control" id="exampleFormControlSelect1" style="height: 50px; width: 40%">
				      <option>1</option>
				      <option>2</option>
				      <option>3</option>
				      <option>4</option>
				      <option>5</option>
				    </select>
				  </div>
				   
				<div class="input-group mb-3 mt-4 ml-2" style="width: 90%;">
					<div class="input-group-prepend">
						<span class="input-group-text bg-white" id="basic-addon1"><img src="/images/Calendario.svg" width="20px"/></span>
					</div>  
					<input id="inputText" type="text" class="form-control rounded-right" placeholder="Digite aqui o nome da peça" aria-label="Username" aria-describedby="basic-addon1" style="border-left: none; height: 55px;">
					<div class="input-group-prepend ml-5">
						<span class="input-group-text bg-white rounded-left" id="basic-addon1"><img src="/images/Calendario.svg" width="20px"/></span>
					</div>  
					<input id="inputText" type="text" class="form-control" placeholder="Digite aqui o nome da peça" aria-label="Username" aria-describedby="basic-addon1" style="border-left: none; height: 55px;">
				</div>
				
				<table class="table table-hover table-borderless ml-auto mr-auto mt-4 table-wrapper-scroll-y my-custom-scrollbar" style="width: 80%; background-color: #F0F0F0">
					<thead>
				    	<tr>
					    	<th class="pr-5">CLIENTE</th>
				        	<th class="pr-5">DATA</th>
				        	<th style="width: 40%">VEÍCULO</th>
				    	</tr>
				  	</thead>
				  	<tbody>
					    <tr>
					    	<td>Cliente</td>
					    	<td>DEFEITO</td>
					    	<td>DEFEITO</td>
					    	<td><a href="">Ler mais</a></td>
					    </tr>
					    <tr>
					    	<td>Cliente</td>
					      	<td>DEFEITO</td>
					    	<td>DEFEITO</td>
					    	<td><a href="">Ler mais</a></td>
					    </tr>
					    <tr>
					    	<td>Cliente</td>
					      	<td>DEFEITO</td>
					    	<td>DEFEITO</td>
					    	<td><a href="">Ler mais</a></td>
					    </tr>
					    <tr>
					    	<td>Cliente</td>
					      	<td>DEFEITO</td>
					    	<td>DEFEITO</td>
					    	<td><a href="">Ler mais</a></td>
					    </tr>
					    <tr>
					    	<td>Cliente</td>
					      	<td>DEFEITO</td>
					    	<td>DEFEITO</td>
					    	<td><a href="">Ler mais</a></td>
					    </tr>
					    <tr>
					    	<td>Cliente</td>
					      	<td>DEFEITO</td>
					    	<td>DEFEITO</td>
					    	<td><a href="">Ler mais</a></td>
					    </tr>
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
					<button id="btn-submit" class="btn btn-secondary ml-auto mr-5 rounded-pill " style="width: 150px; background-color: #7B0B9A">Salvar</button>
				</div>   
			</form>
		</div>
		
		<script src="webjars/material-design-lite/1.3.0/material.min.js"></script> 
		<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
		<script src="https://unpkg.com/material-components-web@latest/dist/material-components-web.min.js"></script>
		<script type="text/javascript" src="./js/index.js"></script>
		<script>
		  mdc.textField.MDCTextField.attachTo(document.querySelector('.mdc-text-field'));
		</script>
	</body>
</html>