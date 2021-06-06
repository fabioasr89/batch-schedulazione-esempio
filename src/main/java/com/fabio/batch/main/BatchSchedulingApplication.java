package com.fabio.batch.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
@SpringBootApplication
@EnableBatchProcessing
@EnableScheduling
@ComponentScan(basePackages = {"com.fabio.batch.service","com.fabio.batch.configuration"})
@EnableJpaRepositories(basePackages="com.fabio.batch.dao")
@EntityScan(basePackages= {"com.fabio.batch.model"})
public class BatchSchedulingApplication {
	
	private static final Logger log=LoggerFactory.getLogger(BatchSchedulingApplication.class);
	
	@Autowired
	private JobLauncher jobLauncher;
	
	@Autowired
	private Job job;
	
	public static void main(String[] args) {
		SpringApplication.run(BatchSchedulingApplication.class, args);
	}
	
	@Scheduled(cron = "${schedulazione.frequenza}")
	public void task() {
		//settiamo come parametro identificativo del job i millisecondi attuali
		JobParameters params = new JobParametersBuilder()
                .addString("censimento-utenze", String.valueOf(System.currentTimeMillis()))
                .toJobParameters();
        try {
			jobLauncher.run(job, params);
		} catch (JobExecutionAlreadyRunningException e) {
			log.error(e.getMessage(),e);
		} catch (JobRestartException e) {
			log.error(e.getMessage(),e);
		} catch (JobInstanceAlreadyCompleteException e) {
			log.error(e.getMessage(),e);
		} catch (JobParametersInvalidException e) {
			log.error(e.getMessage(),e);
		}
	}
}
