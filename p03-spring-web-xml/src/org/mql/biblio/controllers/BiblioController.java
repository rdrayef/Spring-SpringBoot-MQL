package org.mql.biblio.controllers;

import java.util.List;

import org.mql.biblio.models.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BiblioController {
	/* On ajoute le business */

	@Autowired
	private List<Author> authors;

	public BiblioController() {
	}

	@RequestMapping("get-all-authors")
	public String getAllAuthors(Model model) {
		model.addAttribute("authors", authors);
		return "/views/print-authors.jsp";
	}

}
