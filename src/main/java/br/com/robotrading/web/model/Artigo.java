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
	private Long id;

	private String titulo;
	
	private String linkArtigo;

	@Lob
	private String textoArtigo;


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

	public String getTextoArtigo() {
		return textoArtigo;
	}

	public void setTextoArtigo(String textoArtigo) {
		this.textoArtigo = textoArtigo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


}