package com.example.demo;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class BikeController {
	private static final String template = "Hello, %s!. Your Favorite Bike is %s!";
	private final AtomicLong atomicLong = new AtomicLong();

	@GetMapping("/bike")
	public String getBike(@RequestParam String name, @RequestParam String favbike) {
		return String.format(atomicLong.incrementAndGet() + " . " + template, name, favbike);
	}

}
