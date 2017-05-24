<%@ include file="../template/header.jsp"%>
<br>
<br>
<body>
	<div class="container">
		<div class="row">
			<div class="box">
				<div class="col-md-12 text-center">
					<div id="carousel-example-generic" class="carousel slide">
						<!-- Indicators -->
						<ol class="carousel-indicators hidden-xs">
							<li data-target="#carousel-example-generic" data-slide-to="0"
								class="active"></li>
							<li data-target="#carousel-example-generic" data-slide-to="1"></li>
							<li data-target="#carousel-example-generic" data-slide-to="2"></li>
						</ol>

						<!-- Wrapper for slides -->
						<div class="carousel-inner">
							<div class="item active">
								<p align="center">
									<img class="img-responsive img-full"
										src="/resources/img/img2.jpg" alt="">
								</p>
							</div>
							<div class="item">
								<p align="center">
									<img class="img-responsive img-full"
										src="/resources/img/img3.png" alt="">
								</p>
							</div>
							<div class="item">
								<p align="center">
									<img class="img-responsive img-full"
										src="/resources/img/img4.jpg" alt="">
								</p>
							</div>
						</div>

						<!-- Controls -->
						<a class="left carousel-control" href="#carousel-example-generic"
							data-slide="prev"> <span class="icon-prev"></span>
						</a> <a class="right carousel-control"
							href="#carousel-example-generic" data-slide="next"> <span
							class="icon-next"></span>
						</a>
					</div>
					<h2 class="brand-before">
						<small>Bem Vindo </small> <small>Robô Trading </small>
					</h2>

					<hr class="tagline-divider">
					<h2></h2>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="box">
				<div class="col-lg-12">
					<div id="div-fundo-home">
						<hr>
						
						<br>
						
						<h2 id="texto-branco-titulo">
							Conheça: <strong> O Sistema </strong>
						</h2>
						<hr>

						<hr class="visible-xs">
						<p id="texto-branco">Para investimentos automatizados, o único
							auxílio humano é no ajuste dos parâmetros, esses serão utilizados
							para determinar qual rumo o robô deve seguir, investimento com
							níveis de risco maiores ou menores.</p>
						<p id="texto-branco">O principal foco do robô será day trade,
							operações iniciadas e finalizadas no mesmo dia. Com o objetivo de
							ganhar pouco por operações porém ganhar muitas vezes.</p>
					</div>
				</div>
			</div>
		</div>

	</div>
	<!-- /.container -->

	<script>
		$('.carousel').carousel({
			interval : 5000
		//changes the speed
		})
	</script>
</body>
<%@ include file="../template/footer.jsp"%>
