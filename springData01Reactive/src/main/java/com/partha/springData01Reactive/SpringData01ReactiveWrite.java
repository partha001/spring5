package com.partha.springData01Reactive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.partha.springData01Reactive.entities.Book;
import com.partha.springData01Reactive.repositories.BookRepository;

import reactor.core.publisher.Flux;



@SpringBootApplication
public class SpringData01ReactiveWrite implements CommandLineRunner{
	
	@Autowired
	private BookRepository repository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(SpringData01ReactiveWrite.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		
		//Flux<String> just = Flux.just("1", "2", "3");
		
		//Mono<String> just = Mono.just("foo");
		Flux<Book> just= Flux.just(
				new Book("book124","author3","java",201),
				new Book("book125","author3","java",201),
				new Book("book126","author3","java",201)
				);
		
		just.subscribe(book -> repository.save(book));
		
		
		
		System.out.println("finding all books");
		repository.findAll().subscribe(book -> {
			ObjectMapper mapper= new ObjectMapper();
			try {
				String s= mapper.writeValueAsString(book);
				System.out.println("query1"+s);
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
		});
		
	}

}
