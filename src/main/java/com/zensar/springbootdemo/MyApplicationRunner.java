package com.zensar.springbootdemo;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;


@Component
public class MyApplicationRunner implements ApplicationRunner {
	
	public void run(ApplicationArguments args) throws Exception{
		System.out.println("Kaikaiii");
	}

}
