package com.partha.springData01.repositories.impl;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.partha.springData01.entities.Book;
import com.partha.springData01.repositories.CustomBookRepository;


public class CustomBookRepositoryImpl implements CustomBookRepository{
	
	@Autowired
	private MongoTemplate template;

	private static final Logger LOGGER = LoggerFactory.getLogger(CustomBookRepositoryImpl.class);

	@Override
	public List<Book> getMicroserviceJavaBooks() {
		return null;
	}


}
