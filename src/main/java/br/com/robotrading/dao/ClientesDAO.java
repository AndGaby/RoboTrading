package br.com.robotrading.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.robotrading.model.Cliente;

public interface ClientesDAO extends JpaRepository<Cliente, Long>{
	
	public Cliente findByEmailCli(String EmailCli);

	public Cliente findByUserNameCli(String UserNameCli);
}
