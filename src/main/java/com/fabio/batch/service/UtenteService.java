package com.fabio.batch.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fabio.batch.dao.UtenteDAO;
import com.fabio.batch.model.Utente;
@Service
public class UtenteService {
	
	private static final Logger log=LoggerFactory.getLogger(UtenteService.class);
	
	@Autowired
	private UtenteDAO utenteDAO;
	
	public UtenteService() {
	}
	/**SALVA I DATI NELLA TABELLA UTENTI**/
	public Utente merge(Utente u) {
		Utente utenteInserito=null;
		try {
			if(u!=null) {
				utenteInserito=utenteDAO.save(u);
			}
		}catch(Exception e) {
			log.error(e.getMessage(),e);
		}
		return utenteInserito;
	}
	/**SERVIZIO CHE RECUPERA GLI UTENTI NON ANCORA CENSITI*/
	public List<Utente> utentiNonCensiti(){
		List<Utente> utentiNonCensiti=null;
		try {
			utentiNonCensiti=utenteDAO.getUtentiNonCensiti();
		}catch(Exception e) {
			log.error(e.getMessage(),e);
		}finally {
			if(utentiNonCensiti==null) {
				utentiNonCensiti=new ArrayList<Utente>();
			}
		}
		return utentiNonCensiti;
	}
}
