package com.api.taskflow.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EntityScan("com.api.taskflow.domain.entities")
@EnableMongoRepositories("com.api.taskflow.infra.repositories")
@ComponentScan({"com.api.taskflow.infra", "com.api.taskflow.main"})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
