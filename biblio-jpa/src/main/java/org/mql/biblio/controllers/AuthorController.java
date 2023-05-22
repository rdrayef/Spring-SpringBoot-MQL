package org.mql.biblio.controllers;

import java.util.List;

import org.mql.biblio.business.BiblioService;
import org.mql.biblio.models.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authors")
public class AuthorController {
	@Autowired
	private BiblioService service;

	public AuthorController() {
	}

	@GetMapping
	public List<Author> getAllAuthors() {
		return service.authors();
	}

	@GetMapping("/{keyword}")
	public List<Author> getAuthorsByKeyword(@PathVariable String keyword) {
		return service.authors(keyword);
	}

}
