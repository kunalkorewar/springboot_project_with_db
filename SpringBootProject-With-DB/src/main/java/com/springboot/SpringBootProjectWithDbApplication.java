package com.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com")
@EntityScan("com")
public class SpringBootProjectWithDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootProjectWithDbApplication.class, args);
		System.out.println("tomcat start..");
	}

}
