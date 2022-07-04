package com.zensar.springbootdemo;

import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;


@SpringBootApplication
@ComponentScan(basePackages= {"test","com.zensar"})
@OpenAPIDefinition
public class SpringBootDemoApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		System.out.println("Rohit");
		System.out.println("Adding to git Repository");
		
		SpringApplication.run(SpringBootDemoApplication.class, args);
		System.out.println("Virat Kohlii");
	}

	
	
	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}
	
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return super.configure(builder);
	}

}
