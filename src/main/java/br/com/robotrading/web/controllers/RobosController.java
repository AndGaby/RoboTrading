package br.com.robotrading.web.controllers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
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

import com.mchange.io.FileUtils;

import br.com.robotrading.web.dao.RobosDAO;
import br.com.robotrading.web.exception.RoboNaoExisteException;
import br.com.robotrading.web.model.Robo;

@Controller
@RequestMapping("/robos")
public class RobosController {

	private RobosDAO robosDAO;
	@Autowired
	private Environment env;

	@Autowired
	public RobosController(RobosDAO robosDAO) {
		this.robosDAO = robosDAO;
	}

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
			newRobo.setLinkImg(handleFileUpload(imagemRobo, newRobo.getId(), null));
			robosDAO.save(newRobo);
			mav = new ModelAndView("redirect:/robos/listar");
			attrs.addFlashAttribute("msg", "Robô criado com sucesso");
		}

		return mav;
	}

	@GetMapping("/{id}")
	public ModelAndView show(@PathVariable("id") Long id) {
		ModelAndView mav = new ModelAndView("robos/show");
		mav.addObject("robo", findRobo(id));
		return mav;
	}

	@GetMapping("/{id}/edit")
	public ModelAndView edit(@PathVariable("id") Long id) {
		ModelAndView mav = new ModelAndView("robos/edit");
		mav.addObject("robo", findRobo(id));
		return mav;
	}

	@PostMapping("/{id}")
	public ModelAndView update(@PathVariable("id") Long id, @Valid Robo robo, BindingResult result,
			RedirectAttributes attrs, @RequestParam("imagem-robo") MultipartFile imagemRobo) {
		ModelAndView mav = null;

		findRobo(id);

		if (result.hasErrors()) {
			mav = new ModelAndView("robos/edit");
		} else {
			if (imagemRobo != null)
				robo.setLinkImg(handleFileUpload(imagemRobo, id, robo.getLinkImg()));

			robosDAO.save(robo);
			mav = new ModelAndView("robos/show");
			attrs.addFlashAttribute("msg", "Robô atualizado com sucesso");
		}

		mav.addObject("robo", robo);
		return mav;
	}

	@GetMapping("/{id}/delete")
	public ModelAndView destroy(@PathVariable("id") Long id, RedirectAttributes attrs) {
		Robo robo = findRobo(id);
		File image = new File(env.getProperty("folder.uploaded.images") + robo.getLinkImg());
		robosDAO.delete(id);
		if (image.exists())
			image.delete();
		ModelAndView mav = new ModelAndView("redirect:/robos/listar");
		attrs.addFlashAttribute("msg", "Robô deletado com sucesso");

		return mav;
	}

	private Robo findRobo(Long id) {
		if (robosDAO.exists(id)) {
			return robosDAO.findOne(id);
		}
		throw new RoboNaoExisteException();
	}

	private String handleFileUpload(MultipartFile imagemRobo, Long idRobo, String oldImageName) {
		String fullPathFileLocation = env.getProperty("folder.uploaded.images");
		String originalFilename;
		File defaultImage = null;
		if (imagemRobo.getSize() == 0) {
			originalFilename = env.getProperty("default.image.name");
			defaultImage = new File(fullPathFileLocation + originalFilename);
		}else{
			originalFilename = imagemRobo.getOriginalFilename();
		}
		String fileExtension = originalFilename.substring(originalFilename.lastIndexOf("."));
		String fileName = "image_upload_robo_id_" + idRobo + fileExtension;
		File file = null;
		try {
			file = new File(fullPathFileLocation + fileName);
			if (!file.exists())
				file.createNewFile();
			FileOutputStream fos = new FileOutputStream(file);
			if(defaultImage != null){
				fos.write(FileUtils.getBytes(defaultImage));
			}else{
				fos.write(imagemRobo.getBytes());
			}
			fos.close();
			// para nao duplicar imagens para um mesmo robo
			if (oldImageName != null && !oldImageName.equals(fileName)) {
				File oldImage = new File(fullPathFileLocation + oldImageName);
				oldImage.delete();
			}
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		if (file.exists())
			return fileName;
		else
			return "Error";
	}
	// @InitBinder
	// public void initBinder(WebDataBinder binder) {
	// binder.setValidator(new RoboValidator());
	// }
}
