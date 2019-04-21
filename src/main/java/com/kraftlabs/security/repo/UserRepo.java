package com.kraftlabs.security.repo;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.kraftlabs.security.model.User;

@Repository
public interface UserRepo extends MongoRepository<User, String> {

	public Optional<User> findByUname(String uname);
	
}
