package br.com.robotrading.web.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.robotrading.web.model.Carrinho;
import br.com.robotrading.web.model.Robo;

public interface CarrinhoDAO extends JpaRepository<Carrinho, Long> {
	@Override
	List<Carrinho> findAll();

	@Override
	<S extends Carrinho> S save(S arg0);

	@Override
	void delete(Carrinho arg0);

	@Override
	boolean exists(Long arg0);

	@Override
	Carrinho findOne(Long arg0);

	@Query("select s from Carrinho s where KEY(s.robos) = ?1")
	List<Carrinho> findByRobo(Robo robo);
	
	List<Carrinho> findByClienteId(Long id);
	
}

