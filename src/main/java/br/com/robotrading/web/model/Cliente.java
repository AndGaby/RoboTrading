package br.com.robotrading.web.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "Clientes")
public class Cliente {

	@Id
	@GeneratedValue
	private Long IdCli;

	@Length(min = 3, max = 45)
	private String nomeCli;

	// @NotBlank
	// @DateTimeFormat(iso = ISO.DATE)
	private LocalDate DataNascCli;

	@NotBlank
	@Length(min = 3, max = 10)
	private String userNameCli;

	// @NotBlank
	// @Length(min = 4, max = 30)
	private String emailCli;

	// @NotBlank
	private String passwordCli;

	public Long getIdCli() {
		return IdCli;
	}

	public void setIdCli(Long idCli) {
		IdCli = idCli;
	}

	public String getNomeCli() {
		return nomeCli;
	}

	public void setNomeCli(String nomeCli) {
		this.nomeCli = nomeCli;
	}

	public LocalDate getDataNascCli() {
		return DataNascCli;
	}

	public void setDataNascCli(LocalDate dataNascCli) {
		DataNascCli = dataNascCli;
	}

	public String getUserNameCli() {
		return userNameCli;
	}

	public void setUserNameCli(String userNameCli) {
		this.userNameCli = userNameCli;
	}

	public String getEmailCli() {
		return emailCli;
	}

	public void setEmailCli(String emailCli) {
		this.emailCli = emailCli;
	}

	public String getpasswordCli() {
		return passwordCli;
	}

	public void setpasswordCli(String passwordCli) {
		this.passwordCli = passwordCli;
	}
}