package org.mql.biblio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class P06SpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(P06SpringBootApplication.class, args);
	}
	
	@Bean
	public String title() {
		return "Application Spring boot basé surThymeleaf";
	}
	
	
}
