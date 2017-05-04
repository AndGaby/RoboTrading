<%@ include file="../template/header.jsp"%>

<body>
	<div class="container">
		<div class="row">
			<div class="box">
				<div class="col-md-12">
					<hr>
					<h2 class="intro-text text-center">
						Lista <strong>Artigos</strong>
					</h2>
					<hr>
					<div class="col-md-offset-2 col-md-8 panel panel-success">
						<table class="table table-hover">
							<thead>
								<tr>
									<th width="70%">Titulo</th>
									<th></th>
									<th></th>
									<th></th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${artigos}" var="artigo">
									<tr>
										<td>${artigo.titulo}</td>
										<td><a href="/artigos/${artigo.id}"
											class="btn btn-primary btn-xs">Visualizar</a></td>
										<td><a href="/artigos/${artigo.id}/edit"
											class="btn btn-warning btn-xs">Alterar</a></td>
										<td><a href="/artigos/${artigo.id}/delete"
											class="btn btn-danger btn-xs">Deletar</a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>

<%@ include file="../template/footer.jsp"%>