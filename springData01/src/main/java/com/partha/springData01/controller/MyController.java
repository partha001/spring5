package com.partha.springData01.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.partha.springData01.entities.Book;
import com.partha.springData01.repositories.BookRepository;

@RestController
public class MyController {
	
	@Autowired
	private BookRepository repository;
	
	@GetMapping("/books")
	public List<Book> getBooks(){
		return repository.findAll();
	}
	
	@GetMapping("/books/{id}")
	public Book findById(@PathVariable(value="id") String id){
		 Optional<Book> result = repository.findById(id);
		if(result.isPresent())
			return result.get();
		else
			return null;
	}
	
	@GetMapping("/books/category/{categoryname}")
	public List<Book> getBooksByCategory(@PathVariable(value="categoryname") String category){
		System.out.println(category);
		return repository.findByCategory(category);
	}
	
	@GetMapping("/books/name/{name}")
	public Book getBooksByName(@PathVariable(value="name") String name){
		return repository.findByName(name);
	}	
	
	@PostMapping("/books")
	public Book insert(@RequestBody Book book){
		return repository.save(book);
	}
	
	@PutMapping("/books")
	public Book update(@RequestBody Book book){
		return repository.save(book);
	}
	

}
