package org.mql.biblio.dao;

import java.util.List;

import org.mql.biblio.models.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
/*
 * Tous les classes peut être annotées Components
 * A rettenir c'est principal
 * @Component pour les modeles de donnees
 * @Service utiliser pour les services metiers
 * @Repository pour les classes Dao
 * @Controller pour les classes d'actions
 */

@Repository
public class AuthorDaoMemory implements AuthorDao {
	@Autowired
	private List<Author> authros;

	public List<Author> selectAll() {
		return authros;
	}

}
