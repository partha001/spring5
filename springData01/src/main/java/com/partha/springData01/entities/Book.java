package com.partha.springData01.entities;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="books")
public class Book {
	
	@Id
	private String id;
	
	private String name;
	private String author;
	private String category;
	private Integer unitsAvailable;
	
	public Book() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Integer getUnitsAvailable() {
		return unitsAvailable;
	}

	public void setUnitsAvailable(Integer unitsAvailable) {
		this.unitsAvailable = unitsAvailable;
	}
	
}