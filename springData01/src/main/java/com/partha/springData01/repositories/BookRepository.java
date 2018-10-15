package com.partha.springData01.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.partha.springData01.entities.Book;

@Repository
public interface BookRepository extends MongoRepository<Book, String> , CustomBookRepository {

	public List<Book> findByCategory(String category);
	
	public Book findByName(String name);
	
}
