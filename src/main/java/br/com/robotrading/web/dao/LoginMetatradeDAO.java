package br.com.robotrading.web.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.robotrading.web.model.LoginMetatrade;

public interface LoginMetatradeDAO extends JpaRepository<LoginMetatrade, Long> {

}
