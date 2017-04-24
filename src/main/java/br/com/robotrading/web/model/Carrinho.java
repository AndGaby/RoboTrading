package br.com.robotrading.web.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "Carrinhos")
public class Carrinho implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne(fetch = FetchType.EAGER)
	private Cliente cliente;

	@DateTimeFormat(iso = ISO.TIME)
	private LocalDateTime dataCompra;

	private Boolean pago;

	@ElementCollection(fetch = FetchType.EAGER)
	private Map<Robo, Integer> robos;

	public Carrinho() {
		if (robos == null) {
			robos = new LinkedHashMap<Robo, Integer>();
		}
	}

	public Map<Robo, Integer> getRobos() {
		return robos;
	}

	public void add(Robo item) {
		add(item, 1);
	}

	public void remove(Robo item) {
		remove(item, 1);
	}

	public void add(Robo item, Integer quantity) {
		robos.put(item, getQuantidade(item) + quantity);
	}

	public void remove(Robo item, Integer quantity) {
		Integer quant = robos.get(item);
		quant -= quantity;
		if (quant > 0) {
			robos.put(item, quant);
		}
	}

	public Integer getQuantidade(Robo item) {
		if (!robos.containsKey(item)) {
			robos.put(item, 0);
		}
		return robos.get(item);
	}

	public int getQuantidade() {
		return robos.values().stream().reduce(0, (proximo, acumulador) -> proximo + acumulador);
	}

	public BigDecimal getTotal(Robo item) {
		return item.getPreco().multiply(BigDecimal.valueOf(robos.get(item)));
	}

	public BigDecimal getTotal() {
		BigDecimal total = BigDecimal.ZERO;
		for (Robo item : robos.keySet()) {
			total = total.add(getTotal(item));
		}
		return total;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Boolean getPago() {
		return pago;
	}

	public void setPago(Boolean pago) {
		this.pago = pago;
	}

	public LocalDateTime getDataCompra() {
		return dataCompra;
	}

	public void setDataCompra(LocalDateTime dataCompra) {
		this.dataCompra = dataCompra;
	}
}