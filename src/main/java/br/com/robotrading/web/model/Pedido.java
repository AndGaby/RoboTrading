package br.com.robotrading.web.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION)
public class Pedido implements Serializable {

	private static final long serialVersionUID = 1L;

	private Map<PedidosItens, Integer> itens = new LinkedHashMap<PedidosItens, Integer>();

	public Map<PedidosItens, Integer> getItens() {
		return itens;
	}

	public void add(PedidosItens item) {
		itens.put(item, getQuantidade(item) + 1);
	}

	public void add(PedidosItens item, Integer quantity) {
		itens.put(item, getQuantidade(item) + quantity);
	}

	public Integer getQuantidade(PedidosItens item) {
		if (!itens.containsKey(item)) {
			itens.put(item, 0);
		}
		return itens.get(item);
	}

	public int getQuantidade() {
		return itens.values().stream().reduce(0, (proximo, acumulador) -> proximo + acumulador);
	}

	public BigDecimal getTotal(PedidosItens item) {
		return item.getTotal(getQuantidade(item));
	}

	public BigDecimal getTotal() {
		BigDecimal total = BigDecimal.ZERO;
		for (PedidosItens item : itens.keySet()) {
			total = total.add(getTotal(item));
		}
		return total;
	}
}