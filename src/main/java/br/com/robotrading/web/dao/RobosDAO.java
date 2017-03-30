package br.com.robotrading.web.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.robotrading.web.model.Robo;

public interface RobosDAO extends JpaRepository<Robo, Integer> {
	
}
