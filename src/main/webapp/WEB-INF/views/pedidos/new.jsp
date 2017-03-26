<%@ include file="../template/header.jsp"%>

<body>


	<div class="container">
		<div class="row">
			<div class="box">
				<div class="col-md-12 text-center">
					<spring:hasBindErrors name="pedido">
						<c:forEach var="error" items="${errors.allErrors}">
							<b><spring:message message="${error}" /></b>
							<br />
						</c:forEach>
					</spring:hasBindErrors>

					<form:form action="/pedidos" method="GET" commandName="pedido">

						<!-- Boão do PayPal -->
						<form action="https://www.paypal.com/cgi-bin/webscr" method="post"
							target="_top">
							<input type="hidden" name="cmd" value="_xclick"> <input
								type="hidden" name="business"
								value="anderson_santos980@hotmail.com"> <input
								type="hidden" name="lc" value="BR"> <input type="hidden"
								name="item_name" value="Anderson de Oliveira Santos"> <input
								type="hidden" name="item_number" value="111"> <input
								type="hidden" name="amount" value="1000.00"> <input
								type="hidden" name="currency_code" value="BRL"> <input
								type="hidden" name="button_subtype" value="services"> <input
								type="hidden" name="no_note" value="0"> <input
								type="hidden" name="bn"
								value="PP-BuyNowBF:btn_buynowCC_LG.gif:NonHostedGuest">
							<input type="image"
								src="https://www.paypalobjects.com/pt_BR/BR/i/btn/btn_buynowCC_LG.gif"
								border="0" name="submit"
								alt="PayPal - A maneira fácil e segura de enviar pagamentos online!">
							<img alt="" border="0"
								src="https://www.paypalobjects.com/pt_BR/i/scr/pixel.gif"
								width="1" height="1">
						</form>

					</form:form>
				</div>
			</div>
		</div>
	</div>
</body>

<%@ include file="../template/footer.jsp"%>