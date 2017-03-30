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
import br.com.robotrading.web.dao.TutorialDAO;
import br.com.robotrading.web.exception.TutorialNaoExisteException;
import br.com.robotrading.web.model.Tutorial;

@Controller
@RequestMapping("/tutoriais")
public class TutorialController {

	private TutorialDAO tutorialDAO;

	@Autowired
	public TutorialController(TutorialDAO tutorialDAO) {
		this.tutorialDAO = tutorialDAO;
	}

	@GetMapping
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView("tutoriais/index");
		mav.addObject("tutoriais", tutorialDAO.findAll());
		return mav;
	}

	@GetMapping("/listar")
	public ModelAndView indexAdmin() {
		ModelAndView mav = new ModelAndView("tutoriais/listar");
		mav.addObject("tutoriais", tutorialDAO.findAll());
		return mav;
	}

	@GetMapping("/new")
	public ModelAndView newObj(Tutorial tutoriais) {
		ModelAndView mav = new ModelAndView("tutoriais/new");
		mav.addObject("tutoriais", tutoriais);
		return mav;
	}

	@PostMapping
	public ModelAndView create(@Valid Tutorial tutoriais, BindingResult result, RedirectAttributes attrs) {
		ModelAndView mav = null;

		if (result.hasErrors()) {
			mav = newObj(tutoriais);
			mav.addObject("msg", "Campos invalidos");
		} else {
			tutorialDAO.save(tutoriais);
			mav = new ModelAndView("redirect:/tutoriais/listar");
			attrs.addFlashAttribute("msg", "Tutorial criado com sucesso");
		}

		return mav;
	}

	@GetMapping("/{id}")
	public ModelAndView show(@PathVariable("id") Long id) {
		ModelAndView mav = new ModelAndView("tutoriais/show");
		mav.addObject("tutoriais", findTutorial(id));
		return mav;
	}

	@GetMapping("/{id}/edit")
	public ModelAndView edit(@PathVariable("id") Long id) {
		ModelAndView mav = new ModelAndView("tutoriais/edit");
		mav.addObject("tutoriais", findTutorial(id));
		return mav;
	}

	@PostMapping("/{id}")
	public ModelAndView update(@PathVariable("id") Long id, @Valid Tutorial tutorial, BindingResult result,
			RedirectAttributes attrs) {
		ModelAndView mav = null;

		findTutorial(id);

		if (result.hasErrors()) {
			mav = new ModelAndView("tutoriais/edit");
		} else {
			tutorialDAO.save(tutorial);
			mav = new ModelAndView("tutoriais/show");
			attrs.addFlashAttribute("msg", "Tutorial atualizado com sucesso");
		}

		mav.addObject("tutoriais", tutorial);
		return mav;
	}

	@GetMapping("/{id}/delete")
	public ModelAndView destroy(@PathVariable("id") Long id, RedirectAttributes attrs) {
		findTutorial(id);
		tutorialDAO.delete(id);

		ModelAndView mav = new ModelAndView("redirect:/tutoriais/listar");
		attrs.addFlashAttribute("msg", "Tutorial deletado com sucesso");

		return mav;
	}

	private Tutorial findTutorial(Long id) {
		if (tutorialDAO.exists(id)) {
			return tutorialDAO.findOne(id);
		}
		throw new TutorialNaoExisteException();
	}

	// @InitBinder
	// public void initBinder(WebDataBinder binder) {
	// binder.setValidator(new RoboValidator());
	// }
}