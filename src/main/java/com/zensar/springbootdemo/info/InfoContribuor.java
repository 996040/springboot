package com.zensar.springbootdemo.info;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.actuate.info.Info.Builder;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

@Component
public class InfoContribuor implements InfoContributor {

	@Override
	public void contribute(Builder builder) {
		
		Map<String, Object> studentDetails = new HashMap<String,Object>();
		studentDetails.put("Created By", "Neeraj Nikam");
		studentDetails.put("Modification", "22 july 2022");
		studentDetails.put("Training", "Java_Microservices");
		builder.withDetail("Student", studentDetails);
		
		
		
	}

}
