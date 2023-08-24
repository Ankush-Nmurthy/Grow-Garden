package com.example.growgarden.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
	/**
	 * This method find user by email 
	 * @param email
	 * @return Optinal<User> this may be contain user or not  
	 */
	public Optional<User> findByEmail(String email);
}
