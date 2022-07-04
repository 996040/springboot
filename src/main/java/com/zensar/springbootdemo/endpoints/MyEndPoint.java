package com.zensar.springbootdemo.endpoints;


import org.springframework.boot.actuate.endpoint.annotation.DeleteOperation;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;

@Endpoint(id = "myEndPoint")
@Component
public class MyEndPoint {
	
	//http://localhost:4444/myactuator/myEndPoint
	
	@ReadOperation
	public String SeyHello() {
		return "Reading...";
	}
	
	@WriteOperation
	public String Hello() {
		return "Writing...";
	
	}
    
	@DeleteOperation
	public String DeleteIt() {
		return "deleting";
	}

}
