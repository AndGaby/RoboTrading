<%@ include file="../template/header.jsp"%>

<body>
	<div class="container">
		<div class="row">
				<div class="col-lg-12 text-center">
					<form:form name="form1" action="/tutoriais" method="POST" commandName="tutorial">
						<hr>
						<h2 class="intro-text text-center">
							Formulário <strong>Tutorial</strong>
						</h2>
						<hr>
						<p align="center">Preencha corretamente os campos abaixo:</p>
						<div class="row">
							<table align="center">

								<tr>
									<td><br> <label for="nome"> Nome: </label></td>
									<td><br> <form:input path="nome" type="text"
											class="form-control" /></td>
								</tr>
								<tr>
									<td><br> <label for="link"> Link: </label></td>
									<td><br> <form:input path="link" type="text"
											class="form-control" /></td>

								</tr>
								<tr>
									<td><br> <label for="descricao"> Descrição:  </label>
									</td>
									<td>
										<br><form:input path="descricao" type="text"
											class="form-control" /> 
									</td>
								</tr>
								<tr>
									<td><br></td>
									<td><br></td>
									<td><form:button type="submit" class="btn btn-success">Salvar</form:button>
									</td>
								</tr>
							</table>
						</div>
					</form:form>
			</div>
		</div>
	</div>
</body>

<%@ include file="../template/footer.jsp"%>
