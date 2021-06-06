package com.fabio.batch.step;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import com.fabio.batch.model.Utente;
import com.fabio.batch.service.UtenteService;

public class UtenteWriter implements ItemWriter<Utente>{
	
	@Autowired
	private static final Logger log=LoggerFactory.getLogger(UtenteWriter.class);
	@Autowired
	private UtenteService utenteService;
	
	@Override
	public void write(List<? extends Utente> items) throws Exception {
		List<Utente> allItems=new ArrayList<Utente>();
		Utente utenteDaCensire=null;
		Utente utenteCensito=null;
		try {
			allItems.addAll(items);
			if(!allItems.isEmpty()) {
				utenteDaCensire=allItems.get(0);
				if(utenteDaCensire!=null && utenteDaCensire.getCodice()!=null && !utenteDaCensire.getCodice().equalsIgnoreCase("cens_")) {
					utenteCensito=utenteService.merge(utenteDaCensire);
				}
			}
		}catch(Exception e) {
			log.error(e.getMessage(),e);
		}
		
	}

}
