package com.fabio.batch.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="utenti")
public class Utente {
	@Id
	@Column(name="codice_fiscale")
	private String codiceFiscale;
	@Column(name="codice")
	private String codice;
	
	@Column(name="username")
	private String username;
	
	@Column(name="psw")
	private String password;
	
	@Column(name="attivato")
	private Integer attivato;
	
	@Column(name="nome")
	private String nome;
	@Column(name="cognome")
	private String cognome;
	
	@Column(name="data_inserimento")
	private Date dataInserimento;
	@Column(name="data_attivazione")
	private Date dataAttivazione;
	@Column(name="data_disattivazione")
	private Date dataDisattivazione;
	
	
	public Utente() {
	}


	public String getCodiceFiscale() {
		return codiceFiscale;
	}


	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}


	public String getCodice() {
		return codice;
	}


	public void setCodice(String codice) {
		this.codice = codice;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	


	public Integer getAttivato() {
		return attivato;
	}


	public void setAttivato(Integer attivato) {
		this.attivato = attivato;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCognome() {
		return cognome;
	}


	public void setCognome(String cognome) {
		this.cognome = cognome;
	}


	public Date getDataInserimento() {
		return dataInserimento;
	}


	public void setDataInserimento(Date dataInserimento) {
		this.dataInserimento = dataInserimento;
	}


	public Date getDataAttivazione() {
		return dataAttivazione;
	}


	public void setDataAttivazione(Date dataAttivazione) {
		this.dataAttivazione = dataAttivazione;
	}


	public Date getDataDisattivazione() {
		return dataDisattivazione;
	}


	public void setDataDisattivazione(Date dataDisattivazione) {
		this.dataDisattivazione = dataDisattivazione;
	}
	
	
}
