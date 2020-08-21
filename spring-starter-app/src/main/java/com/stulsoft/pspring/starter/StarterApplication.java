package com.stulsoft.pspring.starter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class StarterApplication implements CommandLineRunner {
	private static final Logger logger = LoggerFactory.getLogger(StarterApplication.class);

	public static void main(String[] args) {
		logger.info("==>main");
		SpringApplication.run(StarterApplication.class, args);
	}

	@Override
	public void run(String... args){
		logger.info("==>run");
	}
}
