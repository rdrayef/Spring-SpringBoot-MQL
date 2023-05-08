package org.mql.biblio.controllers;

import java.util.List;

import org.mql.biblio.business.BiblioService;
import org.mql.biblio.models.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthorController {

	@Autowired
	private BiblioService service;

	public AuthorController() {
	}

	@GetMapping("/get-all-authors")
	public String getAllAuthors(Model model) {
		List<Author> authors = service.authors();
		model.addAttribute("authors", authors);
		return "print-authors";
	}

}
