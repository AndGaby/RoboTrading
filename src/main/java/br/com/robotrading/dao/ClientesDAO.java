package br.com.robotrading.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.robotrading.model.Cliente;

@Repository
public interface ClientesDAO extends JpaRepository<Cliente, Long>{
	
	public Cliente findByEmailCli(String EmailCli);

	public Cliente findByUserNameCli(String UserNameCli);
}
