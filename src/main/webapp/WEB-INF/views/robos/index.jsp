<%@ include file="../template/header.jsp"%>

<body>
	<div class="container">
		<%@ include file="barra-menu-admin.jsp"%>
		<div class="row">
			<div class="box">
				<div class="col-md-12 text-center">
					<c:forEach items="${robos}" var="robo">
						<form action="./pedidos/add" method="POST">
							<div class="col-md-6 text-center">
								<div class="panel panel-primary col-md-12">
									<div class="titulo col-md-12">
										<h3>
											<font size="3" color="000000"><span
												class="glyphicon glyphicon-signal"></span></font> <small>${robo.nome}</small>
											<br>
										</h3>
									</div>
									<div class="imagem col-md-12">
										<p align="center">
											<img class="img-responsive img-border img-left"
												src="/resources/imagens_robo/${robo.linkImg}" alt="">
										</p>
										<br> <br>
									</div>
									<div class="form-group col-md-12">
										<h6>
											<label for="quantity">Quantidade: </label> <input
												type="number" class="btn btn-default" name="quantity"
												value="0" min="1" max="50" /> <input type="hidden"
												name="idRobo" value="${robo.id}" />
										</h6>
										<h4>
											<font color="#228B22"> <label>Preço:</label>
												${robo.preco}
											</font>
										</h4>
									</div>

									<div class="form-group col-md-12">
										<input type="submit" class="btn btn-success" value="Comprar" />
										<a href="./robos/estatisticas/${robo.id}" type="button"
											class="btn btn-primary">Estatísticas</a>
									</div>
								</div>
							</div>
						</form>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>
</body>

<%@ include file="../template/footer.jsp"%>