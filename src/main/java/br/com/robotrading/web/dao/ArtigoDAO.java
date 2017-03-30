package br.com.robotrading.web.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.robotrading.web.model.Artigo;

public interface ArtigoDAO extends JpaRepository<Artigo, Long> {

}
