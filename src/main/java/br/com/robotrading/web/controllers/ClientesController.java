package br.com.robotrading.web.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.robotrading.web.dao.ClientesDAO;
import br.com.robotrading.web.model.Cliente;

@Controller
@RequestMapping("/clientes")
public class ClientesController {

	@Autowired
	private ClientesDAO clientesDAO;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public ModelAndView index(){
		ModelAndView mav = new ModelAndView("index");
		
		return mav;
	}
	
	@RequestMapping(value="/new", method = RequestMethod.GET, name = "formularioClientes")
	public ModelAndView formularioCadastrarClientes(Cliente clientes) {
		ModelAndView mav = new ModelAndView("form");
		mav.addObject("clientes", clientes);
		return mav;
	}
	
	@RequestMapping(value = "", method = RequestMethod.POST, name = "cadastrarClientes")
	public ModelAndView CadastraClientes(@Valid Cliente clientes, BindingResult result){
		ModelAndView mav = new ModelAndView("form");

		if (result.hasErrors()) {			
			return formularioCadastrarClientes(clientes);
		}
		
		String userName = clientes.getUserNameCli();
		String email = clientes.getEmailCli();
		
		Cliente findByUserNameCli = clientesDAO.findByUserNameCli(userName);
		Cliente findByEmailCli = clientesDAO.findByEmailCli(email);
		
		if(findByUserNameCli != null || findByEmailCli != null){
			 mav = formularioCadastrarClientes(clientes);
			 mav.addObject("mensagem","Usuario ou Email já cadastrado");
			 return mav;
		}else{
			clientesDAO.save(clientes);
			mav.addObject("clientes", new Cliente());
			mav.addObject("mensagem", "Cliente cadastrado com sucesso");
		}		
		return mav;
	}
}