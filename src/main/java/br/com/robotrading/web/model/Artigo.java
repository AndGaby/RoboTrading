package br.com.robotrading.web.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Artigos")
public class Artigo {

	@GeneratedValue
	@Id
	private Long artigoID;

	private String nomeArtigo;

	private String linkArtigo;

	private String textoArtigo;
	
	public Long getArtigoID() {
		return artigoID;
	}

	public void setArtigoID(Long artigoID) {
		this.artigoID = artigoID;
	}

	public String getNomeArtigo() {
		return nomeArtigo;
	}

	public void setNomeArtigo(String nomeArtigo) {
		this.nomeArtigo = nomeArtigo;
	}

	public String getLinkArtigo() {
		return linkArtigo;
	}

	public void setLinkArtigo(String linkArtigo) {
		this.linkArtigo = linkArtigo;
	}

	public String getTextoArtigo() {
		return textoArtigo;
	}

	public void setTextoArtigo(String textoArtigo) {
		this.textoArtigo = textoArtigo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((artigoID == null) ? 0 : artigoID.hashCode());
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
		Artigo other = (Artigo) obj;
		if (artigoID == null) {
			if (other.artigoID != null)
				return false;
		} else if (!artigoID.equals(other.artigoID))
			return false;
		return true;
	}
}