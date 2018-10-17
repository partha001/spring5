package com.partha.springData01ReactiveWrite.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;

@Configuration
@EnableReactiveMongoRepositories(basePackages="com.partha.springData01ReactiveWrite.repositories")
public class ReactiveMongoConfig extends AbstractReactiveMongoConfiguration{


	@Override
	public MongoClient reactiveMongoClient() {
		return MongoClients.create("mongodb://localhost:27017");
	}

	@Override
	protected String getDatabaseName() {
		return "mydatabase";
	}

	@Bean
	public ReactiveMongoTemplate reactiveMongoTemplate() {
		return new ReactiveMongoTemplate(reactiveMongoClient(), getDatabaseName());
	}

}
