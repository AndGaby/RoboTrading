package br.com.robotrading.web.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.robotrading.web.model.Robo;

public interface RobosDAO extends JpaRepository<Robo, Long> {
	@Override
	List<Robo> findAll();

	@Override
	<S extends Robo> S save(S arg0);

	@Override
	void delete(Robo arg0);

	@Override
	boolean exists(Long arg0);

	@Override
	Robo findOne(Long arg0);	
}
