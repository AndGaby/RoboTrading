<%@ include file="../template/header.jsp"%>

<body>

	<div class="container">
		<div class="row">
			<div class="box">
				<div class="col-md-12 text-center">
					<h2 class="intro-text text-center">
						<strong>Registro do Cliente -
							${registros[0].cliente.nome}</strong>
					</h2>
					<div class="panel panel-success">
						<table class="table table-hover">
							<thead>
								<tr bgcolor="#EEE9E9">
									<th><center>Imagem</center></th>
									<th><center>Robô</center></th>
									<th><center>Quantidade</center></th>
									<th><center>Data</center></th>
								</tr>
							</thead>
							<c:forEach items="${registros}" var="reg">
								<tr>
									<c:forEach items="${reg.robos}" var="robos">
										<td width="20%" >
											<div class="conteudo-robo-imagem">
													<img class="img-responsive img-border img-left"
														src="/resources/imagens_robo/${robos.key.linkImg}" alt="">
											</div>
										</td>
										<th><center>${robos.key.nome}</center></th>
										<th><center>${robos.value}</center></th>
									</c:forEach>
									<th><center><fmt:formatDate pattern="dd/MM/YYYY"
											value="${reg.dataFormatada}" /></center>
									</th>
							</c:forEach>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>

<%@ include file="../template/footer.jsp"%>