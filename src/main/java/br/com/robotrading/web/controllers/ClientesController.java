package br.com.robotrading.web.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.robotrading.web.model.Cliente;
import br.com.robotrading.web.services.ClienteService;

@Controller
@RequestMapping("/clientes")
public class ClientesController {
	
	@Autowired
	private ClienteService clienteService;

	@GetMapping("/login/{id}")
	public void metodoAuxiliarTeste(@PathVariable("id") Long idCli, HttpSession session) {
		session.setAttribute("user", clienteService.findCliente(idCli));
	}

	@GetMapping("/new")
	public ModelAndView newObj(Cliente clientes) {
		ModelAndView mav = new ModelAndView("clientes/form");
		mav.addObject("clientes", clientes);
		return mav;
	}
	
	@GetMapping("/erro")
	public ModelAndView erroSessao() {
		ModelAndView mav = new ModelAndView("clientes/erro-sessao");
		return mav;
	}

	@PostMapping
	public ModelAndView create(@Valid Cliente cliente, BindingResult result, RedirectAttributes attrs) {
		ModelAndView mav = null;

		if (result.hasErrors()) {
			mav = newObj(cliente);
			mav.addObject("msg", "Campos invalidos");
		} else {
			clienteService.save(cliente);
			mav = new ModelAndView("redirect:/robos");
			attrs.addFlashAttribute("msg", "Cliente criado com sucesso");
		}
		return mav;
	}

	@GetMapping("/{idCli}")
	public ModelAndView show(@PathVariable("idCli") Long idCli) {
		ModelAndView mav = new ModelAndView("clientes/show");
		mav.addObject("clientes", clienteService.findCliente(idCli));
		return mav;
	}
	
	@GetMapping("/account/{idCli}")
	public ModelAndView account(@PathVariable("idCli") Long idCli) {
		ModelAndView mav = new ModelAndView("clientes/account");
		return mav;
	}

	@GetMapping("/{idCli}/edit")
	public ModelAndView edit(@PathVariable("idCli") Long idCli) {
		ModelAndView mav = new ModelAndView("clientes/edit");
		mav.addObject("clientes", clienteService.findCliente(idCli));
		return mav;
	}

	@PostMapping("/loginsMetatrader/{idCli}")
	public ModelAndView update(@PathVariable("idCli") Long idCli,@RequestParam("loginsMetatrader") String[] loginsMetatrader,
			RedirectAttributes attrs) {
		ModelAndView mav = null;

		Cliente cliente = clienteService.updateLoginsMetatrader(idCli, loginsMetatrader);
		mav = new ModelAndView("clientes/account");
		attrs.addFlashAttribute("msg", "Dados atualizado com sucesso");
		mav.addObject("cliente", cliente);
		return mav;
	}

	@GetMapping("/{idCli}/delete")
	public ModelAndView destroy(@PathVariable("idCli") Long idCli, RedirectAttributes attrs) {
		clienteService.findCliente(idCli);
		clienteService.delete(idCli);
		
		ModelAndView mav = new ModelAndView("redirect:/clientes");
		attrs.addFlashAttribute("msg", "Cliente deletado com sucesso");

		return mav;
	}
}