<%@ include file="../template/header.jsp"%>

<body>
	<div class="container">
		<div class="row">
			<div class="box">
				<div class="col-lg-12 text-center">
					<spring:hasBindErrors name="robo">
						<c:forEach var="error" items="${errors.allErrors}">
							<b><spring:message message="${error}" /></b>
							<br />
						</c:forEach>
					</spring:hasBindErrors>
					<form:form action="/artigos" method="POST" commandName="robo">
						<hr>
						<h2 class="intro-text text-center">
							Formulário <strong>Robô</strong>
						</h2>
						<hr>
						<p align="center">Preencha corretamente os campos abaixo:</p>
						<div class="row">

							<button id="edit" class="btn btn-primary" onclick="edit()"
								type="button">Edit 1</button>
							<button id="save" class="btn btn-primary" onclick="save()"
								type="button">Save 2</button>
							<div class="click2edit">click2edit</div>

						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</body>

<%@ include file="../template/footer.jsp"%>
