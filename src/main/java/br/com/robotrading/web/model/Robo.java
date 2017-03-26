package br.com.robotrading.web.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Robos")
public class Robo {

	@GeneratedValue
	@Id
	private Long id;

	private String nome;

	private String linkImg;

	private BigDecimal preco;

	private Integer contratados;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLinkImg() {
		return linkImg;
	}

	public void setLinkImg(String linkImg) {
		this.linkImg = linkImg;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public Integer getContratados() {
		return contratados;
	}

	public void setContratados(Integer contratados) {
		this.contratados = contratados;
	}

}
