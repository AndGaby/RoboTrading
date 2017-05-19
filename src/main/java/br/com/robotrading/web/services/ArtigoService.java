package br.com.robotrading.web.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.robotrading.web.dao.ArtigoDAO;
import br.com.robotrading.web.model.Artigo;

public class ArtigoService {

	@Autowired
	private ArtigoDAO artigosDAO;
	
	public List<Artigo> getAll() {
		return artigosDAO.findAll();
	}

}
