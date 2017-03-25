<%@ include file="../template/header.jsp"%>

<body>

	<div class="container">
		<div class="row">
			<spring:hasBindErrors name="robo">
				<c:forEach var="error" items="${errors.allErrors}">
					<b><spring:message message="${error}" /></b>
					<br />
				</c:forEach>
			</spring:hasBindErrors>
			<div class="col-sm-4">
				<form:form action="/robos/${robo.id}" method="POST"
					commandName="robo">
					<label for="foto">Nome:</label>
					<form:input path="nome" />
					<form:button>Editar</form:button>
				</form:form>
			</div>
		</div>
	</div>

</body>

<%@ include file="../template/footer.jsp"%>