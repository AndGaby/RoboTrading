<%@ include file="../template/header.jsp"%>

<body>
	<div class="container">
		<%@ include file="barra-menu-admin.jsp"%>
		<div class="row">
			<div class="box">
				<div class="col-md-4 text-center">
					<table class="table table-hover">
						<tr>
							<td>Id:</td>
							<td>${robo.id}</td>
						</tr>
						<tr>
							<td>Nome:</td>
							<td>${robo.nome}</td>
						</tr>
						<tr>
							<td>Link da Imagem:</td>
							<td>${robo.linkImg}</td>
						</tr>
						<tr>
							<td>Pre�o:</td>
							<td>${robo.preco}</td>
						</tr>
						<tr>
							<td>Contratados:</td>
							<td>${robo.contratados}</td>
						</tr>
					</table>
				</div>
			</div>
		</div>
	</div>

</body>

<%@ include file="../template/footer.jsp"%>