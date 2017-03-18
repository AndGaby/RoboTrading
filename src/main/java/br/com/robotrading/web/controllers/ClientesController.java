package br.com.robotrading.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/clientes")
public class ClientesController {

	@RequestMapping(value = "", method = RequestMethod.GET)
	public ModelAndView index(){
		ModelAndView mav = new ModelAndView("index");
		
		return mav;
	}
}
