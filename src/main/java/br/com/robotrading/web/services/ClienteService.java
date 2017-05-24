package br.com.robotrading.web.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.robotrading.web.dao.ClientesDAO;
import br.com.robotrading.web.dao.LoginMetatradeDAO;
import br.com.robotrading.web.exception.ClienteNaoExisteException;
import br.com.robotrading.web.model.Cliente;
import br.com.robotrading.web.model.LoginMetatrade;

@Service
public class ClienteService {
	
	@Autowired
	private ClientesDAO clientesDAO;
	
	@Autowired
	private LoginMetatradeDAO loginMetatradeDAO;
	
	public Cliente updateLoginsMetatrader(Long idCli, String[] loginsMetatrader) {
		Cliente cliente = findCliente(idCli);
		List<LoginMetatrade> oldLogins = cliente.getLoginsMetatrade();
		List<LoginMetatrade> newLogins = new ArrayList<>();
		List<LoginMetatrade> removeLogins = new ArrayList<>();
		
		for (String loginMetatrader : loginsMetatrader) {
			if(!loginMetatrader.isEmpty() && loginMetatrader != null){
				LoginMetatrade login = new LoginMetatrade();
				login.setCliente(cliente);
				login.setLoginMetatrade(loginMetatrader);
				newLogins.add(login);
				oldLogins.stream()
						 .filter(old -> old.equals(login))
						 .forEach(old -> {
							 	newLogins.remove(login);
							 	newLogins.add(old);
								removeLogins.add(old); 
						});		
			}
		}
		
		removeLogins.stream()
					.forEach(r -> oldLogins.remove(r));
		
		cliente.setLoginsMetatrade(newLogins);
		save(cliente);
		loginMetatradeDAO.delete(oldLogins);
		return cliente;
	}
	
	public Cliente findCliente(Long id) {
		if (clientesDAO.exists(id)) {
			return clientesDAO.findOne(id);
		}
		throw new ClienteNaoExisteException();
	}

	public Cliente save(Cliente cliente) {
		 return clientesDAO.save(cliente);
	}

	public void delete(Long idCli) {
		clientesDAO.delete(idCli);
	}
}
