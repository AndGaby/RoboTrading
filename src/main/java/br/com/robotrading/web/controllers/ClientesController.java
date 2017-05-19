package br.com.robotrading.web.controllers;

import java.util.ArrayList;
import java.util.List;

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

import br.com.robotrading.web.dao.ClientesDAO;
import br.com.robotrading.web.dao.LoginMetatradeDAO;
import br.com.robotrading.web.exception.ClienteNaoExisteException;
import br.com.robotrading.web.model.Cliente;
import br.com.robotrading.web.model.LoginMetatrade;

@Controller
@RequestMapping("/clientes")
public class ClientesController {

	@Autowired
	private ClientesDAO clientesDAO;
	
	@Autowired
	private LoginMetatradeDAO loginMetatradeDAO;

	@GetMapping("/login/{id}")
	public void metodoAuxiliarTeste(@PathVariable("id") Long idCli, HttpSession session) {
		session.setAttribute("user", findCliente(idCli));
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
			clientesDAO.save(cliente);
			mav = new ModelAndView("redirect:/robos");
			attrs.addFlashAttribute("msg", "Cliente criado com sucesso");
		}
		return mav;
	}

	@GetMapping("/{idCli}")
	public ModelAndView show(@PathVariable("idCli") Long idCli) {
		ModelAndView mav = new ModelAndView("clientes/show");
		mav.addObject("clientes", findCliente(idCli));
		return mav;
	}
	
	@GetMapping("/account/{idCli}")
	public ModelAndView account(@PathVariable("idCli") Long idCli) {
		ModelAndView mav = new ModelAndView("clientes/account");
//		mav.addObject("cliente", findCliente(idCli));
		return mav;
	}

	@GetMapping("/{idCli}/edit")
	public ModelAndView edit(@PathVariable("idCli") Long idCli) {
		ModelAndView mav = new ModelAndView("clientes/edit");
		mav.addObject("clientes", findCliente(idCli));
		return mav;
	}

	@PostMapping("/{idCli}")
	public ModelAndView update(@PathVariable("idCli") Long idCli,@RequestParam("loginsMetatrader") String[] loginsMetatrader,
			RedirectAttributes attrs) {
		ModelAndView mav = null;

		Cliente cliente = findCliente(idCli);
		List<LoginMetatrade> oldLogins = cliente.getLoginsMetatrade();
		List<LoginMetatrade> newLogins = new ArrayList<>();
		List<LoginMetatrade> removeLogins = new ArrayList<>();
		
		for (String loginMetatrader : loginsMetatrader) {
			if(!loginMetatrader.isEmpty() && loginMetatrader != null){
				LoginMetatrade login = new LoginMetatrade();
				login.setCliente(cliente);
				login.setLoginMetatrade(loginMetatrader);
				newLogins.add(login);
				oldLogins.stream()
						 .filter(old -> old.equals(login))
						 .forEach(old -> {
							 	newLogins.remove(login);
							 	newLogins.add(old);
								removeLogins.add(old); 
						});		
			}
		}
		
		removeLogins.stream()
					.forEach(r -> oldLogins.remove(r));
		
		cliente.setLoginsMetatrade(newLogins);
		clientesDAO.save(cliente);
		loginMetatradeDAO.delete(oldLogins);
		mav = new ModelAndView("clientes/account");
		attrs.addFlashAttribute("msg", "Dados atualizado com sucesso");
		mav.addObject("cliente", cliente);
		
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