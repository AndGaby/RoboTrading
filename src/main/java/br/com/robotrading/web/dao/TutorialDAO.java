package br.com.robotrading.web.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.robotrading.web.model.Tutorial;

public interface TutorialDAO extends JpaRepository<Tutorial, Long> {

}
