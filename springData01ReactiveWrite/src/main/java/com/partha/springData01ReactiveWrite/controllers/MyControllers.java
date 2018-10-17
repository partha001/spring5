package com.partha.springData01ReactiveWrite.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.partha.springData01ReactiveWrite.entities.Book;
import com.partha.springData01ReactiveWrite.repositories.BookRepository;

import reactor.core.publisher.Flux;

@RestController
public class MyControllers {

	@Autowired
	private BookRepository repository;
	

	@GetMapping("/books")
	public String getBooks(){

		System.out.println("finding all books");
		repository.findAll().subscribe(book -> {

			try {
				ObjectMapper mapper= new ObjectMapper();
				String s= mapper.writeValueAsString(book);
				System.out.println("query1"+s);
			} catch (Exception e) {
				e.printStackTrace();
			}		
		});
		System.out.println("completed");
		return "Hello";
	}
	
	@GetMapping("/insert")
	public String insert(){
		System.out.println("entering some records");
		Flux<Book> just= Flux.just(
				new Book("book124","author3","java",201),
				new Book("book125","author3","java",201),
				new Book("book126","author3","java",201)
				);
		
		this.repository.saveAll(just).subscribe();	
		return "insert completed";
	}

}
