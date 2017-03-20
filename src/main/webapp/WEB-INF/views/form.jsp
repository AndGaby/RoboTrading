<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="./" method= "Post">
		<div class="form-group">
			<label for="nome completo">Nome</label>
			<input type="text" class="form-control" id="nome" name="nomeCli" placeholder="Nome"/>
		</div>
		
		<div class="form-group">
			<label for="user name">Nome de usuario</label>
			<input type="text" class="form-control" id="userName" name="userNameCli" placeholder="UserName"/>
		</div>
		
		<button type="submit" class="btn btn-success">Cadastrar</button>
	</form>
</body>
</html>