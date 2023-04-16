package org.mql.biblio.config;

import org.mql.biblio.models.Author;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({ "org.mql.biblio" })
public class SpringConfig {

	@Bean
	public Author a1() {
		return new Author(101, "Rod Jhonson", 1970);
	}

	@Bean
	public Author a2() {
		return new Author(102, "James Gosling", 1955);
	}

	@Bean
	public Author a3() {
		return new Author(103, "Erich Gamma", 1961);
	}

	@Bean("message")
	public String title() {
		return "Gestion de bibliothèque";
	}
}
