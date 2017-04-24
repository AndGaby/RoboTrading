package br.com.robotrading.web.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.robotrading.web.model.Cliente;


public interface ClientesDAO extends JpaRepository<Cliente, Long> {
	@Override
	List<Cliente> findAll();

	@Override
	<S extends Cliente> S save(S arg0);

	@Override
	void delete(Cliente arg0);

	@Override
	boolean exists(Long arg0);

	@Override
	Cliente findOne(Long arg0);	
	
	Cliente findByEmailAndPassword(String email, String password);
}

