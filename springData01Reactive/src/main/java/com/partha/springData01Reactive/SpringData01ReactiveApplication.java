package com.partha.springData01Reactive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.partha.springData01Reactive.repositories.BookRepository;

/**
 * this program shows how data is fetched asynchronously from database
 * @author partha
 *
 */
@SpringBootApplication
public class SpringData01ReactiveApplication implements CommandLineRunner{

	@Autowired
	private BookRepository repository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(SpringData01ReactiveApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
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
		
		
		System.out.println("\n\nfinding books by categoryname");
		repository.findAllByCategory("java").subscribe(book -> {
			ObjectMapper mapper= new ObjectMapper();
			try {
				String s= mapper.writeValueAsString(book);
				System.out.println("query2"+s);
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		});
		
		
		System.out.println("\n\nfinding book with name book123");
		repository.findFirstByAuthor("author1").subscribe(book -> {
			ObjectMapper mapper= new ObjectMapper();
			try {
				String s= mapper.writeValueAsString(book);
				System.out.println("query3"+s);
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		});
		
		
		
		
	}
}
