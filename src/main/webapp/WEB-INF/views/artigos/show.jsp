<%@ include file="../template/header.jsp"%>

<body>
	<div class="container">
		<%@ include file="barra-menu-admin.jsp"%>
		<div class="row">
			<div class="box">
				<div class="col-md-offset-2 col-md-8">
					<h3>${artigo.titulo }</h3>
					<a href="${artigo.linkArtigo}" target="_blank">Esse artigo foi retirado de
						outra fonte. Clique aqui para ler na fonte original.</a>
					<hr>
					<div class="col-md-12">${artigo.textoArtigo }</div>
					<div class="col-md-12">
						<a href="/artigos/${artigo.id}/edit" class="btn btn-warning">Alterar</a>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>

<%@ include file="../template/footer.jsp"%>