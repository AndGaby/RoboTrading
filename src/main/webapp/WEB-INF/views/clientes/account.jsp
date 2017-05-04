<%@ include file="../template/header.jsp"%>

<body>
	<nav class="navbar navbar-default" role="navigation">
		<div class="container">

			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="index.html">Robô Trading</a>
			</div>
		</div>
	</nav>
	<div class="container">
		<div class="row">
			<div class="box">
				<form:form action="/clientes" method="POST" commandName="cliente">
					<h2 class="intro-text text-center">
						Formulário <strong>Investidor</strong>
					</h2>
					<hr>
					<div>
						<p align="center">Preencha corretamente os campos abaixo:</p>
					</div>

					<div class="row">
						<table align="center">
							<tr>

								<td><br> <label> Nome: </label></td>
								<td><br> <input type="text" size="35"
									class="form-control" id="nome" name="nome" /></td>
							</tr>

							<tr>

								<td><br> <label> Email: </label></td>
								<td><br> <input type="text" class="form-control"
									id="email" name="email" aria-describedby="basic-addon1"
									placeholder="nome@email.com" /></td>
							</tr>

							<tr>
								<td><br> <label> Senha: </label></td>
								<td><br> <input class="form-control" id="senha"
									type="password" name="password" /></td>
							</tr>
							<tr>
								<td><br></td>
								<td><br></td>
								<td><br></td>
								<td>
									<button type="submit" class="btn btn-success">Salvar</button>

									<button type="reset" class="btn btn-primary">Limpar</button>
								</td>

							</tr>
						</table>



					</div>
				</form:form>

			</div>
		</div>
	</div>
</body>

</html>
<%@ include file="../template/footer.jsp"%>