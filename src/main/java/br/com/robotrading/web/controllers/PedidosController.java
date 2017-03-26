package br.com.robotrading.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import br.com.robotrading.web.dao.RobosDAO;
import br.com.robotrading.web.exception.RoboNaoExisteException;
import br.com.robotrading.web.model.Pedido;
import br.com.robotrading.web.model.PedidosItens;
import br.com.robotrading.web.model.Robo;

@Controller
@RequestMapping("/pedidos")
@Scope(value=WebApplicationContext.SCOPE_REQUEST)
public class PedidosController {
	
	private RobosDAO robosDAO;

	@Autowired
	private Pedido pedido;
	
	@Autowired
	public PedidosController(RobosDAO robosDAO) {
		this.robosDAO = robosDAO;
	}
	
	@GetMapping("/new")
	public ModelAndView add(Integer id) {
		ModelAndView mav = new ModelAndView("redirect:pedidos");
		PedidosItens pedidoItem = criaPedido(id);
		pedido.add(pedidoItem);
		mav.addObject("pedidos", pedido);
		return mav;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView itens(){
		return new ModelAndView("pedidos/new");
	}

	private PedidosItens criaPedido(Integer id) {
		Robo robo = findRobo(id);
		PedidosItens pedidoItem = new PedidosItens(robo);
		return pedidoItem;
	}

	private Robo findRobo(Integer id) {
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