package com.kraftlabs.security.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kraftlabs.security.model.User;
import com.kraftlabs.security.repo.UserRepo;

@Service
public class UserService {

	@Autowired
	private UserRepo userRepo;

	public User save(User u) {
		return userRepo.save(u);
	}

	public Optional<User> findByName(String uname) {
		return userRepo.findByUname(uname);
	}

}
