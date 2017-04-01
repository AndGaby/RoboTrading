package br.com.robotrading.web.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Tutoriais")
public class Tutorial {

	@GeneratedValue
	@Id
	private Long tutorialID;

	private String nometutorial;

	private String textoTutorial;
	
	public Long getTutorialID() {
		return tutorialID;
	}

	public void setTutorialID(Long tutorialID) {
		this.tutorialID = tutorialID;
	}

	public String getNometutorial() {
		return nometutorial;
	}

	public void setNometutorial(String nometutorial) {
		this.nometutorial = nometutorial;
	}

	public String getTextoTutorial() {
		return textoTutorial;
	}

	public void setTextoTutorial(String textoTutorial) {
		this.textoTutorial = textoTutorial;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tutorialID == null) ? 0 : tutorialID.hashCode());
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
		Tutorial other = (Tutorial) obj;
		if (tutorialID == null) {
			if (other.tutorialID != null)
				return false;
		} else if (!tutorialID.equals(other.tutorialID))
			return false;
		return true;
	}
}