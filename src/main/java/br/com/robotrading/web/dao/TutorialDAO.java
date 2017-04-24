package br.com.robotrading.web.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.robotrading.web.model.Tutorial;

public interface TutorialDAO extends JpaRepository<Tutorial, Long> {
	@Override
	List<Tutorial> findAll();

	@Override
	<S extends Tutorial> S save(S arg0);

	@Override
	void delete(Tutorial arg0);

	@Override
	boolean exists(Long arg0);

	@Override
	Tutorial findOne(Long arg0);
}
