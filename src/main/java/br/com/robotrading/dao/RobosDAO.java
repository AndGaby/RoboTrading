package br.com.robotrading.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.robotrading.model.Robo;

public interface RobosDAO extends JpaRepository<Robo, Long> {

}
