package com.partha.appInitializing01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class AppInitializing01Application {
	
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(AppInitializing01Application.class, args);
		System.out.println(context.getBean("service1",Service1.class));
	}
}
