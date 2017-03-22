package br.com.robotrading.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.robotrading.dao.RobosDAO;
import br.com.robotrading.model.Robo;

@Controller
@RequestMapping("/robos")
public class RobosController {

	private RobosDAO robosDAO;

	@Autowired
	public RobosController(RobosDAO robosDAO) {
		this.robosDAO = robosDAO;
	}

	// mostrar todos robos
	@RequestMapping(value = "", method = RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView("robos/index");
		List<Robo> robos = robosDAO.findAll();
		mav.addObject("robos", robos);
		return mav;
	}

	// mostrar um formulario para cadastrar robos
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public ModelAndView newObj() {
		ModelAndView mav = new ModelAndView("robos/new");
		mav.addObject("robo", new Robo());
		return mav;
	}

	// recebe um robo do formulario 'new' e cadastra no banco e redireciona para
	// o index
	@RequestMapping(value = "", method = RequestMethod.POST)
	public ModelAndView create(Robo robo) {
		ModelAndView mav = new ModelAndView("robos/index");
		robosDAO.save(robo);
		return mav;
	}

	// recebe um id do robo, busca no banco e mostra na pagina show
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ModelAndView show(@Param("id") Long id) {
		ModelAndView mav = new ModelAndView("robos/show");
		Robo robo = robosDAO.findOne(id);
		mav.addObject("robo", robo);
		return mav;
	}

	// recebe um id do robo, busca no banco e mostra na pagina edit que será um
	// formulario para editar
	@RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
	public ModelAndView edit(@Param("id") Long id) {
		ModelAndView mav = new ModelAndView("robos/edit");
		Robo robo = robosDAO.findOne(id);
		mav.addObject("robo", robo);
		return mav;
	}

	// recebe um robo do formulario 'edit' e atualiza no banco e redireciona
	// para o show
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ModelAndView update(@Param("id") Long id, Robo robo) {
		ModelAndView mav = new ModelAndView("robos/show");
		if (robosDAO.exists(id)) {
			robosDAO.save(robo);
			mav.addObject("robo", robo);
		}
		return mav;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ModelAndView destroy(@Param("id") Long id) {
		ModelAndView mav = new ModelAndView("robos/index");
		robosDAO.delete(id);
		return mav;
	}

}
