package com.partha.springData01ReactiveWrite.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.partha.springData01ReactiveWrite.entities.Book;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface BookRepository extends ReactiveMongoRepository<Book, String>{
	
	Flux<Book> findAllByCategory(String category);
	
	Mono<Book> findFirstByAuthor(String author);
		
}
