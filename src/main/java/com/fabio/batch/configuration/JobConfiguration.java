package com.fabio.batch.configuration;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fabio.batch.model.Utente;
import com.fabio.batch.step.UtenteProcess;
import com.fabio.batch.step.UtenteReader;
import com.fabio.batch.step.UtenteWriter;

@Configuration
public class JobConfiguration {
	@Autowired
	private JobBuilderFactory jobBuilderFactory;
	
	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	
	
	public JobConfiguration() {
		
	}
	
	@Bean
	public Job censisciUtente() {
		return jobBuilderFactory.get("censimento-utenze").incrementer(new RunIdIncrementer())
				.start(processoCensimentoUtenza()).build();
			
		
	}
	
	
	@Bean
	public Step processoCensimentoUtenza() {
		return stepBuilderFactory.get("processo-censimento-utenza").<Utente,Utente>chunk(1)
				.reader(getUtenteReader()).processor(getUtenteProcess()).writer(getUtenteWriter())
				.build();
	}
	
	
	@Bean
	public ItemReader<Utente> getUtenteReader(){
		return new UtenteReader();
	}
	
	@Bean
	public ItemProcessor<Utente,Utente> getUtenteProcess(){
		return new UtenteProcess();
	}
	
	@Bean
	public ItemWriter<Utente> getUtenteWriter(){
		return new UtenteWriter();
	}
	
}
