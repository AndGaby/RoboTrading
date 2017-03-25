<%@ include file="../template/header.jsp"%>

<body>
	<div class="container">
		<div class="row">
			<div class="box">
				<div class="col-md-12 text-center">
					${msg}
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
	</div>
</body>

<%@ include file="../template/footer.jsp"%>