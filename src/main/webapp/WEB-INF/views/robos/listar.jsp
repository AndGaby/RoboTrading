<%@ include file="../template/header.jsp"%>

<body>
	<div class="container">
		<%@ include file="barra-menu-admin.jsp"%>
		<div class="row">
			<div class="box">
				<div class="col-md-12">
					<table class="table table-hover">
						<thead>
							<tr>
								<th width="40%">Nome</th>
								<th width="15%">Preço</th>
								<th width="15%">Contratados</th>
								<th>Visualizar</th>
								<th>Alterar</th>
								<th>Deletar</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${robos}" var="robo">
								<tr>
									<td>${robo.nome}</td>
									<td>${robo.preco}</td>
									<td>${robo.contratados}</td>
									<td><a href="/robos/${robo.id}" class="btn btn-primary">Visualizar</a></td>
									<td><a href="/robos/${robo.id}/edit" class="btn btn-warning">Alterar</a></td>
									<td><a href="/robos/${robo.id}/delete" class="btn btn-danger">Deletar</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</body>

<%@ include file="../template/footer.jsp"%>