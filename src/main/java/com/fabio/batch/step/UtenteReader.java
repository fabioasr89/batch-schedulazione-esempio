package com.fabio.batch.step;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Autowired;

import com.fabio.batch.model.Utente;
import com.fabio.batch.service.UtenteService;

public class UtenteReader implements ItemReader<Utente>{
	
	private static Logger log=LoggerFactory.getLogger(UtenteReader.class);
	
	@Autowired
	private UtenteService utenteService;
	private static  Integer index=0;
	private List<Utente> utentiNonCensiti=null; 
	@BeforeStep
	public void init() {
		index=0;
		try {
			utentiNonCensiti=utenteService.utentiNonCensiti();
		}catch(Exception e) {
			log.error(e.getMessage(),e);
		}
		
	}
	@Override
	public Utente read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		Utente utente=null;
		try {
			if(utentiNonCensiti!=null && !utentiNonCensiti.isEmpty()) {
				if(index<utentiNonCensiti.size()) {
					utente=utentiNonCensiti.get(index);
				}
			}
			index++;
		}catch(Exception e) {
			log.error(e.getMessage(),e);
		}
		return utente;
	}
	

}
