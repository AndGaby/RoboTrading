package br.com.robotrading.web.model;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class RegistroRobo {

	private Robo robo;
	private Cliente cliente;
	private LocalDateTime dataCompra;
	private Integer quantidade;
	private Date dataFormatada;

	public Robo getRobo() {
		return robo;
	}

	public void setRobo(Robo robo) {
		this.robo = robo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public LocalDateTime getDataCompra() {
		return dataCompra;
	}

	public void setDataCompra(LocalDateTime dataCompra) {
		this.dataCompra = dataCompra;
	}

	public Date getDataFormatada() {
		Instant instant = getDataCompra().atZone(ZoneId.systemDefault()).toInstant();
		dataFormatada = Date.from(instant);
		return dataFormatada;
	}	
}
