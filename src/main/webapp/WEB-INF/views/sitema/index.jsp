<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="pt-br">

<head>

<!-- Adicionar favicon - Ícone da aba das páginas -->
    
    <link href="<c:url value='/resources/css/bootstrap.css'  />" rel="stylesheet"/>
	<link href="<c:url value='/resources/css/business-casual.css'  />" rel="stylesheet"/>
	<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    
    <link href="<c:url value='/resources/css/bootstrap-responsive.css'/>" rel="stylesheet"/>
	
	<link href="https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Josefin+Slab:100,300,400,600,700,100italic,300italic,400italic,600italic,700italic" rel="stylesheet" type="text/css">

	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Robô Trading</title>
</head>
<body>
	<!--  <script src="../resources/js/jquery.maskedinput.js" type="text/javascript" ></script>-->
	<!--<script src="../resources/js/jquery.maskedinput.min.js" type="text/javascript" ></script>-->
	<script src="https://code.jquery.com/jquery-1.11.2.min.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  	
  	
	<div class="brand">Robô Trading</div>
    <div class="address-bar">Robôs para Investimentos</div>

    <!-- Navigation -->
    <nav class="navbar navbar-default" role="navigation">
        <div class="container">
          
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <!-- navbar-brand is hidden on larger screens, but visible when the menu is collapsed -->
                <a class="navbar-brand" href="index.html">Robô Trading</a>
            </div>
       
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li>
                        <a href="index.html">Home</a>
                    </li>
                    <li>
                        <a href="login.html">Login</a>
                    </li>
					
					<li>
                        <a href="personalizarRobos.html">Personalizar Robôs</a>
                    </li>
					<li>
                        <a href="contato.html">Contato</a>
                    </li>
					
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
		
        <!-- /.container -->
    </nav>

    <div class="container">

        <div class="row">
            <div class="box">
                <div class="col-lg-12 text-center">
                    <div id="carousel-example-generic" class="carousel slide">
                        <!-- Indicators -->
                        <ol class="carousel-indicators hidden-xs">
                            <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                            <li data-target="#carousel-example-generic" data-slide-to="1" ></li>
                            <li data-target="#carousel-example-generic" data-slide-to="2" ></li>
                        </ol>

                        <!-- Wrapper for slides -->
                        <div class="carousel-inner">
                            <div class="item active">
                             <p align="center"><img class="img-responsive img-full" src="/resources/img/img2.jpg" alt=""></p> 
                            </div>
                            <div class="item">
                               <p align="center"><img class="img-responsive img-full" src="/resources/img/img3.png" alt=""></p>
                            </div>
                            <div class="item">
                               <p align="center"> <img class="img-responsive img-full" src="/resources/img/img4.jpg" alt=""></p>
                            </div>
                        </div>

                        <!-- Controls -->
                        <a class="left carousel-control" href="#carousel-example-generic" data-slide="prev">
                            <span class="icon-prev"></span>
                        </a>
                        <a class="right carousel-control" href="#carousel-example-generic" data-slide="next">
                            <span class="icon-next"></span>
                        </a>
                    </div>
                    <h2 class="brand-before">
                        <small>Bem Vindo </small>
						<small>Robô Trading </small>
                    </h2>
                    
                    <hr class="tagline-divider">
                    <h2>
                        
                    </h2>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="box">
                <div class="col-lg-12">
                    <hr>
                    <h2 class="intro-text text-center">Conheça:
                        <strong> O Sistema </strong>
                    </h2>
                    <hr>
                    <img class="img-responsive img-border img-left" src="/resources/img/img5.jpg" alt="">
                    <hr class="visible-xs">
                    <p> Para investimentos automatizados, o único auxílio humano é no ajuste dos parâmetros, esses serão utilizados 
                     para determinar qual rumo o robô deve seguir, investimento com níveis de risco maiores ou menores.</p>
                    <p> O principal foco do robô será day trade, operações iniciadas e finalizadas no mesmo dia. 
						Com o objetivo de ganhar pouco por operações porém ganhar muitas vezes.</p>
                </div>
            </div>
        </div>

    </div>
    <!-- /.container -->

    <footer>
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <p>Robô Trading &copy; 2017</p>
                </div>
            </div>
        </div>
    </footer>

    
    <script>
    $('.carousel').carousel({
        interval: 5000 //changes the speed
    })
    </script>

</body>

</html>
	
