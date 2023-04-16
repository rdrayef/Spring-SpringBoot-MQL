package org.mql.biblio.controllers;

import org.mql.biblio.models.JavaInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BiblioController {
	@Autowired
	private ApplicationContext context;

	@GetMapping("get-application-info")
	public String getaApplicationInfo(Model model) {
		System.out.println(context.getClass().getSimpleName());
		model.addAttribute("title", context.getBean("title"));
		model.addAttribute("java",context.getBean(JavaInfo.class));
		return "application-info";
	}
}
