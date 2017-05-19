<%@ include file="../template/header.jsp"%>
<body>
	<div class="container">
		<div class="col-md-offset-3 col-md-6">
			<h1 class="text-center"><strong>URL bloqueada!</strong></h1>
			<div class="alert alert-info" align="center">
				<strong><br> Favor efetuar o login para ter acesso a essa página!</strong>
			</div>
			<div align="center">
				<form action="/" method="get">
					<button type="submit" class="btn btn-danger">Ir para Home</button>
				</form>
			</div>
		</div>
	</div>
</body>
<%@ include file="../template/footer.jsp"%>
