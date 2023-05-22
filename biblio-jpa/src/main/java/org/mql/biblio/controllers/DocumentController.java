package org.mql.biblio.controllers;

import java.util.List;

import org.mql.biblio.business.BiblioService;
import org.mql.biblio.models.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/docs")
@CrossOrigin("*")
public class DocumentController {
	@Autowired
	public BiblioService service;

	public DocumentController() {
	}

	@GetMapping("/{keyword}")
	public List<Document> getDocumentsByKeyword(@PathVariable String keyword) {
		return service.documents(keyword);
	}
	
}
