package br.com.robotrading.web.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.robotrading.web.dao.ClientesDAO;
import br.com.robotrading.web.exception.ClienteNaoExisteException;
import br.com.robotrading.web.model.Cliente;

@Controller
@RequestMapping("/clientes")
public class ClientesController {

	@Autowired
	private ClientesDAO clientesDAO;
	
	@GetMapping("/new")
	public ModelAndView newObj(Cliente clientes) {
		ModelAndView mav = new ModelAndView("cliente/form");
		mav.addObject("clientes", clientes);
		return mav;
	}	

	@PostMapping
	public ModelAndView create(@Valid Cliente cliente, BindingResult result, RedirectAttributes attrs) {
		ModelAndView mav = null;

		if (result.hasErrors()) {
			mav = newObj(cliente);
			mav.addObject("msg", "Campos invalidos");
		} else {
			clientesDAO.save(cliente);
			mav = new ModelAndView("redirect:/clientes");
			System.out.println("salvo");
			attrs.addFlashAttribute("msg", "Cliente criado com sucesso");
		}
		return mav;
	}
	
	@GetMapping("/{idCli}")
	public ModelAndView show(@PathVariable("idCli") Long idCli) {
		ModelAndView mav = new ModelAndView("cliente/show");
		mav.addObject("clientes", findCliente(idCli));
		return mav;
	}
	
	@GetMapping("/{idCli}/edit")
	public ModelAndView edit(@PathVariable("idCli") Long idCli) {
		ModelAndView mav = new ModelAndView("cliente/edit");
		mav.addObject("clientes", findCliente(idCli));
		return mav;
	}
	
	@PostMapping("/{idCli}")
	public ModelAndView update(@PathVariable("idCli") Long idCli, @Valid Cliente clientes, BindingResult result, 
			RedirectAttributes attrs) {
		ModelAndView mav = null;

		findCliente(idCli);

		if (result.hasErrors()) {
			mav = new ModelAndView("cliente/edit");
		} else {
			clientesDAO.save(clientes);
			mav = new ModelAndView("cliente/show");
			attrs.addFlashAttribute("msg", "Dados atualizado com sucesso");
		}
		
		mav.addObject("clientes", clientes);
		return mav;
	}
	
	@GetMapping("/{idCli}/delete")
	public ModelAndView destroy(@PathVariable("idCli") Long idCli, RedirectAttributes attrs) {
		findCliente(idCli);
		clientesDAO.delete(idCli);

		ModelAndView mav = new ModelAndView("redirect:/clientes");
		attrs.addFlashAttribute("msg", "Cliente deletado com sucesso");

		return mav;
	}

	private Cliente findCliente(Long id) {
		if (clientesDAO.exists(id)) {
			return clientesDAO.findOne(id);
		}
		throw new ClienteNaoExisteException();
	}

	// @InitBinder
	// public void initBinder(WebDataBinder binder) {
	// binder.setValidator(new RoboValidator());
	// }
}