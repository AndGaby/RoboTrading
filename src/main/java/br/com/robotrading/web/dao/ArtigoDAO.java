package br.com.robotrading.web.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.robotrading.web.model.Artigo;

public interface ArtigoDAO extends JpaRepository<Artigo, Long> {

	@Override
	List<Artigo> findAll();

	@Override
	<S extends Artigo> S save(S arg0);

	@Override
	void delete(Artigo arg0);

	@Override
	boolean exists(Long arg0);

	@Override
	Artigo findOne(Long arg0);
}
