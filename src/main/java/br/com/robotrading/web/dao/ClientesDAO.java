package br.com.robotrading.web.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.robotrading.web.model.Cliente;


public interface ClientesDAO extends JpaRepository<Cliente, Long> {
	
}

