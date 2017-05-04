package br.com.robotrading.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.robotrading.web.model.RegistroCliente;
import br.com.robotrading.web.model.RegistroRobo;
import br.com.robotrading.web.services.RegistrosService;

@Controller
@RequestMapping("/registros")
public class RegistrosController {

	private RegistrosService registroService;

	@Autowired
	public RegistrosController(RegistrosService registroService) {
		this.registroService = registroService;
	}

	@GetMapping("/robos/{id}")
	public ModelAndView mostrarCompraRobos(@PathVariable("id") Long id) {
		ModelAndView mav = new ModelAndView("registros/robos");
		List<RegistroRobo> registrosRobos = registroService.getRegistroRobo(id);
		mav.addObject("registros", registrosRobos);
		return mav;
	}

	@GetMapping("/clientes/{id}")
	public ModelAndView mostrarCompraDoCliente(@PathVariable("id") Long id) {
		ModelAndView mav = new ModelAndView("registros/clientes");
		List<RegistroCliente> registroCliente = registroService.getRegistroCliente(id);
		mav.addObject("registros",registroCliente);
		return mav;
	}


}
