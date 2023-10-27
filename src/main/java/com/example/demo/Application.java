package com.example.demo;

import java.time.LocalDateTime;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.model.Content;
import com.example.demo.model.Status;
import com.example.demo.model.Type;
import com.example.demo.repository.ContentRepository;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	// populate database during initialization
	@Bean
	CommandLineRunner commandLineRunner(ContentRepository contentRepository) {
		return args -> {
			Content content = new Content(
				null,
				"Post created from CommandLineRunner",
				"A blog post",
				Status.IDEA,
				Type.ARTICLE,
				LocalDateTime.now(),
				null,
				""
			);

			contentRepository.save(content);
		};
	}
}
