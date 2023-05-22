package org.mql.biblio.dao;

import java.util.List;

import org.mql.biblio.models.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DocumentRepository extends JpaRepository<Document, String> {
	@Query("SELECT d FROM Document d WHERE d.title LIKE %:keyword")
	public List<Document> findByKeyword(String keyword);

}
