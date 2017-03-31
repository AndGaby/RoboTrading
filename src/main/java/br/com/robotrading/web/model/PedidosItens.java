package br.com.robotrading.web.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class PedidosItens implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Robo robo;

	public PedidosItens(Robo robo) {
		this.robo = robo;		
	}

	public Robo getRobo() {
		return robo;
	}

	public void setRobo(Robo robo) {
		this.robo = robo;
	}
	
	public BigDecimal getPreco(){
		return robo.getPreco();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((robo == null) ? 0 : robo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PedidosItens other = (PedidosItens) obj;
		if (robo == null) {
			if (other.robo != null)
				return false;
		} else if (!robo.equals(other.robo))
			return false;
		return true;
	}

	public BigDecimal getTotal(int quantidade) {
		return this.getPreco().multiply(new BigDecimal(quantidade));
	}
}