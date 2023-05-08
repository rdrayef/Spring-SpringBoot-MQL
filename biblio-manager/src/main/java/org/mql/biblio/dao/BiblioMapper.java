package org.mql.biblio.dao;

import java.util.List;
import java.util.Vector;

import org.mql.biblio.models.Author;

public class BiblioMapper {

	public BiblioMapper() {
	}

	// Méthode de mapping Objet/Relationnel
	public static Author getAuthor(String... row) {
		Author a = new Author();
		try {
			a.setId(Integer.parseInt(row[0]));
			a.setName(row[1]);
			a.setYearBorn(Integer.parseInt(row[2]));

		} catch (Exception e) {
			System.out.println("Erreur: " + e.getMessage());
		}
		return a;
	}

	public static List<Author> getAuthors(String data[][]) {
		List<Author> list = new Vector<>();
		for (int i = 1; i < data.length; i++) {
			list.add(getAuthor(data[i]));
		}
		return list;
	}

}
