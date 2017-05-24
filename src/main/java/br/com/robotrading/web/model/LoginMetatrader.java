package br.com.robotrading.web.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "login_metatrader")
public class LoginMetatrader implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;
	@ManyToOne
	private Cliente cliente;
	
	private String loginMetatrader;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getLoginMetatrader() {
		return loginMetatrader;
	}

	public void setLoginMetatrader(String loginMetatrader) {
		this.loginMetatrader = loginMetatrader;
	}	
}