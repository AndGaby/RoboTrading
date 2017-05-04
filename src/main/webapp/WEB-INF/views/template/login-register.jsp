
<ul class="nav navbar-nav navbar-right">
	<li class="dropdown"><a href="#" class="dropdown-toggle"
		data-toggle="dropdown">Cadastre-se <span class="caret"></span></a>
		<ul class="dropdown-menu dropdown-lr animated flipInX" role="menu">
			<div class="col-md-12">
				<div class="text-center">
					<h3>
						<b>Cadastre-se</b>
					</h3>
				</div>
				<form id="ajax-register-form" action="/clientes/new" method="POST"
					role="form" autocomplete="off">
					<div class="form-group">
						<input type="text" name="nome" id="nome" tabindex="1"
							class="form-control" placeholder="Nome" value="">
					</div>
					<div class="form-group">
						<input type="email" name="email" id="email" tabindex="1"
							class="form-control" placeholder="E-mail" value="">
					</div>
					<div class="form-group">
						<input type="password" name="password" id="password" tabindex="2"
							class="form-control" placeholder="Senha">
					</div>
					<div class="form-group">
						<input type="password" name="confirm-password"
							id="confirm-password" tabindex="2" class="form-control"
							placeholder="Confirmar Senha">
					</div>
					<div class="form-group">
						<div class="row">
							<div class="col-xs-6 col-xs-offset-3">
								<input type="submit" name="register-submit" id="register-submit"
									tabindex="4" class="form-control btn btn-info"
									value="Cadastrar" />
							</div>
						</div>
					</div>
				</form>
			</div>
		</ul></li>
	<li class="dropdown"><a href="#" class="dropdown-toggle"
		data-toggle="dropdown">Entrar <span class="caret"></span></a>
		<ul class="dropdown-menu dropdown-lr animated slideInRight"
			role="menu">
			<div class="col-md-12">
				<div class="text-center">
					<h3>
						<b>Entrar</b>
					</h3>
				</div>
				<form id="ajax-login-form" action="/login" method="POST" role="form"
					autocomplete="off">
					<div class="form-group">
						<label for="email">E-mail</label> <input type="text" name="email"
							id="email" tabindex="1" class="form-control" placeholder="E-mail"
							value="" autocomplete="off">
					</div>

					<div class="form-group">
						<label for="password">Senha</label> <input type="password"
							name="password" id="password" tabindex="2" class="form-control"
							placeholder="Senha" autocomplete="off">
					</div>

					<div class="form-group">
						<div class="row">
							<div class="col-xs-7">
								<!-- 								<input type="checkbox" tabindex="3" name="remember" -->
								<!-- 									id="remember"> <label for="remember"> Remember -->
								<!-- 									Me</label> -->
							</div>
							<div class="col-xs-5 pull-right">
								<input type="submit" name="login-submit" id="login-submit"
									tabindex="4" class="form-control btn btn-success"
									value="Log In">
							</div>
						</div>
					</div>

					<div class="form-group">
						<div class="row">
							<div class="col-lg-12">
								<div class="text-center">
									<a href="/login/recuperar" tabindex="5" class="forgot-password">Esqueci
										minha senha</a>
								</div>
							</div>
						</div>
					</div>
				</form>
			</div>
		</ul></li>
</ul>