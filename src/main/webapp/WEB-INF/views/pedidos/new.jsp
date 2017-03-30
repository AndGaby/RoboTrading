<%@ include file="../template/header.jsp"%>

<body>

<div class="container">

        <div class="row">
            <div class="box">
                <div class="col-lg-12 text-center"  >
                    
                      
                    <h2 class="intro-text text-center">Seu
                        <strong>Carrinho</strong>
                    </h2>
					<div class="panel panel-success">
					<table class="table table-hover">
					<thead>
							<tr bgcolor="#EEE9E9">
								<th>Nome</th>
								<th>Preço</th>
								<th>Quantidade</th>
								<th>Total Por Item</th>
								<th> </th>
								
							</tr>
						</thead>
						
						
							 <!-- <c:forEach items="${robos}" var="robo"> -->
								<tr>
									<th>Robo time</th>
									<th>80.00</th>
									<th>2</th>
									<th>160.00</th>
									<th><a href="#"><img src="/resources/img/deletar.jpg"></a></th>
								</tr>
							<!--  </c:forEach> -->
						
						
					
						<tr>
								<th> </th>
								<th>  </th>
								<th>  </th>
								<th width="15%">Total: </th>
				
						</tr>
					</table>
					</div>
					
					
						<table class="table table-hover">
							<tr>
								<th> <a href="#" class="btn btn-success"> <img src="resources/img/carrinho.jpg"> Finalizar Compra</a></th>
								<th> <a href="#" class="btn btn-warning"><img src="resources/img/adicionar.jpg"> Adicionar Robô</a> </th>
								<th> <a href="#" > <img src="/resources/img/atualizar.jpg"></a> </th>
							</tr>
						</table>						
				
					
					
	</div>
	</div>
</body>

<%@ include file="../template/footer.jsp"%>