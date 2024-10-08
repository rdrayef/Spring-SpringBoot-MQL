package org.mql.biblio.controllers;

import java.util.List;

import org.mql.biblio.business.BiblioService;
import org.mql.biblio.models.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BiblioController {

	@Autowired
	private BiblioService service;
	@Autowired
	private String message;

	// End-Point retournant des objets
	@GetMapping("get-all-authors-rest")
	@ResponseBody
	public List<Author> getAllAuthorsRest() {
		return service.authors();
	}

	@GetMapping("get-all-authors")
	public String getAllAuthors(Model model) {
		model.addAttribute("title", message);
		model.addAttribute("authors", service.authors());
		return "print-authors";
	}

}
