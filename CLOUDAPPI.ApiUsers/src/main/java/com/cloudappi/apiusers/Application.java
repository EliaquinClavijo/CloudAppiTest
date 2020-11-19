package com.cloudappi.apiusers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		System.out.println(System.getenv("PROFILE"));
		SpringApplication.run(Application.class, args);
	}

}
