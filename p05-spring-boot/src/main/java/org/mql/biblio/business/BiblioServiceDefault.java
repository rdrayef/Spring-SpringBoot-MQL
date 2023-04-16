package org.mql.biblio.business;

import java.util.List;

import org.mql.biblio.dao.AuthorDao;
import org.mql.biblio.models.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BiblioServiceDefault implements BiblioService {
	private AuthorDao authorDao;
	@Autowired
	private String message;

	public BiblioServiceDefault(/* @Qualifier("") */AuthorDao authorDao) {
		super();
		this.authorDao = authorDao;
	}

	@Override
	public List<Author> authors() {
		System.out.println(">>" + message);
		return authorDao.selectAll();
	}

}
