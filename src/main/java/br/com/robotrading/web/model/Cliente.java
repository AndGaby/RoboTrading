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
	
//	@NotBlank
//	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate DataNascCli;

	@NotBlank
	@Length(min = 3, max = 10)
	private String userNameCli;

//	@NotBlank
//	@Length(min = 4, max = 30)
	private String emailCli;

//	@NotBlank
	private String passwordCli;

//	@Length(min = 11, max = 11)
	private Long CpfCli;

//	@Length(min = 1, max = 40)
	private String LogadouroCli;	

//	@Length(min = 1, max = 10)
	private Long LogadouroNumeroCli;

//	@Length(min = 1, max = 10)
	private Long CepCli;

//	@Length(min = 1, max = 20)
	private String CidadeCli;

//	@Length(min = 2, max = 3)
	private String EstadoCli;
	
//	@Length(min = 2, max = 20)
	private String PaisCli;

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

	public Long getCpfCli() {
		return CpfCli;
	}

	public void setCpfCli(Long cpfCli) {
		CpfCli = cpfCli;
	}

	public String getLogadouroCli() {
		return LogadouroCli;
	}

	public void setLogadouroCli(String logadouroCli) {
		LogadouroCli = logadouroCli;
	}

	public Long getLogadouroNumeroCli() {
		return LogadouroNumeroCli;
	}

	public void setLogadouroNumeroCli(Long logadouroNumeroCli) {
		LogadouroNumeroCli = logadouroNumeroCli;
	}

	public Long getCepCli() {
		return CepCli;
	}

	public void setCepCli(Long cepCli) {
		CepCli = cepCli;
	}

	public String getCidadeCli() {
		return CidadeCli;
	}

	public void setCidadeCli(String cidadeCli) {
		CidadeCli = cidadeCli;
	}

	public String getEstadoCli() {
		return EstadoCli;
	}

	public void setEstadoCli(String estadoCli) {
		EstadoCli = estadoCli;
	}

	public String getPaisCli() {
		return PaisCli;
	}

	public void setPaisCli(String paisCli) {
		PaisCli = paisCli;
	}
}