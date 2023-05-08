package org.mql.biblio.business;

import java.util.List;

import org.mql.biblio.dao.AuthorDao;
import org.mql.biblio.models.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BiblioServiceDefault implements BiblioService {
	@Autowired
	private AuthorDao authorDao;

	public BiblioServiceDefault() {
	}

	public BiblioServiceDefault(AuthorDao authorDao) {
		this.authorDao = authorDao;
	}

	public AuthorDao getAuthorDao() {
		return authorDao;
	}

	@Override
	public List<Author> authors() {
		return authorDao.selectAll();
	}

	public void setAuthorDao(AuthorDao authorDao) {
		this.authorDao = authorDao;
	}

}
