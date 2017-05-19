package br.com.robotrading.web.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.robotrading.web.dao.RobosDAO;
import br.com.robotrading.web.model.Robo;
import br.com.robotrading.web.services.RobosService;

@Controller
@RequestMapping("/robos")
public class RobosController {
	
	@Autowired
	private RobosDAO robosDAO;
	@Autowired
	private RobosService robosService;

	@GetMapping
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView("robos/index");
		mav.addObject("robos", robosDAO.findAll());
		return mav;
	}

	@GetMapping("/listar")
	public ModelAndView indexAdmin() {
		ModelAndView mav = new ModelAndView("robos/listar");
		mav.addObject("robos", robosDAO.findAll());
		return mav;
	}

	@GetMapping("/new")
	public ModelAndView newObj(Robo robo) {
		ModelAndView mav = new ModelAndView("robos/new");
		mav.addObject("robo", robo);
		return mav;
	}

	@PostMapping
	public ModelAndView create(@Valid Robo robo, BindingResult result, RedirectAttributes attrs,
			@RequestParam("imagem-robo") MultipartFile imagemRobo) {
		ModelAndView mav = null;

		if (result.hasErrors()) {
			mav = newObj(robo);
			mav.addObject("msg", "Campos invalidos");
		} else {
			Robo newRobo = robosDAO.save(robo);
			newRobo.setLinkImg(robosService
					.handleFileUpload(imagemRobo, newRobo.getId(), null));
			robosDAO.save(newRobo);
			mav = new ModelAndView("redirect:/robos/listar");
			attrs.addFlashAttribute("msg", "Robô criado com sucesso");
		}

		return mav;
	}

	@GetMapping("/{id}")
	public ModelAndView show(@PathVariable("id") Long id) {
		ModelAndView mav = new ModelAndView("robos/show");
		mav.addObject("robo", robosService.findRobo(id));
		return mav;
	}

	@GetMapping("/{id}/edit")
	public ModelAndView edit(@PathVariable("id") Long id) {
		ModelAndView mav = new ModelAndView("robos/edit");
		mav.addObject("robo", robosService.findRobo(id));
		return mav;
	}

	@PostMapping("/{id}")
	public ModelAndView update(@PathVariable("id") Long id, @Valid Robo robo, BindingResult result,
			RedirectAttributes attrs, @RequestParam("imagem-robo") MultipartFile imagemRobo) {
		ModelAndView mav = null;
		robosService.findRobo(id);

		if (result.hasErrors()) {
			mav = new ModelAndView("robos/edit");
		} else {
			if (imagemRobo != null)
				robo.setLinkImg(robosService
					.handleFileUpload(imagemRobo, id, robo.getLinkImg()));
			robosDAO.save(robo);
			mav = new ModelAndView("robos/show");
			attrs.addFlashAttribute("msg", "Robô atualizado com sucesso");
		}

		mav.addObject("robo", robo);
		return mav;
	}

	@GetMapping("/{id}/delete")
	public ModelAndView destroy(@PathVariable("id") Long id, RedirectAttributes attrs) {
		Robo robo = robosService.findRobo(id);
		robosDAO.delete(id);
		robosService.deleteRoboImage(robo);
		ModelAndView mav = new ModelAndView("redirect:/robos/listar");
		attrs.addFlashAttribute("msg", "Robô deletado com sucesso");
		return mav;
	}
}
