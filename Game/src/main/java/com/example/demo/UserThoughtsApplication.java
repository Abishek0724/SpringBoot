package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UserThoughtsApplication implements CommandLineRunner {
	@Autowired
	private ThoughtService thoughtService;

	public static void main(String[] args) {
		SpringApplication.run(UserThoughtsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		while (true) {
			thoughtService.captureThought();
		}
	}
}