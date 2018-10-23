package com.partha.appInitializing02;

import java.util.function.Supplier;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.GenericApplicationContext;

@SpringBootApplication
public class AppInitializing02Application {

	public static void main(String[] args) {
		
//		//this is one way [however this isnt functional programming]
//		new SpringApplicationBuilder()
//		.sources(FunctionalSpringApplication.class)
//		.run(args);
		
		new SpringApplicationBuilder()
		.sources(FunctionalSpringApplication.class)
		//.initializers(new ApplicationContextInitializer<ConfigurableApplicationContext>() {
		.initializers(new ApplicationContextInitializer<GenericApplicationContext>() {

			@Override
			public void initialize(GenericApplicationContext gac) {
				
				if(Math.random() > .5) {
					gac.regis
					gac.registerBean(ApplicationRunner.class,new Supplier<ApplicationRunner>(){

						@Override
						public ApplicationRunner get() {
							return new ApplicationRunner() {
								
								@Override
								public void run(ApplicationArguments args) throws Exception {
									System.out.println("hello world");
									
								}
							};
						}
						
					});
				};
				
			}
		})
		.run(args);
		
	}
	
	@Bean
	ApplicationRunner runner(){
		return new ApplicationRunner(){

			@Override
			public void run(ApplicationArguments args) throws Exception {
				System.out.println("hello world");
			}
			
			
		};
	}
}
