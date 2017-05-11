<%@ include file="../template/header.jsp"%>

<body>
	<div class="container">
		<div class="row">
			<div class="box">
				<form:form action="/clientes" method="POST" commandName="cliente">
					<h2 class="intro-text text-center">
						<strong> Configurações da Conta </strong>
					</h2>
					<hr>
					<div>
						<p align="center">Preencha corretamente os campos abaixo:</p>
					</div>

					<div class="row">
						<table align="center">
							<tr align="center">

								<td><br> <label> Nome</label>
								<br> <input type="text" size="35"
									class="form-control" id="nome" name="nome" /></td>
							</tr>

							<tr align="center">
								
								<td><br> <label> Email </label>
								<br> <input type="text" class="form-control"
									id="email" name="email" aria-describedby="basic-addon1"
									placeholder="nome@email.com" /></td>
							</tr>

							<tr align="center">
								<td><br> <label> Senha </label>
								<br> <input class="form-control" id="senha"
									type="password" name="password" /></td>
							</tr>
							<tr align="center">
								<td>
									<br><button type="submit" class="btn btn-success">Salvar</button>
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