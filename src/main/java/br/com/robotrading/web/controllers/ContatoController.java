package br.com.robotrading.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.robotrading.web.model.Contato;
import br.com.robotrading.web.services.ContatoService;

@Controller
@RequestMapping("/contatos")
public class ContatoController {

	@Autowired
	private ContatoService contatoService;

	@GetMapping
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView("/contatos/index");

		return mav;
	}

	@PostMapping
	public ModelAndView msgRecebida(Contato contato) {
		ModelAndView mav = new ModelAndView("/contatos/sucesso");

		contatoService.enviarEmail(contato);

		return mav;
	}
}