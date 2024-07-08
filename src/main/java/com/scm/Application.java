package com.scm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String rawPassword = "password";
		String encodedPassword = encoder.encode(rawPassword);

		System.out.println("Encoded password: " + encodedPassword);
		System.out.println("Matches: " + encoder.matches(rawPassword, encodedPassword));
	}
}
