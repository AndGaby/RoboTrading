<%@ include file="../template/header.jsp"%>

<body>
	<div class="container">
		<div class="row">
			<div class="box">
				<div class="col-md-offset-2 col-md-8">
					<h2>${artigo.titulo }</h2>
					<a class="btn btn-default" href="${artigo.linkArtigo}"
						target="_blank"><strong>Clique aqui para ler na fonte
							original.</strong></a>
					<hr>
					<div class="col-md-12">${artigo.textoArtigo }</div>
				</div>
			</div>
		</div>
	</div>

</body>

<%@ include file="../template/footer.jsp"%>