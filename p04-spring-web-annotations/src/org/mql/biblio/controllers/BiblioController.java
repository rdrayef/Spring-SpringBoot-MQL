package org.mql.biblio.controllers;

import org.mql.biblio.business.BiblioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BiblioController {
	@Autowired
	private BiblioService service;
	@Autowired
	private String message;

	public BiblioController() {
	}

	@GetMapping("get-all-authors")
	public String getAllAuthors(Model model) {
		model.addAttribute("title", message);
		model.addAttribute("authors", service.authors());
		return "/views/print-authors.jsp";
	}

}
