<%@ include file="../template/header.jsp"%>

<body>
	<div class="container">
		<%@ include file="barra-menu-admin.jsp"%>
		<div class="row">
			<div class="box">
				<div class="col-md-12 text-center">
					<spring:hasBindErrors name="robo">
						<c:forEach var="error" items="${errors.allErrors}">
							<b><spring:message message="${error}" /></b>
							<br />
						</c:forEach>
					</spring:hasBindErrors>
					<form:form action="/robos/${robo.id}" method="POST"
						commandName="robo">
						<label for="nome">Nome:</label>
						<form:input path="nome" />
						<br>
						<label for="linkImg">Link Imagem:</label>
						<form:input path="linkImg" />
						<br>
						<label for="preco">Preço:</label>
						<form:input path="preco" />
						<br>
						<form:button>Editar</form:button>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</body>

<%@ include file="../template/footer.jsp"%>