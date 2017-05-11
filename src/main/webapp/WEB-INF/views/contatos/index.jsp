<%@ include file="../template/header.jsp"%>
<body>
	<div class="container">
		<div class="col-md-offset-3 col-md-6">
			<h1 class="text-center">Fale Conosco</h1>
			<form:form action="/contatos" commandName="contato" method="POST"
				class="form-horizontal">
				<div class="control-group">
					<label class="control-label" for="nome">Nome:</label> <input
						class="form-control" type="text" id="nome" name="nome"
						placeholder="nome" value="${user.nome}" />
				</div>
				<div class="control-group">
					<label class="control-label" for="email">E-mail:</label> <input
						class="form-control" type="text" id="email" name="email"
						placeholder="Email" value="${user.email }" />
				</div>
				<div class="control-group">
					<label class="control-label" for="inputMsg">Mensagem:</label>
					<div class="controls">
						<textarea class="form-control" name="assunto" rows="8"></textarea>
					</div>
					<br>
				</div>
				<div class="form-actions">
					<button type="submit" class="btn btn-primary">Enviar</button>
				</div>
			</form:form>
		</div>
	</div>
</body>
<%@ include file="../template/footer.jsp"%>
