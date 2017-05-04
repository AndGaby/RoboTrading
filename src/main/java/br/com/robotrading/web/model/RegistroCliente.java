package br.com.robotrading.web.model;

import java.time.LocalDateTime;
import java.util.Map;

public class RegistroCliente {

	private Map<Robo,Integer> robos;
	private Cliente cliente;
	private LocalDateTime dataCompra;

	public Map<Robo,Integer> getRobos() {
		return robos;
	}

	public void setRobos(Map<Robo,Integer> robos) {
		this.robos = robos;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public LocalDateTime getDataCompra() {
		return dataCompra;
	}

	public void setDataCompra(LocalDateTime dataCompra) {
		this.dataCompra = dataCompra;
	}

}
