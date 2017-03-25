package br.com.robotrading.web.controllers;


	
	import org.springframework.context.annotation.Scope;
	import org.springframework.stereotype.Controller;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestMethod;
	import org.springframework.web.context.WebApplicationContext;
	import org.springframework.web.servlet.ModelAndView;

	@Controller
	@RequestMapping("/sistema")
	@Scope(value = WebApplicationContext.SCOPE_REQUEST)

	public class SistemaController {
		
		
		@RequestMapping(value = "/index",method = RequestMethod.GET, name = "montarIndex")
		public ModelAndView montarHome() {
			ModelAndView mav = new ModelAndView("/sistema/index");
			
			return mav;
		}

}
