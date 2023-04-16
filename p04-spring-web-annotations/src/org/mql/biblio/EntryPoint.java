package org.mql.biblio;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.mql.biblio.config.SpringConfig;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class EntryPoint implements WebApplicationInitializer {

	public EntryPoint() {
		System.out.println(">> new EntryPoint()");
	}

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		System.out.println(">> onStartup()");
		// 1. Chargement du contexte de Spring!
		AnnotationConfigWebApplicationContext contexte = new AnnotationConfigWebApplicationContext();
		contexte.register(SpringConfig.class);

		// 2. Creation et configuration du Contrôlleur Spring:!
		Dynamic controller = servletContext.addServlet("controller", new DispatcherServlet(contexte));
		controller.addMapping("/biblio/*");
		controller.setLoadOnStartup(1);
	}

}
