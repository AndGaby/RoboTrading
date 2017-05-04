<%@ include file="../template/header.jsp"%>

<body>
	<div class="container">
		<div class="row">
			<div class="box">
				<div class="col-md-12">
					<spring:hasBindErrors name="robo">
						<c:forEach var="error" items="${errors.allErrors}">
							<b><spring:message message="${error}" /></b>
							<br />
						</c:forEach>
					</spring:hasBindErrors>
					<form:form action="/artigos" method="POST" commandName="artigo">
						<hr>
						<h2 class="intro-text text-center">
							Postar <strong>Artigo</strong>
						</h2>
						<hr>
						<div class="col-md-offset-3 col-md-6">
							<label for="titulo"> Titulo: </label>
							<form:input path="titulo" type="text" class="form-control" />
						</div>
						<div class="col-md-offset-3 col-md-6">
							<label for="linkArtigo"> Link: </label>
							<form:input path="linkArtigo" type="text" class="form-control" />
						</div>
						<div class="col-md-offset-3 col-md-6">
							<label for="summernote"> Texto do Artigo: </label>
							<form:textarea id="summernote" class="form-control" path="textoArtigo"/>
						</div>
						<div class="col-md-offset-3 col-md-6">
							<div class="col-md-2">
								<input class="btn btn-success" type="submit" value="Salvar" />
							</div>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</body>

<%@ include file="../template/footer.jsp"%>
