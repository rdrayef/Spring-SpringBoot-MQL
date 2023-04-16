package org.mql.biblio;

import java.util.List;

import org.mql.biblio.business.BiblioService;
import org.mql.biblio.config.SpringConfig;
import org.mql.biblio.models.Author;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class EntryPoint {
	private ApplicationContext context;

	public EntryPoint() {
		init();
		exp01();
	}

	void init() {
		// Chargement du contexte
		context = new AnnotationConfigApplicationContext(SpringConfig.class);
	}

	void exp01() {
		System.out.println(context.getBean("message"));
		BiblioService service = context.getBean(BiblioService.class);
		List<Author> authors = service.authors();

		for (Author author : authors) {
			System.out.println("- " + author);
		}
	}

	public static void main(String[] args) {
		new EntryPoint();
	}

}
