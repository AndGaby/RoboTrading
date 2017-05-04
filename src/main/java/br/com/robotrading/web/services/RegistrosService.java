package br.com.robotrading.web.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.robotrading.web.dao.CarrinhoDAO;
import br.com.robotrading.web.dao.ClientesDAO;
import br.com.robotrading.web.dao.RobosDAO;
import br.com.robotrading.web.model.Carrinho;
import br.com.robotrading.web.model.Cliente;
import br.com.robotrading.web.model.RegistroCliente;
import br.com.robotrading.web.model.RegistroRobo;
import br.com.robotrading.web.model.Robo;

@Component
public class RegistrosService {

	@Autowired
	private CarrinhoDAO carrinhoDAO;
	@Autowired
	private RobosDAO robosDAO;
	@Autowired
	private ClientesDAO clientesDAO;

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
		Cliente cliente = clientesDAO.findOne(id);
		List<Carrinho> carrinhos = carrinhoDAO.findByCliente(cliente);
		List<RegistroCliente> registrosClientes = new ArrayList<>();

		for (Carrinho carrinho : carrinhos) {
		//	if (carrinho.getPago()) {
				RegistroCliente registroCliente = new RegistroCliente();
				registroCliente.setRobos(carrinho.getRobos());
				registroCliente.setCliente(carrinho.getCliente());
				registroCliente.setDataCompra(carrinho.getDataCompra());
				registrosClientes.add(registroCliente);
	//		}
		}

		return registrosClientes;
	}

}
