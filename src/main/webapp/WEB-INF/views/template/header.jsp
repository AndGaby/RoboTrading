<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Mammon Trading</title>
<link rel="stylesheet" type="text/css"
	href="/webjars/bootstrap/css/bootstrap.min.css" />
<link href="<c:url value='/resources/css/header.css'  />"
	rel="stylesheet" />
<script type="text/javascript" src="/webjars/jquery/jquery.min.js"></script>
<script type="text/javascript"
	src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Josefin+Slab:100,300,400,600,700,100italic,300italic,400italic,600italic,700italic"
	rel="stylesheet" type="text/css">
<link
	href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.3/summernote.css"
	rel="stylesheet">
<script
	src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.3/summernote.js"></script>
</head>
<body>
	<div class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="col-md-4">
				<div class="navbar-header">
					<a class="navbar-brand" href="/home">MammonTrading - Logo</a>
				</div>
			</div>
			<c:if test="${empty user}">
				<form action="/login" method="POST">
					<div class="col-md-offset-8">
						<ul class="nav navbar-nav">
							<li><a href="">Cadastre-se</a></li>
							<li class="dropdown"><a class="dropdown-toggle"
								data-toggle="dropdown" href="">Entre</a>
								<ul class="dropdown-menu dropdown-login">
									<li><input class="form-control" type="text"
										placeholder="e-mail" /></li>
									<li><input class="form-control" type="password"
										placeholder="senha" /></li>
									<li><input class="btn btn-primary" type="submit"
										value="Entrar" /></li>
								</ul></li>
							<li><a href="">Contato</a></li>
						</ul>
					</div>
				</form>
			</c:if>
			<c:if test="${not empty user}">
			<div class="col-md-offset-8">
			
			</div>
			</c:if>
		</div>
	</div>

	<!-- 	<div class="navbar navbar-inverse"> -->
	<%-- 		<form action="/login" method="POST"> --%>
	<%-- 			<c:if test="${empty user}"> --%>
	<!-- 				<ul class="nav navbar-nav"> -->
	<!-- 					<li><input type="text" name="email" /></li> -->
	<!-- 					<li><input type="password" name="password" /></li> -->
	<!-- 					<li><input type="submit" value="logar" /></li> -->
	<!-- 					<li><a href="/clientes/new">Cadastrar</a></li> -->
	<!-- 				</ul> -->
	<%-- 			</c:if> --%>
	<%-- 			<c:if test="${not empty user}"> --%>
	<!-- 				<ul class="nav navbar-nav"> -->
	<%-- 					<li><a href="/clientes/${user.id}">${user.nome}</a></li> --%>
	<!-- 					<li><a href="/login">Deslogar</a></li> -->
	<!-- 				</ul> -->
	<%-- 			</c:if> --%>
	<%-- 		</form> --%>
	<!-- 	</div> -->
	<!-- 	<div class="brand">Mammon Trading</div> -->
	<!-- 	<div class="address-bar">Robôs para Investimentos</div> -->

	<!-- 	<div class="navbar navbar-inverse"> -->
	<!-- 		<div class="container-fluid"> -->
	<!-- 			<div class="navbar-header"> -->
	<!-- 				<a class="navbar-brand" href="#">Robô Trading</a> -->
	<!-- 			</div> -->
	<!-- 			<ul class="nav navbar-nav"> -->
	<!-- 				<li><a href="/">Home</a></li> -->
	<!-- 				<li><a href="/robos">Robôs</a></li> -->
	<!-- 				<li><a href="/artigos">Artigos</a></li> -->
	<!-- 				<li><a href="/tutoriais">Tutoriais</a></li> -->
	<!-- 				<li><a href="/contato">Contato</a></li> -->
	<!-- 			</ul> -->
	<!-- 		</div> -->
	<!-- 	</div> -->
	<!-- 	<script src="/resources/js/app.js"></script> -->
</body>
</html>