package org.mql.biblio.business;

import java.util.List;

import org.mql.biblio.models.Author;
import org.mql.biblio.models.Document;

public interface BiblioService {
	public List<Author> authors();
	public List<Author> authors(String keyword);
	public List<Document> documents(String keyword);
}
