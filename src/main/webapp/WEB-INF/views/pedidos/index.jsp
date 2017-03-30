<%@ include file="../template/header.jsp"%>

<body>
	<div class="container">
		<%@ include file="barra-menu-admin.jsp"%>
		<div class="row">
			<div class="box">
				<div class="col-md-12 text-center">
					<c:forEach items="${robos}" var="robo">
						<div class="col-md-5 text-center">
								<div class="panel panel-primary">
									<h3>
										<font size="3" color="000000"><span
											class="glyphicon glyphicon-signal"></span></font> <small>${robo.nome}</small>
										<br>
									</h3>
									<p align="center">
										<img class="img-responsive img-border img-left"
											src="/resources/img/img5.jpg" alt="">
									</p>
									<br> <br>

									<div class="form-group col-lg-0">
										<h6>
											Quantidade: <input type="number" class="btn btn-default"
												name="quantity" value="0" min="1" max="50"></input>
										</h6>
										<h4>
											Preço:<font color="#228B22"> ${robo.preco} 
										</h4>
										</font>
									</div>

									<div class="form-group col-lg-0">
										
										<a href= "./pedido/new" type="button" class="btn btn-success">Comprar</a></td>
										<a href= "./Estatisticas/" type="button" class="btn btn-primary">Estatísticas</a></td>
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