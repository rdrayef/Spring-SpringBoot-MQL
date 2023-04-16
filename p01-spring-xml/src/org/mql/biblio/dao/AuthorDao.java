package org.mql.biblio.dao;

import java.util.List;

import org.mql.biblio.models.Author;

public interface AuthorDao {
	public List<Author> selectAll();
}
