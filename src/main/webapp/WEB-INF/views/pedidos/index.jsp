<%@ include file="../template/header.jsp"%>

<body>

	<div class="container">
		<div class="row">
			<div class="box">
				<div class="col-md-12 text-center">
					<h2 class="intro-text text-center">
						Seu <strong>Carrinho</strong>
					</h2>
					<div class="panel panel-success">
						<table class="table table-hover">
							<thead>
								<tr bgcolor="#EEE9E9">
									<th>Nome</th>
									<th>Preço</th>
									<th>Quantidade</th>
									<th>Total</th>
									<th>Remover</th>
								</tr>
							</thead>
							<c:forEach items="${carrinho.robos}" var="item">
								<tr>
									<th>${item.key.nome}</th>
									<th>${item.key.preco}</th>
									<th>${item.value}</th>
									<th>${item.value * item.key.preco}</th>
									<th>Remover</th>
								</tr>
							</c:forEach>
						</table>
							Valor total: ${carrinho.total}
					</div>
					<table class="table table-hover">
						<tr>
							<th><a href="/pedidos/finalizar" class="btn btn-success"> <img
									src="resources/img/carrinho.jpg"> Finalizar Compra
							</a></th>
							<th><a href="./robos" class="btn btn-warning"><img
									src="resources/img/adicionar.jpg"> Adicionar Robô</a></th>
						</tr>
					</table>
				</div>
			</div>
		</div>
	</div>
</body>

<%@ include file="../template/footer.jsp"%>