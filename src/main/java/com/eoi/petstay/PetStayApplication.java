package com.eoi.petstay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan("com.eoi.petstay.config")
public class PetStayApplication {

	public static void main(String[] args) {
		SpringApplication.run(PetStayApplication.class, args);
	}

}
