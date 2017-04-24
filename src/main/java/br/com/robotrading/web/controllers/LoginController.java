package br.com.robotrading.web.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.robotrading.web.dao.ClientesDAO;
import br.com.robotrading.web.model.Cliente;

@Controller
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private ClientesDAO clienteDAO;

	@PostMapping
	public ModelAndView autenticar(String email, String password, HttpSession session) {
		ModelAndView mav = new ModelAndView("home/index");

		Cliente cliente = clienteDAO.findByEmailAndPassword(email, password);
		if (cliente != null) {
			session.setAttribute("user", cliente);
		}
		
		return mav;
	}

	@GetMapping
	public ModelAndView deslogar(HttpSession session) {
		ModelAndView mav = new ModelAndView("home/index");
		session.setAttribute("user", null);
		return mav;
	}
}
