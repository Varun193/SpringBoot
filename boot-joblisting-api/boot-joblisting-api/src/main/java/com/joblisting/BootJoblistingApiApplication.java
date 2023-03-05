package com.joblisting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.joblisting.entites")
public class BootJoblistingApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootJoblistingApiApplication.class, args);
	}

}
