package br.com.robotrading.web.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import br.com.robotrading.web.dao.RobosDAO;
import br.com.robotrading.web.exception.QuantidadeRoboInvalidoException;
import br.com.robotrading.web.exception.RoboNaoExisteException;
import br.com.robotrading.web.model.Pedido;
import br.com.robotrading.web.model.PedidosItens;
import br.com.robotrading.web.model.Robo;

@Controller
@RequestMapping("/pedidos")
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
public class PedidosController {

	private RobosDAO robosDAO;
	private Pedido pedido;

	@Autowired
	public PedidosController(RobosDAO robosDAO, Pedido pedido) {
		this.robosDAO = robosDAO;
		this.pedido = pedido;
	}

	@PostMapping("/add")
	public ModelAndView add(Integer quantity, Long idRobo, HttpSession session) {
		ModelAndView mav = new ModelAndView("redirect:/pedidos");
		PedidosItens pedidoItem = criaPedido(idRobo);

		// extrair esse metodo para validator
		if (quantity < 1)
			throw new QuantidadeRoboInvalidoException();

		pedido.add(pedidoItem, quantity);
		session.setAttribute("pedidos", pedido);
		return mav;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView itens() {
		return new ModelAndView("pedidos/index");
	}

	private PedidosItens criaPedido(Long id) {
		Robo robo = findRobo(id);
		PedidosItens pedidoItem = new PedidosItens(robo);
		return pedidoItem;
	}

	private Robo findRobo(Long id) {
		if (robosDAO.exists(id)) {
			return robosDAO.findOne(id);
		}

		throw new RoboNaoExisteException();
	}

	// @InitBinder
	// public void initBinder(WebDataBinder binder) {
	// binder.setValidator(new RoboValidator());
	// }
}