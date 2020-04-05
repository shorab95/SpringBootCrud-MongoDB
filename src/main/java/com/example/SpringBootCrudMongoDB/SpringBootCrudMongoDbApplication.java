package com.example.SpringBootCrudMongoDB;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
public class SpringBootCrudMongoDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCrudMongoDbApplication.class, args);
	}

}
