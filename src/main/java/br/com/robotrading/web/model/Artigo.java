package br.com.robotrading.web.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "Artigos")
public class Artigo {

	@GeneratedValue
	@Id
	private Long artigoID;

	private String titulo;
	
	private String linkArtigo;

	@Lob
	private Byte[] textoArtigo;

	public Long getArtigoID() {
		return artigoID;
	}

	public void setArtigoID(Long artigoID) {
		this.artigoID = artigoID;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getLinkArtigo() {
		return linkArtigo;
	}

	public void setLinkArtigo(String linkArtigo) {
		this.linkArtigo = linkArtigo;
	}

	public Byte[] getTextoArtigo() {
		return textoArtigo;
	}

	public void setTextoArtigo(Byte[] textoArtigo) {
		this.textoArtigo = textoArtigo;
	}

}