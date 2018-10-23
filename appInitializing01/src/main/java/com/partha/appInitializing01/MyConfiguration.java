package com.partha.appInitializing01;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfiguration {
	
	@Bean
	@Conditional(MyCondition.class)
	public Service1 service1(){
		return new Service1();
	}

}
