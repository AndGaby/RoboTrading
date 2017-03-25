package br.com.robotrading.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class HomeController {

	@GetMapping
	public ModelAndView montarHome() {
		ModelAndView mav = new ModelAndView("home/index");
		return mav;
	}

}
