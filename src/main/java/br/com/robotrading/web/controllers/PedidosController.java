package br.com.robotrading.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import br.com.robotrading.web.dao.RobosDAO;
import br.com.robotrading.web.exception.RoboNaoExisteException;
import br.com.robotrading.web.model.Robo;

@Controller
@RequestMapping("/pedidos")
public class PedidosController {
	
	private RobosDAO robosDAO;

	@Autowired
	public PedidosController(RobosDAO robosDAO) {
		this.robosDAO = robosDAO;
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
