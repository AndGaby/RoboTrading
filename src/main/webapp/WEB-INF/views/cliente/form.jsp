<%@ include file="../template/header.jsp"%>

<body>
	<form action="/clientes" method="POST" commandName="clientes">

		<!-- Navigation -->
		<nav class="navbar navbar-default" role="navigation">
		<div class="container">

			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<!-- navbar-brand is hidden on larger screens, but visible when the menu is collapsed -->
				<a class="navbar-brand" href="index.html">Robô Trading</a>
			</div>

			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li><a href="index.html">Home</a></li>
					<li><a href="login.html">Login</a></li>

					<li><a href="personalizarRobos.html">Personalizar Robôs</a></li>
					<li><a href="contato.html">Contato</a></li>

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
					<div class="col-lg-12 text-center" style="heigth: 50px;">


						<h2 class="intro-text text-center">
							Formulário <strong>Investidor</strong>
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
												<td><br> <label> Nome: </label></td>
												<td><br> <input type="text" size="35"
													class="form-control" id="nome" name="nomeCli" /></td>
											</div>

										</tr>

										<tr>

											<div class="form-group col-lg-4">
												<td><br> <label> Nome de Usuário: </label></td>
												<td><br> <input type="text" class="form-control"
													id="userName" name="userNameCli" /></td>
											</div>
										</tr>

										<tr>
											<div class="form-group col-lg-4">
												<td><br> <label> Email: </label></td>

												<td><br>
												<input type="text" class="form-control" id="email"
													name="emailCli" aria-describedby="basic-addon1"
													placeholder="nome@email.com" /></td>
											</div>
										</tr>

										<tr>
											<div class="form-group col-lg-4">
												<td><br> <label> Senha: </label></td>
												<td><br> <input class="form-control" id="senha"
													type="password" name="passwordCli" /></td>
											</div>

										</tr>


										<tr>
											<div class="form-group col-lg-4"></div>


										</tr>

										<tr>
											<div class="form-group col-lg-4"></div>


										</tr>

										<tr>
											<div class="form-group col-lg-4"></div>


										</tr>



									</table>

									<table name="tab_02">
										<tr>
											<div class="form-group col-lg-0">
												<td>
													<button type="submit" class="btn btn-success">Salvar</button>
												</td>
											</div>


											<div class="form-group col-lg-4">
												<td>
													<button type="reset" class="btn btn-primary">Limpar</button>
												</td>
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

	</form>
</body>

</html>
<%@ include file="../template/footer.jsp"%>