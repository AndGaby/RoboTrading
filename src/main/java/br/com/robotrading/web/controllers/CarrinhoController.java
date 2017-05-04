package br.com.robotrading.web.controllers;

import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import br.com.robotrading.web.dao.CarrinhoDAO;
import br.com.robotrading.web.dao.RobosDAO;
import br.com.robotrading.web.exception.QuantidadeRoboInvalidoException;
import br.com.robotrading.web.exception.RoboNaoExisteException;
import br.com.robotrading.web.model.Carrinho;
import br.com.robotrading.web.model.Cliente;
import br.com.robotrading.web.model.Robo;

@Controller
@RequestMapping("/pedidos")
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
public class CarrinhoController {

	private static final String VALOR_CART = "carrinho";
	private RobosDAO robosDAO;
	private CarrinhoDAO carrinhoDAO;
	private Carrinho carrinho;

	@Autowired
	public CarrinhoController(RobosDAO robosDAO, CarrinhoDAO carrinhoDAO, HttpSession session) {
		this.robosDAO = robosDAO;
		this.carrinhoDAO = carrinhoDAO;
		this.carrinho = checarSeExisteCarrinhoCriado(session);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView itens() {
		return new ModelAndView("pedidos/index");
	}

	@PostMapping("/add")
	public ModelAndView add(Integer quantity, Long idRobo, HttpSession session) {
		ModelAndView mav = new ModelAndView("redirect:/pedidos");
		Robo robo = findRobo(idRobo);

		if (quantity < 1)
			throw new QuantidadeRoboInvalidoException();

		carrinho.add(robo, quantity);

		return mav;
	}

	@RequestMapping(value = "/finalizar", method = RequestMethod.GET)
	public ModelAndView finalizePurchase(HttpSession session) {
		ModelAndView mav = new ModelAndView("redirect:/robos");
		Cliente cliente = (Cliente) session.getAttribute("user");

		if (cliente == null) {
			// lancar error
		}
		

		carrinho.setCliente(cliente);
		carrinho.setDataCompra(LocalDateTime.now());
		carrinhoDAO.save(carrinho);
		session.setAttribute(VALOR_CART, new Carrinho());
		return mav;
	}

	private Robo findRobo(Long id) {
		if (robosDAO.exists(id)) {
			return robosDAO.findOne(id);
		}
		throw new RoboNaoExisteException();
	}

	private Carrinho checarSeExisteCarrinhoCriado(HttpSession session) {
		Object carrinho = session.getAttribute(VALOR_CART);
		if (carrinho == null) {
			Carrinho carrinhoaAux = new Carrinho();
			session.setAttribute(VALOR_CART, carrinhoaAux);
			return carrinhoaAux;
		}
		return (Carrinho) carrinho;
	}
	// @InitBinder
	// public void initBinder(WebDataBinder binder) {
	// binder.setValidator(new RoboValidator());
	// }
}