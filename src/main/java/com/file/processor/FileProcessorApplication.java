package com.file.processor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@EnableMongoAuditing
@SpringBootApplication
public class FileProcessorApplication {

	public static void main(String[] args) {
		SpringApplication.run(FileProcessorApplication.class, args);
	}

}
