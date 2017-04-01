package br.com.robotrading.web.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.robotrading.web.dao.ArtigoDAO;
import br.com.robotrading.web.exception.ArtigoNaoExisteException;
import br.com.robotrading.web.model.Artigo;

@Controller
@RequestMapping("/artigos")
public class ArtigosController {

	private ArtigoDAO artigoDAO;

	@Autowired
	public ArtigosController(ArtigoDAO artigoDAO) {
		this.artigoDAO = artigoDAO;
	}

	@GetMapping
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView("artigos/index");
		mav.addObject("artigos", artigoDAO.findAll());
		return mav;
	}

	@GetMapping("/listar")
	public ModelAndView indexAdmin() {
		ModelAndView mav = new ModelAndView("artigos/listar");
		mav.addObject("artigos", artigoDAO.findAll());
		return mav;
	}

	@GetMapping("/new")
	public ModelAndView newObj(Artigo artigos) {
		ModelAndView mav = new ModelAndView("artigos/new");
		mav.addObject("artigos", artigos);
		return mav;
	}

	@PostMapping
	public ModelAndView create(@Valid Artigo artigos, BindingResult result, RedirectAttributes attrs) {
		ModelAndView mav = null;

		if (result.hasErrors()) {
			mav = newObj(artigos);
			mav.addObject("msg", "Campos invalidos");
		} else {
			artigoDAO.save(artigos);
			mav = new ModelAndView("redirect:/artigos/listar");
			attrs.addFlashAttribute("msg", "Artigo criado com sucesso");
		}

		return mav;
	}

	@GetMapping("/{id}")
	public ModelAndView show(@PathVariable("id") Long id) {
		ModelAndView mav = new ModelAndView("artigos/show");
		mav.addObject("artigos", findArtigo(id));
		return mav;
	}

	@GetMapping("/{id}/edit")
	public ModelAndView edit(@PathVariable("id") Long id) {
		ModelAndView mav = new ModelAndView("artigos/edit");
		mav.addObject("artigos", findArtigo(id));
		return mav;
	}

	@PostMapping("/{id}")
	public ModelAndView update(@PathVariable("id") Long id, @Valid Artigo artigos, BindingResult result,
			RedirectAttributes attrs) {
		ModelAndView mav = null;

		findArtigo(id);

		if (result.hasErrors()) {
			mav = new ModelAndView("tutoriais/edit");
		} else {
			artigoDAO.save(artigos);
			mav = new ModelAndView("artigos/show");
			attrs.addFlashAttribute("msg", "Artigo atualizado com sucesso");
		}

		mav.addObject("artigos", artigos);
		return mav;
	}

	@GetMapping("/{id}/delete")
	public ModelAndView destroy(@PathVariable("id") Long id, RedirectAttributes attrs) {
		findArtigo(id);
		artigoDAO.delete(id);

		ModelAndView mav = new ModelAndView("redirect:/tutoriais/listar");
		attrs.addFlashAttribute("msg", "Artigo deletado com sucesso");

		return mav;
	}

	private Artigo findArtigo(Long id) {
		if (artigoDAO.exists(id)) {
			return artigoDAO.findOne(id);
		}
		throw new ArtigoNaoExisteException();
	}

	// @InitBinder
	// public void initBinder(WebDataBinder binder) {
	// binder.setValidator(new RoboValidator());
	// }
}