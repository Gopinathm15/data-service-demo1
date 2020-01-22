package com.datalayer.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.datalayer.domains.User;

public interface UserRepository extends MongoRepository<User, String> {

	List<User> findByAccountNumber(String accountNumber);

	List<User> findByName(String name);
}
