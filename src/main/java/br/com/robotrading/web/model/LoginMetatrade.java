package br.com.robotrading.web.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "LoginsMetatrade")
public class LoginMetatrade implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne
	private Cliente cliente;
	
	private String loginMetatrade;

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

	public String getLoginMetatrade() {
		return loginMetatrade;
	}

	public void setLoginMetatrade(String loginMetatrade) {
		this.loginMetatrade = loginMetatrade;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		LoginMetatrade login = (LoginMetatrade)obj;
		
		if(this.getCliente().equals(login.getCliente())
			 && this.getLoginMetatrade().equals(login.getLoginMetatrade())){
			return true;
		}
		return false;
	}
		
}