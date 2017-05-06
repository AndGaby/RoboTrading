<%@ include file="../template/header.jsp"%>

<body>
	<div id="main_wrapper">
        <div id="main_content">
        </div>
	</div>
	<div class="container">
		<div class="row">
			<div class="col-md-offset-2 col-md-8 text-center">
				<c:forEach items="${robos}" var="robo">
					<form action="./pedidos/add" method="POST">
						<div class="col-md-6 text-center ">
							<div class="panel panel-primary col-md-12 conteudo-robo">
								<div class="titulo col-md-12">
									<h3>
										<font size="3" color="000000"><span
											class="glyphicon glyphicon-signal"></span></font> <small>${robo.nome}</small>
										<br>
									</h3>
								</div>
								<div class="conteudo-robo-imagem col-md-12">
									<p align="center">
										<img class="img-responsive img-border img-center"
											src="/resources/imagens_robo/${robo.linkImg}" alt="">
									</p>
								</div>
								<div class="form-group col-md-12">
									<h6>
										<label for="quantity">Quantidade: </label> <input
											type="number" class="btn btn-default" name="quantity"
											value="1" min="1" max="50" /> <input type="hidden"
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
									<a href="./robos/${robo.id}" type="button"
										class="btn btn-primary">Detalhes</a>
								</div>
							</div>
						</div>
					</form>
				</c:forEach>
			</div>
		</div>
	</div>
</body>

<%@ include file="../template/footer.jsp"%>
