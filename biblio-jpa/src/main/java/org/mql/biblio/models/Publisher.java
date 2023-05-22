package org.mql.biblio.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Publishers")
public class Publisher {
	@Id
	@Column(name = "Publisher_ID")
	private int id;
	private String name;
	private String company;
	
	@OneToMany(mappedBy = "publisher")
	private List<Document> documents;

	public Publisher() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public Publisher(int id, String name, String company) {
		super();
		this.id = id;
		this.name = name;
		this.company = company;
	}

	@Override
	public String toString() {
		return "Publisher [id=" + id + ", name=" + name + ", company=" + company + "]";
	}

}
