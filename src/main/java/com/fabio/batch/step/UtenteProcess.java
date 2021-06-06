package com.fabio.batch.step;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import com.fabio.batch.model.Utente;
import com.fabio.batch.util.UtilMethod;

public class UtenteProcess implements ItemProcessor<Utente,Utente>{
	private static final Logger log=LoggerFactory.getLogger(UtenteProcess.class);

	@Override
	public Utente process(Utente item) throws Exception {
		String codice=null;
		Date dataAttivazione=new Date();
		try {
			if(item!=null) {
				codice=UtilMethod.generaCodiceUtente(item.getCodiceFiscale());
				item.setCodice(codice);
				item.setAttivato(1);
				item.setDataAttivazione(dataAttivazione);
			}
		}catch(Exception e) {
			log.error(e.getMessage(),e);
		}
		return item;
	}

}
