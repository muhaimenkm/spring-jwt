package com.kraftlabs.security.controller;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kraftlabs.security.model.Token;
import com.kraftlabs.security.model.User;
import com.kraftlabs.security.service.UserService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private UserService userService;

	@PostMapping("/")
	public ResponseEntity<?> loginUser(@RequestBody User u) {
		Optional<User> user = userService.findByName(u.getUname());
		if (user.isPresent()) {
			if (user.get().getPassword().equals(u.getPassword())) {
				return ResponseEntity.ok()
						.body(new Token(Jwts.builder().setSubject(u.getUname()).claim("password", u.getPassword())
								.setIssuedAt(new Date()).signWith(SignatureAlgorithm.HS512, "123456").compact()));
			} else
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Invalid Password");
		} else
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No User Found");
	}

}
