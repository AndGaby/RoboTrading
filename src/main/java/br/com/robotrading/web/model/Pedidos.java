package br.com.robotrading.web.model;

import java.math.BigDecimal;

import javax.persistence.Entity;

public class Pedidos {

	private long idItem;
	
	private String tituloRobo;
	private BigDecimal precoRobo;
	
	public long getIdItem() {
		return idItem;
	}
	public void setIdItem(long idItem) {
		this.idItem = idItem;
	}
	public String getTituloRobo() {
		return tituloRobo;
	}
	public void setTituloRobo(String tituloRobo) {
		this.tituloRobo = tituloRobo;
	}
	public BigDecimal getPrecoRobo() {
		return precoRobo;
	}
	public void setPrecoRobo(BigDecimal precoRobo) {
		this.precoRobo = precoRobo;
	}
}