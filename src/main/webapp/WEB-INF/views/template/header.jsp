<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Mammon Trading</title>
<link href="<c:url value='/resources/css/simple-sidebar.css'  />"
	rel="stylesheet" />
<link href="<c:url value='/resources/css/login.css'  />"
	rel="stylesheet" />
<link href="<c:url value='/resources/css/bootstrap.min.css'  />"
	rel="stylesheet" />
<link href="<c:url value='/resources/css/bootstrap.css'  />"
	rel="stylesheet" />
<link href="<c:url value='/resources/css/header.css' />"
	rel="stylesheet" />
<script type="text/javascript" src="/resources/js/jquery.js"></script>
<script type="text/javascript" src="/resources/js/bootstrap.min.js"></script>
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Josefin+Slab:100,300,400,600,700,100italic,300italic,400italic,600italic,700italic"
	rel="stylesheet" type="text/css">
<link
	href="http://cdnjs.cloudflare.com/a	jax/libs/summernote/0.8.3/summernote.css"
	rel="stylesheet">
<script
	src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.3/summernote.js"></script>

</head>
<body>
<div class="Page">
	<c:if test="${not empty user}">
		<ul class="nav navbar-nav">
			<%@ include file="sidebar.jsp"%>
		</ul>
	</c:if>
	<div class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="col-md-2 navbar-header">
				<a class="navbar-brand" href="#">Mammon Trading</a>
			</div>
			<div class="col-md-4">
				<ul class="nav navbar-nav">
					<li><a href="/">Home</a></li>
					<li><a href="/robos">Robôs</a></li>
					<li><a href="/artigos">Artigos</a></li>
					<li><a href="/tutoriais">Tutoriais</a></li>
				</ul>
			</div>
			<c:if test="${empty user}">
				<div class="col-md-offset-3 col-md-3">
					<ul class="nav navbar-nav">
						<li><%@ include file="login-register.jsp"%></li>
						<li><a href="/contatos">Contato</a></li>
					</ul>
				</div>
			</c:if>
			<c:if test="${not empty user}">
				<div class="col-md-offset-4 col-md-2">
					<ul class="nav navbar-nav">
						<li><a href="#" id="button-toggle">${user.nome}</a></li>
					</ul>
				</div>
			</c:if>
		</div>
	</div>
</div>
	<script src="/resources/js/app.js"></script>
	<script>
		$("#menu-toggle").click(function(e) {
			e.preventDefault();
			$("#wrapper").toggleClass("toggled");
		});
		$("#button-toggle").click(function(e) {
			e.preventDefault();
			$("#wrapper").toggleClass("toggled");
		});
		
		if ($(".Page").height()<$(window).height()){
	        $(".footer_wrapper").addClass("fixed");
	    }else{
	        $(".footer_wrapper").removeClass("fixed");
	    }
	</script>
</body>
</html>

