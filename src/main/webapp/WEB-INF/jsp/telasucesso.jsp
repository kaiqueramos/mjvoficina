<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>MJV Oficina</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
	</head>
	<body class="container bg-secondary">
	
		<div class="d-flex mx-auto col-12 col-md-6 card bg-white shadow" style="margin-top: 10%; height: 200px; border-radius: 15px;">
 			<h3 class="font-weight-bold mt-5 ml-2"><c:out value="${ titulo }"></c:out></h3>
 			<div class="row mt-5">
				<a href="/" class="ml-5 font-weight-bold mt-1" style="color: #7B0B9A; font-size: 20px;"><img src="/images/Caminho.svg" class="mr-2" />Voltar ao menu</a>
				<a href="<c:out value="${ link }"></c:out>" id="btn-submit" class="btn btn-secondary ml-auto mr-5 rounded-pill " style="width: 150px; background-color: #7B0B9A">Novo cadastro</a>
			</div>   
		</div> 
		
		<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
	</body>
</html>