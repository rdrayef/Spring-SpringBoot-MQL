package org.mql.biblio.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Titles")
public class Document {
	@Id
	private String isbn;
	private String title;
	@Column(name = "Year_Published")
	private int yearPublished;
	//@Column(name = "Publisher_ID", insertable = false, updatable = false)
	//private int publisherId;

	@ManyToOne
	@JoinColumn(name = "Publisher_ID")
	private Publisher publisher;

	public Document() {
		//EntityManager manager;
		//manager.rem
	}

	public Document(String isbn, String title, int yearPublished, int publisherId) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.yearPublished = yearPublished;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getYearPublished() {
		return yearPublished;
	}

	public void setYearPublished(int yearPublished) {
		this.yearPublished = yearPublished;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	@Override
	public String toString() {
		return "Document [isbn=" + isbn + ", title=" + title + ", yearPublished=" + yearPublished + "]";
	}
}
