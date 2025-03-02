package com.example.demo;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ThoughtService {
	@Autowired
	private ThoughtRepository repository;

	public void captureThought() {
		Scanner scanner = new Scanner(System.in);

		System.out.print("\nWhat's on your mind today? (Enter a name, number, or thought): ");
		String input = scanner.nextLine();

		Thought thought = new Thought(input);
		repository.save(thought);
		System.out.println("✔ Thought saved!\n");

		displayAllThoughts();
	}

	private void displayAllThoughts() {
		List<Thought> thoughts = repository.findAll();
		System.out.println("\n--- All Shared Thoughts ---");
		for (Thought t : thoughts) {
			System.out.println(t.getId() + ". " + t.getMessage());
		}
	}
}