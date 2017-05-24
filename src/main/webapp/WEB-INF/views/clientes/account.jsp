<%@ include file="../template/header.jsp"%>

<body>
	<div class="container">
		<div class="well">
			<h2 class="intro-text text-center">
				<strong> Configurações da Conta </strong>
			</h2>
			<hr>

			<ul class="nav nav-tabs">
				<li class="active"><a href="#profile" data-toggle="tab">Dados
						pessoais</a></li>
				<li><a href="#password" data-toggle="tab">Troca de senha</a></li>
				<li><a href="#metatrader" data-toggle="tab">Informações do
						MetaTrader</a></li>
			</ul>

			<div id="myTabContent" class="tab-content">

				<div class="tab-pane active in" id="profile">
					<form:form id="tab" action="#" method="POST" commandName="cliente">
						<table align="center">
							<tr align="center">
								<td align="left"><br> <label> Email </label> <br>
									<input type="text" class="form-control" id="email" name="email"
									aria-describedby="basic-addon1" placeholder="nome@email.com"
									value="${user.email}" readonly /></td>
							</tr>
							<tr align="center">
								<td align="left"><br> <label> Nome</label> <br> <input
									type="text" size="35" class="form-control" id="nome"
									name="nome" value="${user.nome }" /></td>
							</tr>
							<tr align="center">
								<td align="left"><br> <label> Endereço</label> <br>
									<input type="text" size="35" class="form-control" id="nome"
									name="nome" /></td>
								<td align="center"><br> <label> Número </label> <br>
									<input type="text" size="5" class="form-control" id="nome"
									name="nome" /></td>
							</tr>
							<tr align="center">
								<td align="left"><br> <label> Cidade</label> <br>
									<input type="text" size="35" class="form-control" id="nome"
									name="nome" /></td>
								<td align="center"><br> <label> UF </label> <br>
									<input type="text" size="5" class="form-control" id="nome"
									name="nome" /></td>
							</tr>
							<tr align="center">
								<td><br>
								<br> <input type="checkbox" tabindex="3" name="remember"
									id="remember"> <label for="remember"> Desejo
										receber as novidades da Mammon Trading por email</label><br>
									<button type="submit" class="btn btn-success">Salvar</button>
									<button type="reset" class="btn btn-primary">Limpar</button></td>
							</tr>
						</table>
					</form:form>
				</div>
				<div class="tab-pane fade" id="password">
					<form:form id="tab2" action="#" method="POST">
						<table align="center">
							<tr align="center">

								<td align="left"><br> <label> Senha Antiga </label> <br>
									<input type="text" size="35" class="form-control" id="senha"
									name="nome" /></td>
							</tr>
							<tr align="center">

								<td align="left"><br> <label> Nova Senha </label> <br>
									<input type="text" size="35" class="form-control"
									id="novaSenha" name="nome" /></td>
							</tr>
							<tr align="center">

								<td align="left"><br> <label> Confirmar Nova
										Senha </label> <br> <input type="text" size="35"
									class="form-control" id="nome" name="nome" /></td>
							</tr>
							<tr align="center">
								<td><br>
									<button type="submit" class="btn btn-success">Salvar</button>
									<button type="reset" class="btn btn-primary">Limpar</button></td>

							</tr>
						</table>
					</form:form>
				</div>
				<div class="tab-pane fade" id="metatrader">
					<form:form id="tab3" action="/clientes/loginsMetatrader/${user.id}" method="POST">
						<div align="center">
							<h4>
								<strong> Para fins de compras futuras conosco,<br>
									atualize seus logins do Metatrader<br> Esses logins serão
									usados para ativar<br> seus Robôs.<br>
								</strong>
							</h4>
						</div>

						<table align="center">
							<tr align="center">
								<td><br> <label> Logins do Metatrader </label></td>
							</tr>
						</table>
						<table align="center" id="metaLogins">
							<c:forEach items="${cliente.loginsMetatrade}" var="logins"
								varStatus="ind">
								<tr align="center">
									<td><br>
									<input type="text" class="form-control" name="loginsMetatrader" 
										value="${logins.loginMetatrade}" size="5" readonly/></td>
									<td><input type="button" class="ibtnDel btn btn-link"
										value="Remover"></td>
								</tr>
							</c:forEach>
						</table>
						<input type="hidden" class="form-control" name="loginsMetatrader"/>
						<table align="center">
							<tr align="center">
								<td><input type="button" class="btn btn-link" id="addRow"
									value="Adicionar" /></td>
							</tr>
							<tr align="center">
								<td><br>
									<button type="submit" class="btn btn-success">Salvar</button>
									<button type="reset" class="btn btn-primary">Limpar</button></td>
							</tr>
						</table>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</body>

<script type="text/javascript">
	$("#addRow")
			.on(
					"click",
					function() {
						var newRow = $('<tr align="center">');
						var cols = "";
						var rowCount = $("#metaLogins").length + 1;

						cols += '<td><br><input type="text" class="form-control" name="loginsMetatrader" size="5"/></td>';

						cols += '<td><input type="button" class="ibtnDel btn btn-link"  value="Remover"></td>';
						newRow.append(cols);

						$("#metaLogins").append(newRow);
					});

	$("#metaLogins").on("click", ".ibtnDel", function(event) {
		$(this).closest("tr").remove();
	});
</script>

<%@ include file="../template/footer.jsp"%>