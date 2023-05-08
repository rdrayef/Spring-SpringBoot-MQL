package org.mql.biblio.dao;

import java.util.List;

import org.mql.biblio.dao.jdbc.Database;
import org.mql.biblio.models.Author;
import org.springframework.stereotype.Repository;

@Repository
public class AuthorDaoJdbc implements AuthorDao {
	private String tableName = "Authors";
	private Database db;

	public AuthorDaoJdbc(Database db) {
		this.db = db;
	}



	@Override
	public List<Author> selectAll() {
		return BiblioMapper.getAuthors(db.select(tableName));
	}


}
