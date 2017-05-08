<%@ include file="../template/header.jsp"%>

<body>
	<div class="container">
		<div class="row">
			<div class="container">
				<div class="col-md-offset-1 col-md-9">
					<div class="page-header">
						<h1 class="text-center">Tutorias</h1>
					</div>
					<c:forEach items="${tutoriais}" var="tutorial">
						<h2 class="text-center">${tutorial.nome}</h2>
						<p>${tutorial.descricao }</p>
						<div class="embed-responsive embed-responsive-16by9">
							<iframe class="embed-responsive-item" src="${tutorial.link}"></iframe>
						</div>
						<br>
						<br>
						<br>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>
</body>

<%@ include file="../template/footer.jsp"%>