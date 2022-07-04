package com.zensar.springbootdemo.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	
	//http://localhost:9999/  your port Number
	@RequestMapping("n")
	public String sayHello() {
		return "<h2> Welcome to the spring boot </h2>";
	}
	
	@RequestMapping("/")
	public String Hello() {
		return "<h2> To the world of springboot by Neeraj Nikam !!!!! </h2>";
	}
	
	@RequestMapping("//")
	public String hii() {
		return "<h2> To the world </h2>";
	}
	@RequestMapping("/xyz")
	public String test() {
		return "<h2> xyz </h2>";
	}


}
