package com.example.demo;

import jakarta.persistence.*;

@Entity
public class Thought {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String message;

	// Constructors
	public Thought() {
	}

	public Thought(String message) {
		this.message = message;
	}

	// Getters & Setters
	public Long getId() {
		return id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}