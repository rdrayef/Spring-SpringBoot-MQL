package org.mql.biblio.controllers;

import java.util.List;

import org.mql.biblio.models.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authors")
public class AuthorController {
	@Autowired
	private List<Author> authors;

	public AuthorController() {
	}

	// Liste des points terminaux : End-points
	@GetMapping
	public List<Author> getAllAuthors() {
		return authors;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Author> getAuthor(@PathVariable int id) {
		for (Author author : authors) {
			if (author.getId() == id) {
				return ResponseEntity.ok().body(author);
			}
		}
		return ResponseEntity.notFound().build();
	}

	/*
	 * L'annotation RquestBody suppose que la requête est une requête AJAX avec les
	 * données reçus dans le corps de la requête sous format JSON ou XML S'il s'agit
	 * d'une requête POST Ordinaire non AJAX on ne doit pas utiliser cette
	 * annotation.On pourra utiliser par contre l'annotation @ModelAttribute.Si non
	 * on peut utiliser l'annotation @RequestParam sur les parametres passées
	 * individuelement comme parametre du point terminal (endpoint).
	 */

	@PostMapping
	public Author addAuthor(@RequestBody Author author) {
		authors.add(author);
		return author;
	}

	/*
	 * Faire PUTMAPPING ET DELETEMAPPING
	 */

	@DeleteMapping
	public ResponseEntity<Author> removeAuthor(@RequestBody Author author) {
		authors.remove(author);
		return ResponseEntity.ok().body(author);
	}

}
