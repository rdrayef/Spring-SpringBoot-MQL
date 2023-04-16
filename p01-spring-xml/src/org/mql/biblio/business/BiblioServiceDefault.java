package org.mql.biblio.business;

import java.util.List;

import org.mql.biblio.dao.AuthorDao;
import org.mql.biblio.models.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class BiblioServiceDefault implements BiblioService {
	@Autowired
	@Qualifier("authorDaoMemory")
	private AuthorDao authorDao;

	@Override
	public List<Author> authors() {
		return authorDao.selectAll();
	}

}
