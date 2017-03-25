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
		<div>
        <!-- /.container -->
    </nav>

    <div class="container">

        <div class="row">
            <div class="box">
                <div class="col-lg-12 text-center"  style="heigth:50px;" >
                    
                      
                    <h2 class="intro-text text-center">Formulário
                        <strong>Investidor</strong>
                    </h2>
                    <hr>
					<div>
						<p align="center">Preencha corretamente os campos abaixo:</p>
					</div>
					<center>				
                    <form role="form">
						
						<div class="row">
							<table name="tab_01">
								<tr>
									
									<div class="form-group col-lg-0">
										<td> <br> <label> Nome: </label> </td>
										<td> <br> <input type="text" size="35" class="form-control" id="nome" name="nomeCli" /> </td>
									</div>
	
								</tr>
									
								<tr>
									
									<div class="form-group col-lg-4">
										<td> <br> <label> Nome de Usuário: </label> </td>
										<td> <br> <input type="text" class="form-control" id="userName" name="userNameCli" /> </td>
									</div>
								</tr>
								
								<tr>
									<div class="form-group col-lg-4">
										<td> <br> <label> Email: </label> </td>
										
										<td><br><input type="text" class="form-control" id="email" name="emailCli" aria-describedby="basic-addon1" placeholder="nome@email.com" /> </td>
									</div>
								</tr>
								
								<tr>
									<div class="form-group col-lg-4">
										<td> <br> <label> Senha: </label> </td>
										<td> <br> <input class="form-control" id="senha" type="password" name="passwordCli"/> </td>
									</div>
									
								</tr>
								
									
								<tr>
									<div class="form-group col-lg-4">
										
									</div>
								
									
								</tr>
								
								<tr>
									<div class="form-group col-lg-4">
										
									</div>
								
									
								</tr>
								
								<tr>
									<div class="form-group col-lg-4">
										
									</div>
									
									
								</tr>
								

													
							</table>
							
							<table name="tab_02">
								<tr>
									<div class="form-group col-lg-0">
										<td> <button type="submit" class="btn btn-success">Salvar</button> </td>
									</div>
									
									
									<div class="form-group col-lg-4">
										<td> <button type="reset" class="btn btn-primary">Limpar</button> </td>
									</div>
								</tr>
							</table>
							
							
						
						</div>
                    </form>
					</center>
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
