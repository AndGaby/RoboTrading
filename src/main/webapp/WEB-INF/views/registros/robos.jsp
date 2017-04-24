<%@ include file="../template/header.jsp"%>

<body>

	<div class="container">
		<div class="row">
			<div class="box">
				<div class="col-md-12 text-center">
					<h2 class="intro-text text-center">
						<strong>Registro do Robô - ${registros[0].robo.nome}</strong>
					</h2>
					<div class="panel panel-success">
						<table class="table table-hover">
							<thead>
								<tr bgcolor="#EEE9E9">
									<th>Comprador</th>
									<th>Quantidade</th>
									<th>Data</th>
								</tr>
							</thead>
							<c:forEach items="${registros}" var="reg">
								<tr>
									<th><a href="/clientes/${reg.cliente.id}">${reg.cliente.nome}</a></th>
									<th>${reg.quantidade}</th>
									<th>${reg.dataCompra}</th>
							</c:forEach>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>

<%@ include file="../template/footer.jsp"%>