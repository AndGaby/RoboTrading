<%@ include file="../template/header.jsp"%>

<body>
	<div class="container">
		<div class="row">
			<div class="container">
				<div class="col-md-offset-1 col-md-9">
					<div class="page-header">
						<h1 class="text-center">Artigos</h1>
					</div>
					<c:forEach items="${artigos}" var="artigo">
						<div class="panel-group">
							<div class="panel panel-default">
								<div class="panel-heading text-center">
									<a href="/artigos/${artigo.id}">
										<h4>
											<strong>${artigo.titulo}</strong>
										</h4>
									</a>
								</div>
								<div class="panel-body">
									<p class="text-justify">${artigo.descricao}</p>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>
</body>

<%@ include file="../template/footer.jsp"%>