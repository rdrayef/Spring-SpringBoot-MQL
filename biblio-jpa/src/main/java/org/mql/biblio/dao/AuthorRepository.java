package org.mql.biblio.dao;

import java.util.List;

import org.mql.biblio.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
	/*
	 * JPQL: Java Persistence Query Language C'est une adaptation SQL pour
	 * interroger les entités Plutôt que les tables,Il s'agit de requêtes Orientées
	 * Objets
	 */

	@Query("SELECT a FROM Author a WHERE a.name LIKE :keyword%")
	public List<Author> findByKeyword(String keyword);

}
