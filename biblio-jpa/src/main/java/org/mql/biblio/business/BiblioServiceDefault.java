package org.mql.biblio.business;

import java.util.List;

import org.mql.biblio.dao.AuthorRepository;
import org.mql.biblio.dao.DocumentRepository;
import org.mql.biblio.models.Author;
import org.mql.biblio.models.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BiblioServiceDefault implements BiblioService {
	@Autowired
	private AuthorRepository authorRepository;

	@Autowired
	private DocumentRepository documentRepository;

	public BiblioServiceDefault() {
	}

	@Override
	public List<Author> authors() {
		return authorRepository.findAll();
	}

	@Override
	public List<Author> authors(String keyword) {
		return authorRepository.findByKeyword(keyword);
	}

	@Override
	public List<Document> documents(String keyword) {
		return documentRepository.findByKeyword(keyword);
	}

}
