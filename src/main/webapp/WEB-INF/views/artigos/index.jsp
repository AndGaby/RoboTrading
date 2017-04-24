<%@ include file="../template/header.jsp"%>

<body>
	<div class="container">
		<%@ include file="barra-menu-admin.jsp"%>
		<div class="row">
			<div class="box">
				<div class="col-md-12 text-center">
					<c:forEach items="${artigos}" var="artigo">
						<div class="col-md-12 text-center">
							<a href="/artigos/${artigo.id}">${artigo.titulo}</a>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>
</body>

<%@ include file="../template/footer.jsp"%>