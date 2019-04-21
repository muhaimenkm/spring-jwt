package com.kraftlabs.security.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kraftlabs.security.model.User;
import com.kraftlabs.security.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/{uname}")
	public Optional<ResponseEntity<?>> findUserByName(@PathVariable String uname) {
		Optional<User> user = userService.findByName(uname);
		if (user.isPresent())
			return Optional.of(ResponseEntity.ok().body(user));
		else
			return Optional.of(ResponseEntity.status(HttpStatus.NOT_FOUND).body("No User Found"));
	}

	@GetMapping("/")
	public String welcomeUser(HttpServletRequest request) {
		System.out.println("Data "+request.getAttribute("claims"));
		return "Welcome Secured User";
	}

}
