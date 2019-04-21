package com.kraftlabs.security.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class WelcomeController {

	@GetMapping("/")
	public ResponseEntity<?> welcome() {
		return ResponseEntity.status(HttpStatus.OK).body("Welcome");
	}

}
