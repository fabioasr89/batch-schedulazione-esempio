package com.fabio.batch.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fabio.batch.model.Utente;

@Repository
public interface UtenteDAO extends JpaRepository<Utente,String>{
	
	@Query(value="FROM Utente ut where ut.attivato=0 and ut.dataDisattivazione is null ")
	List<Utente> getUtentiNonCensiti();
}
