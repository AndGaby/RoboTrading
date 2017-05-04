package br.com.robotrading.web.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.robotrading.web.dao.CarrinhoDAO;
import br.com.robotrading.web.dao.RobosDAO;
import br.com.robotrading.web.model.Carrinho;
import br.com.robotrading.web.model.RegistroCliente;
import br.com.robotrading.web.model.RegistroRobo;
import br.com.robotrading.web.model.Robo;

@Component
public class RegistrosService {

	@Autowired
	private CarrinhoDAO carrinhoDAO;
	@Autowired
	private RobosDAO robosDAO;

	public List<RegistroRobo> getRegistroRobo(Long id) {
		Robo robo = robosDAO.findOne(id);
		List<Carrinho> carrinhos = carrinhoDAO.findByRobo(robo);
		List<RegistroRobo> registrosRobos = new ArrayList<>();

		for (Carrinho carrinho : carrinhos) {
			RegistroRobo registroRobo = new RegistroRobo();
			registroRobo.setRobo(robo);
			registroRobo.setCliente(carrinho.getCliente());
			registroRobo.setDataCompra(carrinho.getDataCompra());
			registroRobo.setQuantidade(carrinho.getQuantidade(robo));

			registrosRobos.add(registroRobo);
		}

		return registrosRobos;
	}

	public List<RegistroCliente> getRegistroCliente(Long id) {
		List<Carrinho> carrinhos = carrinhoDAO.findByClienteId(id);
		return null;
	}

}
