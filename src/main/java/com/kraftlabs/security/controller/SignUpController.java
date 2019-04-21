package com.kraftlabs.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kraftlabs.security.model.User;
import com.kraftlabs.security.service.UserService;

@RestController
@RequestMapping("/signup")
public class SignUpController {

	@Autowired
	private UserService userService;

	@PostMapping("/")
	public ResponseEntity<User> saveUser(@RequestBody User u) {
		return ResponseEntity.ok().body(userService.save(u));
	}

}
