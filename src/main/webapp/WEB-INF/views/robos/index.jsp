<%@ include file="../template/header.jsp"%>

<body>
	${msg}
	<div class="container">
		<div class="row">
			<div class="col-md-4">
				<table class="table">
					<tr>
						<th>Id</th>
						<th>Nome</th>
					</tr>
					<c:forEach items="${robos}" var="robo">
						<tr>
							<td>${robo.id}</td>
							<td>${robo.nome}</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>

</body>

<%@ include file="../template/footer.jsp"%>