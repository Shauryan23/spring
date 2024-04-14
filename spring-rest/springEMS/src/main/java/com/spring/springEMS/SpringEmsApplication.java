package com.spring.springEMS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories("com.spring.springEMS.repository")
public class SpringEmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringEmsApplication.class, args);
	}

}
