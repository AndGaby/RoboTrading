
<%@ include file="../template/header.jsp"%>

<body>
	<div class="container">
		<%@ include file="barra-menu-admin.jsp"%>
		<div class="row">
			<div class="box">
				<div class="col-lg-12 text-center">
					<spring:hasBindErrors name="robo">
						<c:forEach var="error" items="${errors.allErrors}">
							<b><spring:message message="${error}" /></b>
							<br />
						</c:forEach>
					</spring:hasBindErrors>
					<form:form action="/robos/${robo.id}" method="POST"
						commandName="robo">
						<hr>
						<h2 class="intro-text text-center">
							Formulário <strong>Robô</strong>
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
									<td><br> <label for="linkImg"> Link Imagem: </label>
									</td>
									<td><br> <form:input path="linkImg" type="text"
											class="form-control" /></td>
								</tr>
								<tr>
									<td><br> <label for="preco"> Preço: </label></td>
									<td><br> <form:input path="preco" type="text"
											class="form-control" /></td>

								</tr>
								<tr>
									<td><br></td>
									<td><br></td>
									<td><form:button type="submit" class="btn btn-success">Salvar</form:button>
										<form:button type="reset" class="btn btn-primary">Limpar</form:button>
									</td>
								</tr>
							</table>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</body>

<%@ include file="../template/footer.jsp"%>
